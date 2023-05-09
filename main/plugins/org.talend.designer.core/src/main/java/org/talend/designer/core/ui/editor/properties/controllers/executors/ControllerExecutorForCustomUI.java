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
import org.talend.designer.core.ui.editor.properties.controllers.AbstractElementPropertySectionController;


/**
 * DOC cmeng  class global comment. Detailled comment
 */
public abstract class ControllerExecutorForCustomUI extends ControllerExecutor {

    public static final String PARAMETER_NAME = AbstractElementPropertySectionController.PARAMETER_NAME;

    public static final String NAME = AbstractElementPropertySectionController.NAME;

    protected static final String COLUMN = AbstractElementPropertySectionController.COLUMN;

    public void executeCommand(Command c) {
        if (c == null) {
            return;
        }
        // if can't find command stack, just execute it.
        c.execute();
    }

}
