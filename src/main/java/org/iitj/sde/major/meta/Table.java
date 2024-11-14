package org.iitj.sde.major.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Represents a table that stores and manages a collection of records.
 * A table has a unique name and can store multiple records. It provides methods to insert,
 * query, update, and delete records based on specific conditions.
 */
public class Table {
    private String name;
    private List<MyRecord> myRecords;

    /**
     * Constructs a new table with the given name.
     *
     * @param name the name of the table
     */
    public Table(String name) {
        this.name = name;
        this.myRecords = new ArrayList<>();
    }

    /**
     * Inserts a new record into the table.
     *
     * @param fieldValues a map containing the values for each field in the record
     */
    public void insertRecord(Map<String, Object> fieldValues) {
        myRecords.add(new MyRecord(fieldValues));
    }

    /**
     * Queries the table for records that match the specified condition.
     *
     * @param condition a predicate that defines the condition for selecting records
     * @return a list of records that match the condition
     */
    public List<MyRecord> query(Predicate<MyRecord> condition) {
        return myRecords.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    /**
     * Updates records in the table that match the specified condition.
     *
     * @param condition a predicate that defines the condition for updating records
     * @param updates   a map containing the updated values for each field
     * @return the number of records updated
     */
    public int update(Predicate<MyRecord> condition, Map<String, Object> updates) {
        int updatedCount = 0;
        for (MyRecord myRecord : myRecords) {
            if (condition.test(myRecord)) {
                updates.forEach(myRecord::setField);
                updatedCount++;
            }
        }
        return updatedCount;
    }

    /**
     * Deletes records from the table that match the specified condition.
     *
     * @param condition a predicate that defines the condition for deleting records
     * @return the number of records deleted
     */
    public int delete(Predicate<MyRecord> condition) {
        int initialSize = myRecords.size();
        myRecords.removeIf(condition);
        return initialSize - myRecords.size();
    }

    /**
     * Returns the name of the table.
     *
     * @return the table name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the table, including all its records.
     *
     * @return a string representation of the table
     */
    @Override
    public String toString() {
        return myRecords.toString();
    }
}
