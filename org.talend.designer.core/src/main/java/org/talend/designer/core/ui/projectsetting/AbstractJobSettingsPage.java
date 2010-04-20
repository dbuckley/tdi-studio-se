// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.core.ui.projectsetting;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.exception.ExceptionHandler;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.CorePlugin;
import org.talend.core.model.context.ContextUtils;
import org.talend.core.model.metadata.builder.connection.Connection;
import org.talend.core.model.process.EComponentCategory;
import org.talend.core.model.process.EParameterFieldType;
import org.talend.core.model.process.Element;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.properties.ContextItem;
import org.talend.core.model.properties.ProcessItem;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.RepositoryManager;
import org.talend.designer.core.model.components.EParameterName;
import org.talend.designer.core.model.components.EmfComponent;
import org.talend.designer.core.model.utils.emf.talendfile.ParametersType;
import org.talend.designer.core.ui.editor.cmd.ChangeValuesFromRepository;
import org.talend.designer.core.ui.editor.cmd.LoadProjectSettingsCommand;
import org.talend.designer.core.ui.editor.process.Process;
import org.talend.designer.core.ui.views.properties.WidgetFactory;
import org.talend.designer.core.utils.DetectContextVarsUtils;
import org.talend.repository.UpdateRepositoryUtils;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.ProjectRepositoryNode;
import org.talend.repository.model.ProxyRepositoryFactory;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.RepositoryNode.ENodeType;
import org.talend.repository.preference.ProjectSettingPage;
import org.talend.repository.ui.views.IRepositoryView;
import org.talend.repository.ui.views.RepositoryContentProvider;
import org.talend.repository.ui.wizards.metadata.ShowAddedContextdialog;

/**
 * cli class global comment. Detailled comment
 */
public abstract class AbstractJobSettingsPage extends ProjectSettingPage {

    protected final IProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();

    private ProjectSettingMultipleThreadDynamicComposite mComposite;

    private Element elem;

    private WidgetFactory widgetFactory = new WidgetFactory();

    private List<IProcess> openedProcessList = new ArrayList<IProcess>();

    private List<RepositoryNode> checkedNode = new ArrayList<RepositoryNode>();

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createContents(Composite parent) {
        Composite composite = widgetFactory.createComposite(parent, SWT.NONE);
        composite.setLayout(new FormLayout());
        FormData data = createFormData();
        composite.setLayoutData(data);
        //
        checkSettingExisted();

        elem = checkAndCreateElement();
        if (getParametersType() != null) {
            ElementParameter2ParameterType.loadElementParameters(elem, getParametersType(), getPropertyTypeName());
        }
        // 
        mComposite = new ProjectSettingMultipleThreadDynamicComposite(composite, SWT.V_SCROLL | SWT.BORDER, getCategory(), elem,
                true);
        mComposite.setLayoutData(createFormData());
        return composite;
    }

    protected abstract void checkSettingExisted();

    protected abstract Element checkAndCreateElement();

    protected abstract EComponentCategory getCategory();

    @Override
    public void dispose() {
        if (widgetFactory != null)
            widgetFactory.dispose();
        super.dispose();
    }

