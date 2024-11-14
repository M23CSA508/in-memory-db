# Main Memory Database Systems - Paper Implementation

## Overview
The paper discusses the benefits and challenges of Main Memory Database Systems (MMDBs). These systems store data directly in main memory, offering significantly faster access compared to traditional disk-based systems.
To achieve this high performance, MMDBs employ various optimization techniques to structure, organize, and ensure data reliability. The paper explores these optimization strategies and provides an overview of existing MMDB implementations.

## Features
- *High-Speed Access*: MMDBs store data directly in main memory, eliminating the need for disk I/O. This results in significantly faster read and write operations, making them ideal for applications that require real-time data processing.
- *Data Persistence*: While MMDBs primarily reside in memory, they often employ techniques like logging and checkpointing to ensure data durability in case of system failures or power outages.
- *Data Structures*: MMDBs often utilize specialized data structures optimized for in-memory storage and retrieval, such as hash tables, B-trees, and various indexing techniques.
### Core Operations:
- *Insert*: Adds new data records to the database.
- *Select*: Retrieves specific data records based on search criteria.
- *Update*: Modifies existing data records.
- *Remove*: Deletes data records from the database.
By leveraging these features and operations, MMDBs provide a powerful platform for applications that demand high performance and low latency data access.

## Technologies Used
- Java 17: Programming language used to implement the backend.

## System Architecture

Allocates and manages memory for data storage.
Implements memory-efficient data structures (e.g., hash tables, B-trees) to optimize data access.
Handles memory de-allocation and garbage collection to prevent memory leaks.

```
+-------------------+               +---------------------+
|   Database Core   |               |    Metadata Layer   |
|-------------------|               |---------------------|
|   Database.java   | <-----------> |   Table.java        |
+-------------------+               |   MyRecord.java     |
|                                   +---------------------+
|
V
+---------------------+
|   Testing Suite     |
|---------------------|
| DatabaseTest.java   |
+---------------------+
```

### Build and Run
Clone the Repository:

```
git clone https://github.com/M23CSA508/in-memory-db.git
cd in-memory-db
```
Build the Project: Use Maven to compile the code and create an executable JAR.

```
mvn clean install
```

### License
This project is licensed under the MIT License. See the [LICENSE](https://opensource.org/license/mit) file for more details.

### Contact
For any questions, please reach out to:

Email: [Suvodip Som] (mailto:m23csa533@iitj.ac.in), [Swapnil Adak](mailto:m23csa534@iitj.ac.in) and [Anindya Bandopadhyay](mailto:m23csa508@iitj.ac.in)
GitHub: [GitHub Repository](https://github.com/M23CSA508/in-memory-db.git)