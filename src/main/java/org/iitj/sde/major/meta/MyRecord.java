package org.iitj.sde.major.meta;

import java.util.HashMap;
import java.util.Map;

public class MyRecord {
    private Map<String, Object> fields;

    public MyRecord() {
        fields = new HashMap<>();
    }

    public MyRecord(Map<String, Object> fields) {
        this.fields = new HashMap<>(fields);
    }

    public Object getField(String fieldName) {
        return fields.get(fieldName);
    }

    public void setField(String fieldName, Object value) {
        fields.put(fieldName, value);
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return fields.toString();
    }
}
