package classes;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class DatabaseManager {
    // Map of database name to Database instance
    private Map<String, Database> allDatabases = new HashMap<>();

    // Required no-arg constructor for Jackson
    public DatabaseManager() {}

    // Add a new database
    public void addDatabase(Database db) {
        allDatabases.put(db.getName(), db);
    }

    // Get a database by name
    public Database getDatabaseByName(String name) {
        return allDatabases.get(name);
    }

    // Remove a database by name
    public void removeDatabase(String name) {
        allDatabases.remove(name);
    }

    // Return all databases (used internally or for display)
    public List<Database> getAllDatabaseList() {
        return new ArrayList<>(allDatabases.values());
    }

    // Return the names of all databases
    public List<String> listDatabaseNames() {
        return new ArrayList<>(allDatabases.keySet());
    }

    // Jackson uses these getters and setters for JSON serialization

    public Map<String, Database> getAllDatabases() {
        return allDatabases;
    }

    public void setAllDatabases(Map<String, Database> allDatabases) {
        this.allDatabases = allDatabases;
    }
}