    protected FormData createFormData() {
        FormData data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, 0);
        data.bottom = new FormAttachment(100, 0);
        return data;
    }

    protected abstract ParametersType getParametersType();

    protected abstract String getPropertyTypeName();

    protected abstract String getRepositoryPropertyName();

    protected abstract EParameterName getParameterName();

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.repository.preference.ProjectSettingPage#refresh()
     */
    @Override
    public void refresh() {
        if (mComposite != null) {
            ElementParameter2ParameterType.loadElementParameters(elem, getParametersType(), getPropertyTypeName());
            mComposite.refresh();
        }

    }

    protected boolean isStatUseProjectSetting(RepositoryNode node) {
        Property property = node.getObject().getProperty();
        ProcessItem pItem = (ProcessItem) property.getItem();
        ParametersType pType = pItem.getProcess().getParameters();

        String statB = ElementParameter2ParameterType.getParameterValue(pType, getParameterName().getName());

        return Boolean.parseBoolean(statB);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.PreferencePage#performApply()
     */
    @Override
    protected void performApply() {
        performOk();
        super.performApply();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.PreferencePage#performOk()
     */
    @Override
    public boolean performOk() {

        if (mComposite != null && mComposite.isCommandExcute()) {
            // save to the memory
            ParametersType parametersType = getParametersType();
            if (parametersType != null) {
                ElementParameter2ParameterType.saveElementParameters(elem, parametersType);
            }
            ProjectSettingManager.saveProject();
            save();
        }

        // if (parameters != null) {
        // ElementParameter2ParameterType.loadProjectsettingsParameters(parameters);
        // }
        return super.performOk();
    }

    protected void exeCommand(final Process process, final Command cmd) {
        Display display = Display.getCurrent();
        if (display == null) {
            display = Display.getDefault();
        }
        if (display != null) {
            display.asyncExec(new Runnable() {

                public void run() {
                    process.getCommandStack().execute(cmd);
                }
            });
        } else {
            cmd.execute();
        }
    }

    protected IEditorReference[] getEditors() {
        final List<IEditorReference> list = new ArrayList<IEditorReference>();
        Display.getDefault().syncExec(new Runnable() {

            public void run() {
                IEditorReference[] reference = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .getEditorReferences();
                list.addAll(Arrays.asList(reference));
            }
        });
        return list.toArray(new IEditorReference[0]);
    }

    protected void processItems(List<RepositoryNode> objects, RepositoryNode node) {
        if (node == null) {
            return;
        }
        if (node.getType() == ENodeType.REPOSITORY_ELEMENT) {
            if (node.getObject() != null) {
                objects.add(node);
            }
        } else {
            for (RepositoryNode child : node.getChildren()) {
                processItems(objects, child);
            }
        }
    }

    protected org.talend.designer.core.ui.editor.process.Process getProcess(List<IProcess> list, RepositoryNode p) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(p.getId())) {
                return (org.talend.designer.core.ui.editor.process.Process) list.get(i);
            }
        }
        return null;
    }

    protected boolean isOpenProcess(RepositoryNode node) {
        Property property = node.getObject().getProperty();
        if (property.getItem() instanceof ProcessItem) {
            for (IProcess process : openedProcessList) {
                if (process.getId().equals(property.getId()) && process.getLabel().equals(property.getLabel())
                        && process.getVersion().equals(property.getVersion())) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<ContextItem> allContextItems;

    private boolean addContextModel = false;

    protected void save() {
        List<String> checkedObjects = new ArrayList<String>();
        IRepositoryView repositoryView = RepositoryManager.getRepositoryView();
        RepositoryNode root = ((RepositoryContentProvider) repositoryView.getViewer().getContentProvider()).getRoot();
        RepositoryNode processNode = ((ProjectRepositoryNode) root).getRootRepositoryNode(ERepositoryObjectType.PROCESS);
        List<RepositoryNode> objects = new ArrayList<RepositoryNode>();
        processItems(objects, processNode);
        for (RepositoryNode node : objects) {
            if (isStatUseProjectSetting(node)) {
                if (!checkedObjects.contains(node.getObject().getProperty().getId())) {
                    checkedObjects.add(node.getObject().getProperty().getId());
                    checkedNode.add(node);
                }
            }
        }

        List<IProcess> allOpenedProcessList = CorePlugin.getDefault().getDesignerCoreService().getOpenedProcess(getEditors());
        if (allOpenedProcessList != null) {
            for (int i = 0; i < allOpenedProcessList.size(); i++) {
                if (checkedObjects.contains(allOpenedProcessList.get(i).getProperty().getId())) {
                    openedProcessList.add(allOpenedProcessList.get(i));
                }
            }
        }
        // 

        final IRunnableWithProgress runnable = new IRunnableWithProgress() {

            public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                monitor.beginTask(getTaskMessages(), (checkedNode.size()) * 100);
                final Map<String, Set<String>> contextVars = DetectContextVarsUtils.detectByPropertyType(elem, true);
                addContextModel = false; // must init this
                if (!contextVars.isEmpty()) {
                    // if the context is not existed in job, will add or not.
                    Display disp = Display.getCurrent();
                    if (disp == null) {
                        disp = Display.getDefault();
                    }
                    if (disp != null) {
                        disp.syncExec(new Runnable() {

                            public void run() {
                                showContextAndCheck(contextVars);
                            }
                        });
                    } else {
                        showContextAndCheck(contextVars);
                    }
                }
                monitor.worked(10);

                for (RepositoryNode node : checkedNode) {
                    saveProcess(node, addContextModel, contextVars, monitor);
                }
                monitor.done();
            }
        };

        final ProgressMonitorDialog dialog = new ProgressMonitorDialog(null);
        try {
            dialog.run(true, true, runnable);
        } catch (InvocationTargetException e) {
            ExceptionHandler.process(e);
        } catch (InterruptedException e) {
            ExceptionHandler.process(e);
        }

    }

    private void showContextAndCheck(final Map<String, Set<String>> contextVars) {

        ShowAddedContextdialog showDialog = new ShowAddedContextdialog(contextVars, true);
        if (showDialog.open() == Window.OK) {
            allContextItems = ContextUtils.getAllContextItem();
            addContextModel = true;
        }
    }

    protected abstract String getTaskMessages();

    protected void saveProcess(RepositoryNode node, boolean addContextModel, Map<String, Set<String>> contextVars,
            IProgressMonitor monitor) {
        Property property = node.getObject().getProperty();
        ProcessItem pItem = (ProcessItem) property.getItem();

        if (isOpenProcess(node)) {
            Process process = getProcess(openedProcessList, node);
            LoadProjectSettingsCommand command = new LoadProjectSettingsCommand(process, getParameterName().getName(),
                    Boolean.TRUE);
            exeCommand(process, command);
            // 
            IElementParameter ptParam = elem.getElementParameterFromField(EParameterFieldType.PROPERTY_TYPE);
            if (ptParam != null) {
                IElementParameter propertyElem = ptParam.getChildParameters().get(EParameterName.PROPERTY_TYPE.getName());
                Object proValue = propertyElem.getValue();
                if (proValue instanceof String && ((String) proValue).equalsIgnoreCase(EmfComponent.REPOSITORY)) {
                    IElementParameter repositoryElem = ptParam.getChildParameters().get(
                            EParameterName.REPOSITORY_PROPERTY_TYPE.getName());
                    String value = (String) repositoryElem.getValue();
                    ConnectionItem connectionItem = UpdateRepositoryUtils.getConnectionItemByItemId(value);
                    if (connectionItem != null) {
                        Connection connection = connectionItem.getConnection();
                        ChangeValuesFromRepository cmd = new ChangeValuesFromRepository(process, connection,
                                addContextModel ? getRepositoryPropertyName() : getPropertyTypeName(), value);
                        cmd.ignoreContextMode(true);
                        exeCommand(process, cmd);
                    }
                }
            }

            monitor.worked(100);
        } else {
            try {
                reloadFromProjectSetings(pItem, addContextModel, contextVars);
                factory.save(pItem);
                monitor.worked(100);
            } catch (PersistenceException e) {
                ExceptionHandler.process(e);
            }

        }
    }

    protected void reloadFromProjectSetings(ProcessItem pItem, boolean addContextModel, Map<String, Set<String>> contextVars) {
        if (pItem != null) {
            ParametersType pType = pItem.getProcess().getParameters();
            if (getParameterName() == EParameterName.IMPLICITCONTEXT_USE_PROJECT_SETTINGS) {
                ProjectSettingManager.reloadImplicitValuesFromProjectSettings(pType, pro);
            } else if (getParameterName() == EParameterName.STATANDLOG_USE_PROJECT_SETTINGS) {
                ProjectSettingManager.reloadStatsAndLogFromProjectSettings(pType, pro);
            }
            if (addContextModel && !contextVars.isEmpty() && allContextItems != null) {
                ContextUtils.addInContextModelForProcessItem(pItem, contextVars, allContextItems);
            }
        }
    }
}
