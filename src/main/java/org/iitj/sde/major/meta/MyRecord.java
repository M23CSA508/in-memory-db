package org.iitj.sde.major.meta;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a record that stores key-value pairs as fields. This class allows you to create,
 * retrieve and modify these fields dynamically.
 *
 */
public class MyRecord {
    private Map<String, Object> fields;

    /**
     * Constructs an empty MyRecord object.
     */
    public MyRecord() {
        fields = new HashMap<>();
    }

    /**
     * Constructs a MyRecord object initialized with the provided map of fields.
     *
     * @param fields the initial fields for this record
     */
    public MyRecord(Map<String, Object> fields) {
        this.fields = new HashMap<>(fields);
    }

    /**
     * Retrieves the value associated with the specified field name.
     *
     * @param fieldName the name of the field to retrieve
     * @return the value associated with the field, or null if no such field exists
     */
    public Object getField(String fieldName) {
        return fields.get(fieldName);
    }

    /**
     * Sets the value associated with the specified field name.
     *
     * @param fieldName the name of the field to update
     * @param value the new value for the field
     */
    public void setField(String fieldName, Object value) {
        fields.put(fieldName, value);
    }

    /**
     * Returns a copy of all fields stored in this record.
     *
     * @return a map containing all fields and their values
     */
    public Map<String, Object> getFields() {
        return fields;
    }

    /**
     * Returns a string representation of this record, listing all its fields and their values.
     *
     * @return a string representation of this record
     */
    @Override
    public String toString() {
        return fields.toString();
    }
}
