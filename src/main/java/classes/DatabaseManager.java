package classes;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private List<Database> databases = new ArrayList<>();

    public void createDatabase(String name) {
        databases.add(new Database(name));
    }

    public void deleteDatabase(String name) {
        databases.removeIf(db -> db.getName().equals(name));
    }

    public Database getDatabaseByName(String name) {
        for (Database db : databases) {
            if (db.getName().equals(name)) {
                return db;
            }
        }
        return null;
    }

    public List<String> getAllDatabaseNames() {
        List<String> names = new ArrayList<>();
        for (Database db : databases) {
            names.add(db.getName());
        }
        return names;
    }

    public List<Database> getAllDatabases() {
        return databases;
    }
}
