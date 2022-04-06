package org.talend.repository.model.migration;

import org.talend.commons.exception.ExceptionHandler;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.utils.PasswordEncryptUtil;
import org.talend.core.language.ECodeLanguage;
import org.talend.core.model.components.ComponentUtilities;
import org.talend.core.model.components.ModifyComponentsAction;
import org.talend.core.model.components.conversions.IComponentConversion;
import org.talend.core.model.components.filters.IComponentFilter;
import org.talend.core.model.components.filters.NameComponentFilter;
import org.talend.core.model.migration.AbstractJobMigrationTask;
import org.talend.core.model.properties.Item;
import org.talend.designer.core.model.utils.emf.talendfile.ElementParameterType;
import org.talend.designer.core.model.utils.emf.talendfile.NodeType;
import org.talend.designer.core.model.utils.emf.talendfile.ProcessType;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EncryptClientSecretMicrosoftCRMMigrationTask extends AbstractJobMigrationTask {

    @Override
    public ExecutionResult execute(Item item) {
        ProcessType processType = getProcessType(item);
        if (getProject().getLanguage() != ECodeLanguage.JAVA || processType == null) {
            return ExecutionResult.NOTHING_TO_DO;
        }

        String[] componentsNameToAffect = {
                "tMicrosoftCrmInput",
                "tMicrosoftCrmOutput"
        };

        IComponentConversion encryptClientSecret = new IComponentConversion() {
            @Override
            public void transform(NodeType node) {
                ElementParameterType client_secret = ComponentUtilities.getNodeProperty(node, "CLIENT_SECRET");

                if ("TEXT".equals(client_secret.getField())) {
                    client_secret.setField("PASSWORD");

                    try {
                        String encryptedPassword = PasswordEncryptUtil.encryptPasswordHex(client_secret.getValue());
                        client_secret.setValue(encryptedPassword);
                    } catch (Exception e) {
                        client_secret.setValue("");
                    }
                }
            }
        };

        for (String componentName : componentsNameToAffect) {
            IComponentFilter componentFilter = new NameComponentFilter(componentName);

            try {
                ModifyComponentsAction.searchAndModify(item, processType,
                        componentFilter, Arrays.asList(encryptClientSecret));
            } catch (PersistenceException e) {
                ExceptionHandler.process(e);
                return ExecutionResult.FAILURE;
            }
        }

        return ExecutionResult.SUCCESS_NO_ALERT;
    }

    @Override
    public Date getOrder() {
        GregorianCalendar gc = new GregorianCalendar(2022, Calendar.MARCH, 21, 17, 0, 0);
        return gc.getTime();
    }
}
