// ============================================================================
//
// Copyright (C) 2006-2021 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.core.ui.editor.properties.controllers.generator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.talend.core.ui.properties.tab.IDynamicProperty;
import org.talend.designer.core.ui.editor.properties.controllers.IControllerContext;
import org.talend.designer.core.ui.editor.properties.controllers.ISWTBusinessControllerUI;
import org.talend.designer.core.ui.editor.properties.controllers.executors.IControllerExecutor;

/**
 * DOC yzhang class global comment. Detailled comment <br/>
 *
 * $Id: ControllerGenerator.java 1 2006-12-22 下午03:13:13 +0000 (下午03:13:13) yzhang $
 *
 */
public interface IControllerGenerator {

    public ISWTBusinessControllerUI generate();

    public void setDynamicProperty(IDynamicProperty dp);

    default String getControllerName() {
        throw new UnsupportedOperationException("Implement it!! => " + this.getClass().getCanonicalName());
    }

    default IControllerExecutor createExecutor(IControllerContext ctx) {
        throw new UnsupportedOperationException("Implement it!! => " + this.getClass().getCanonicalName());
    }

    default <T> T getImplementation(Class<T> clazz) {
        BundleContext bc = FrameworkUtil.getBundle(IControllerGenerator.class).getBundleContext();
        ServiceReference<T> serviceReference = bc.getServiceReference(clazz);
        return bc.getService(serviceReference);
    }

}
