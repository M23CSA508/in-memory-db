package org.iitj.sde.major;

import org.iitj.sde.major.meta.MyRecord;
import org.iitj.sde.major.meta.Table;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Represents a database that manages multiple tables and provides operations to interact with them.
 * A database allows creating tables, inserting data into tables, querying data from tables,
 * updating existing data in tables, and deleting data from tables.
 */
public class Database {
    /**
     * A mapping of table names to their corresponding Table objects.
     */
    private final Map<String, Table> tables;

    /**
     * Constructs an empty database.
     */
    public Database() {
        this.tables = new HashMap<>();
    }

    /**
     * Creates a new table in the database with the specified name.
     *
     * @param tableName the name of the table to be created
     */
    public void createTable(String tableName) {
        tables.put(tableName, new Table(tableName));
    }

    /**
     * Retrieves a table from the database by its name.
     *
     * @param tableName the name of the table to retrieve
     * @return the Table object associated with the given name, or null if no such table exists
     */
    public Table getTable(String tableName) {
        return tables.get(tableName);
    }

    /**
     * Inserts a new record into the specified table.
     *
     * @param tableName   the name of the table where the record will be inserted
     * @param fieldValues a map containing the values for each field in the record
     */
    public void insert(String tableName, Map<String, Object> fieldValues) {
        Table table = tables.get(tableName);
        if (table != null) {
            table.insertRecord(fieldValues);
        } else {
            System.out.println("Table " + tableName + " does not exist.");
        }
    }

    /**
     * Queries the specified table for records that match the given condition.
     *
     * @param tableName  the name of the table to query
     * @param condition  a predicate that defines the condition for selecting records
     * @return a list of records that match the condition
     */
    public List<MyRecord> select(String tableName, Predicate<MyRecord> condition) {
        Table table = tables.get(tableName);
        if (table != null) {
            return table.query(condition);
        } else {
            System.out.println("Table " + tableName + " does not exist.");
            return Collections.emptyList();
        }
    }

    /**
     * Updates records in the specified table that match the given condition.
     *
     * @param tableName  the name of the table to update
     * @param condition  a predicate that defines the condition for updating records
     * @param updates    a map containing the updated values for each field
     * @return the number of records updated
     */
    public int update(String tableName, Predicate<MyRecord> condition, Map<String, Object> updates) {
        Table table = tables.get(tableName);
        if (table != null) {
            return table.update(condition, updates);
        } else {
            System.out.println("Table " + tableName + " does not exist.");
            return 0;
        }
    }

    /**
     * Deletes records from the specified table that match the given condition.
     *
     * @param tableName  the name of the table to delete from
     * @param condition  a predicate that defines the condition for deleting records
     * @return the number of records deleted
     */
    public int delete(String tableName, Predicate<MyRecord> condition) {
        Table table = tables.get(tableName);
        if (table != null) {
            return table.delete(condition);
        } else {
            System.out.println("Table " + tableName + " does not exist.");
            return 0;
        }
    }


    /**
     * Returns a string representation of the database, including all its tables.
     *
     * @return a string representation of the database
     */
    @Override
    public String toString() {
        return tables.toString();
    }
}
