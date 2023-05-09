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

import java.util.List;

import org.talend.core.model.process.EComponentCategory;
import org.talend.core.model.process.EParameterFieldType;
import org.talend.core.model.process.IContextManager;
import org.talend.core.model.process.IElement;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.Problem;
import org.talend.core.sqlbuilder.util.ConnectionParameters;

/**
 * DOC cmeng  class global comment. Detailled comment
 */
public abstract class AbsControllerContext implements IControllerContext {

    private IElement element;

    private IElementParameter curParameter;

    private ConnectionParameters connParameters;

    private EParameterFieldType paramFieldType;

    private INode connectionNode;

    private IContextManager contextManager;

    private EComponentCategory section;

    private List<Problem> codeProblems;

    public AbsControllerContext(IElement element, IElementParameter curParameter) {
        this.element = element;
        this.curParameter = curParameter;
    }

    @Override
    public ConnectionParameters getConnParameters() {
        return connParameters;
    }

    @Override
    public void setConnParameters(ConnectionParameters connParameters) {
        this.connParameters = connParameters;
    }

    @Override
    public IElement getElement() {
        return element;
    }

    @Override
    public void setElement(IElement element) {
        this.element = element;
    }

    @Override
    public IElementParameter getCurParameter() {
        return curParameter;
    }

    @Override
    public void setCurParameter(IElementParameter curParameter) {
        this.curParameter = curParameter;
    }

    @Override
    public INode getConnectionNode() {
        return connectionNode;
    }

    @Override
    public void setConnectionNode(INode connectionNode) {
        this.connectionNode = connectionNode;
    }

    @Override
    public EParameterFieldType getParamFieldType() {
        return paramFieldType;
    }

    @Override
    public void setParamFieldType(EParameterFieldType paramFieldType) {
        this.paramFieldType = paramFieldType;
    }

    @Override
    public IContextManager getContextManager() {
        return contextManager;
    }

    @Override
    public void setContextManager(IContextManager contextManager) {
        this.contextManager = contextManager;
    }

    @Override
    public EComponentCategory getSection() {
        return section;
    }

    @Override
    public void setSection(EComponentCategory section) {
        this.section = section;
    }

    @Override
    public List<Problem> getCodeProblems() {
        return codeProblems;
    }

    @Override
    public void setCodeProblems(List<Problem> codeProblems) {
        this.codeProblems = codeProblems;
    }

}
