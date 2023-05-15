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
package org.talend.designer.core.ui.editor.properties.controllers.ui;

import org.talend.core.model.process.IElement;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.sqlbuilder.util.ConnectionParameters;

/**
 * DOC cmeng  class global comment. Detailled comment
 */
public interface IBusinessControllerUI extends IControllerUI {

    void openSqlBuilder(ConnectionParameters connParameters);

    void openSqlBuilderBuildIn(final ConnectionParameters connParameters, final String propertyName);

    String openSqlBuilder(IElement elem, ConnectionParameters connParameters, String key, String repoName, String repositoryId,
            String processName, String query);

    ConnectionItem getConnectionItem();

}
