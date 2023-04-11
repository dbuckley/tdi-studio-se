// ============================================================================
//
// Copyright (C) 2006-2022 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.core.ui.editor.properties.controllers;

import java.lang.reflect.Method;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.talend.commons.exception.ExceptionHandler;

/**
 * DOC cmeng  class global comment. Detailled comment
 */
public class StudioControllerContext extends AbsControllerContext {

    private Control control;

    public StudioControllerContext(Control control) {
        super();
        this.control = control;
    }

    @Override
    public Object getData(String param) {
        return this.control.getData(param);
    }

    @Override
    public void setData(String param, Object value) {
        this.control.setData(param, value);
    }

    @Override
    public String getText() {
        Method getText;
        try {
            getText = this.control.getClass().getDeclaredMethod("getText");
            getText.setAccessible(true);
            return (String) getText.invoke(this.control);
        } catch (Exception e) {
            ExceptionHandler.process(e);
        }
        return null;
    }

    public Shell getShell() {
        return this.control.getShell();
    }

}
