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
package org.talend.repository.ui.dialog;

import org.eclipse.swt.widgets.Shell;
import org.talend.commons.ui.runtime.custom.AbsBusinessHandler;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.repository.model.RepositoryNode;

/**
 * DOC cmeng  class global comment. Detailled comment
 */
public class RepositoryReviewBusinessHandler extends AbsBusinessHandler<RepositoryReviewBusinessHandler> {

    private static final String UI_KEY = "RepositoryReviewDialog";

    private Shell parentShell;

    private ERepositoryObjectType type;

    private String repositoryType;

    private RepositoryNode result;

    public RepositoryReviewBusinessHandler(Shell parentShell, ERepositoryObjectType type, String repositoryType) {
        this.parentShell = parentShell;
        this.type = type;
        this.repositoryType = repositoryType;
    }

    public Shell getParentShell() {
        return parentShell;
    }

    public void setParentShell(Shell parentShell) {
        this.parentShell = parentShell;
    }

    public ERepositoryObjectType getType() {
        return type;
    }

    public void setType(ERepositoryObjectType type) {
        this.type = type;
    }

    public String getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(String repositoryType) {
        this.repositoryType = repositoryType;
    }

    @Override
    public String getUiKey() {
        return UI_KEY;
    }

    public RepositoryNode getResult() {
        return result;
    }

    public void setResult(RepositoryNode result) {
        this.result = result;
    }

}
