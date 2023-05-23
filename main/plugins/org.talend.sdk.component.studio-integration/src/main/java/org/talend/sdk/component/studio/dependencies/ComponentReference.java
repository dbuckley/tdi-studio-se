package org.talend.sdk.component.studio.dependencies;

public class ComponentReference {
    private final String mavenReference;

    public ComponentReference(String mavenReference) {
        this.mavenReference = mavenReference;
    }

    public String getMavenReference() {
        return mavenReference;
    }
}
