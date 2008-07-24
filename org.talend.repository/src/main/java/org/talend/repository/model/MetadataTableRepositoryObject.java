// ============================================================================
//
// Copyright (C) 2006-2007 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.repository.model;

import org.talend.core.model.metadata.MetadataTable;
import org.talend.core.model.metadata.builder.connection.AbstractMetadataObject;
import org.talend.core.model.properties.Property;
import org.talend.core.model.repository.IRepositoryObject;

/**
 * DOC nrousseau class global comment. Detailled comment
 */
public class MetadataTableRepositoryObject extends MetadataTable implements ISubRepositoryObject {

    private final IRepositoryObject repObj;

    private final org.talend.core.model.metadata.builder.connection.MetadataTable table;

    public MetadataTableRepositoryObject(IRepositoryObject repObj,
            org.talend.core.model.metadata.builder.connection.MetadataTable table) {
        this.repObj = repObj;
        this.table = table;
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (adapter == org.talend.core.model.metadata.builder.connection.MetadataTable.class) {
            return table;
        }
        return null;
    }

    @Override
    public Property getProperty() {
        return repObj.getProperty();
    }

    @Override
    public void setProperty(Property property) {
        repObj.setProperty(property);
    }

    @Override
    public String getVersion() {
        return repObj.getVersion();
    }

    @Override
    public String getLabel() {
        return table.getLabel();
    }

    @Override
    public String getId() {
        return table.getId();
    }

    public String getTableType() {
        return table.getTableType();
    }

    public org.talend.core.model.metadata.builder.connection.MetadataTable getTable() {
        return this.table;
    }

    public AbstractMetadataObject getAbstractMetadataObject() {
        return getTable();
    }

    public void removeFromParent() {
        table.getConnection().getTables().remove(table);
    }
}
