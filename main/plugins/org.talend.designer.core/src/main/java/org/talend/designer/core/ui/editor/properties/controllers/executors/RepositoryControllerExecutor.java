// ============================================================================
//
// Copyright (C) 2006-2023 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.core.ui.editor.properties.controllers.executors;

import org.eclipse.gef.commands.Command;
import org.talend.core.model.metadata.builder.connection.Connection;
import org.talend.core.model.process.IElement;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.properties.Item;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.designer.core.model.components.EParameterName;
import org.talend.designer.core.model.components.EmfComponent;
import org.talend.designer.core.ui.editor.cmd.ChangeMetadataCommand;
import org.talend.designer.core.ui.editor.nodes.Node;
import org.talend.designer.core.ui.editor.properties.controllers.AbstractRepositoryController;
import org.talend.designer.core.ui.editor.properties.controllers.IControllerContext;
import org.talend.repository.UpdateRepositoryUtils;


/**
 * DOC cmeng  class global comment. Detailled comment
 */
public abstract class RepositoryControllerExecutor extends ControllerExecutorForCustomUI {

    protected static final String REPOSITORY_CHOICE = AbstractRepositoryController.REPOSITORY_CHOICE;

    protected abstract String getRepositoryTypeParamName();

    protected abstract String getRepositoryChoiceParamName();

    protected abstract Command createCommand(IControllerContext button);

    protected void handleWidgetEvent(Command cmd) {
        if (cmd instanceof ChangeMetadataCommand) {
            ((ChangeMetadataCommand) cmd).setConnection(getConnection());
        }
        executeCommand(cmd);
    }

    @Override
    public boolean execute() {
        Command cmd = createCommand(getControllerContext());
        if (cmd == null) {
            return false;
        }
        handleWidgetEvent(cmd);
        return true;
    }

    protected Connection getConnection() {
        IElement elem = getControllerContext().getElement();
        if (elem == null) {
            return null;
        }
        if (elem instanceof Node) {
            IElementParameter elementParameter = ((Node) elem).getElementParameter(EParameterName.PROPERTY_TYPE.getName());
            if (elementParameter != null && !EmfComponent.BUILTIN.equals(elementParameter.getValue())) {
                String propertyValue = (String) (((Node) elem)
                        .getPropertyValue(EParameterName.REPOSITORY_PROPERTY_TYPE.getName()));
                IRepositoryViewObject lastVersion = UpdateRepositoryUtils.getRepositoryObjectById(propertyValue);
                if (lastVersion != null) {
                    final Item item = lastVersion.getProperty().getItem();
                    if (item != null && item instanceof ConnectionItem) {
                        Connection repositoryConn = ((ConnectionItem) item).getConnection();
                        return repositoryConn;
                    }
                }
            }
        }
        return null;

    }

}
