package org.iitj.sde.major;


import org.iitj.sde.major.meta.MyRecord;

import java.util.List;
import java.util.Map;

public class DatabaseTest {
    public static void main(String[] args) {
        Database db = new Database();

        // Create a table
        db.createTable("users");

        // Insert records
        db.insert("users", Map.of("id", 1, "name", "Arun", "age", 30));
        db.insert("users", Map.of("id", 2, "name", "Chaitanya", "age", 25));
        db.insert("users", Map.of("id", 3, "name", "Sagar", "age", 35));

        // Query records
        List<MyRecord> usersOver30 = db.select("users", record -> (int) record.getField("age") > 30);
        System.out.println("Users over 30: " + usersOver30);

        // Update records
        int updatedCount = db.update("users", record -> record.getField("name").equals("Arun"), Map.of("age", 31));
        System.out.println("Updated " + updatedCount + " records");

        // Delete records
        int deletedCount = db.delete("users", record -> (int) record.getField("age") < 30);
        System.out.println("Deleted " + deletedCount + " records");

        // Print the final state of the table
        System.out.println("Final users table: " + db.getTable("users"));
    }
}
