package org.talend.sdk.component.studio.dependencies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.INode;
import org.talend.sdk.component.server.front.model.ComponentDetail;
import org.talend.sdk.component.studio.Lookups;
import org.talend.sdk.component.studio.model.parameter.ListPropertyNode;
import org.talend.sdk.component.studio.model.parameter.PropertyNode;

public interface ComponentReferenceFinder {
    Stream<ComponentReference> find(final PropertyNode property, final INode node);

    static ComponentReferenceFinder getFinder(final PropertyNode property) {
        if (property instanceof ListPropertyNode) {
            return new ListPropertyReferenceFinder();
        }
        return new PropertyReferenceFinder();
    }

    class PropertyReferenceFinder implements ComponentReferenceFinder {
        @Override
        public Stream<ComponentReference> find(PropertyNode property, INode node) {
            final List<PropertyNode> children = property.getChildren();
            String mavenReferences = null;
            for (PropertyNode child : children) {
                final String path = child.getProperty().getPath();
                final IElementParameter elementParameter = node.getElementParameter(path);
                final Object value = elementParameter.getValue();
                if (value != null && path.endsWith(".mavenReference")) {
                    mavenReferences = String.valueOf(value);
                }
            }
            return Stream.of(new ComponentReference(mavenReferences));
        }
    }

    class ListPropertyReferenceFinder implements ComponentReferenceFinder {
        @Override
        public Stream<ComponentReference> find(PropertyNode property, INode node) {
            if (!(property instanceof ListPropertyNode)) {
                return Stream.empty();
            }
            final List<ComponentReference> details = new ArrayList<>();
            final String path = property.getProperty().getPath();
            final IElementParameter elementParameter = node.getElementParameter(path);
            final Object values = elementParameter.getValue();
            if (values instanceof List) {
                for (Object value : (List) values) {
                    if (value instanceof Map) {
                        Map map = (Map)value;
                        String mavenReferences = null;
                        for (Object key : map.keySet()) {
                            if (key.toString().endsWith(".mavenReference")) {
                                mavenReferences = (String)map.get(key);
                            }                           
                        }
                        details.add(new ComponentReference(mavenReferences));
                    }
                }
            }
            return details.stream();
        }
    }
}
