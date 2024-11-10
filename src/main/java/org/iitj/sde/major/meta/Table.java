package org.iitj.sde.major.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Table {
    private String name;
    private List<MyRecord> myRecords;

    public Table(String name) {
        this.name = name;
        this.myRecords = new ArrayList<>();
    }

    public void insertRecord(Map<String, Object> fieldValues) {
        myRecords.add(new MyRecord(fieldValues));
    }

    public List<MyRecord> query(Predicate<MyRecord> condition) {
        return myRecords.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

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

    public int delete(Predicate<MyRecord> condition) {
        int initialSize = myRecords.size();
        myRecords.removeIf(condition);
        return initialSize - myRecords.size();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return myRecords.toString();
    }
}
