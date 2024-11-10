package org.iitj.sde.major;

import org.iitj.sde.major.meta.MyRecord;
import org.iitj.sde.major.meta.Table;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Database {
    private final Map<String, Table> tables;

    public Database() {
        this.tables = new HashMap<>();
    }

    public void createTable(String tableName) {
        tables.put(tableName, new Table(tableName));
    }

    public Table getTable(String tableName) {
        return tables.get(tableName);
    }

    public void insert(String tableName, Map<String, Object> fieldValues) {
        Table table = tables.get(tableName);
        if (table != null) {
            table.insertRecord(fieldValues);
        } else {
            System.out.println("Table " + tableName + " does not exist.");
        }
    }

    public List<MyRecord> select(String tableName, Predicate<MyRecord> condition) {
        Table table = tables.get(tableName);
        if (table != null) {
            return table.query(condition);
        } else {
            System.out.println("Table " + tableName + " does not exist.");
            return Collections.emptyList();
        }
    }

    public int update(String tableName, Predicate<MyRecord> condition, Map<String, Object> updates) {
        Table table = tables.get(tableName);
        if (table != null) {
            return table.update(condition, updates);
        } else {
            System.out.println("Table " + tableName + " does not exist.");
            return 0;
        }
    }

    public int delete(String tableName, Predicate<MyRecord> condition) {
        Table table = tables.get(tableName);
        if (table != null) {
            return table.delete(condition);
        } else {
            System.out.println("Table " + tableName + " does not exist.");
            return 0;
        }
    }

    @Override
    public String toString() {
        return tables.toString();
    }
}
