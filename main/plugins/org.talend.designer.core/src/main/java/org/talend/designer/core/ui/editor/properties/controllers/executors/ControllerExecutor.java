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

import org.talend.designer.core.ui.editor.properties.controllers.IControllerContext;
import org.talend.designer.core.ui.editor.properties.controllers.ui.IControllerUI;

/**
 * DOC cmeng  class global comment. Detailled comment
 */
public abstract class ControllerExecutor implements IControllerExecutor {

    private IControllerContext ctx;

    private IControllerUI ui;

    @Override
    public void init(IControllerContext ctx, IControllerUI ui) {
        this.ctx = ctx;
        this.ui = ui;
    }

    @Override
    public boolean execute() {
        throw new UnsupportedOperationException(
                "Implement it in fragments for different Platform!! => " + this.getClass().getCanonicalName());
    }

    protected IControllerContext getControllerContext() {
        return this.ctx;
    }

    protected IControllerUI getUi() {
        return ui;
    }

    protected boolean isInWizard() {
        return ctx.isInWizard();
    }

}
