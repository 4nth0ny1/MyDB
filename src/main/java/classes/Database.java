package classes;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private String name;
    private List<Table> tables = new ArrayList<>();
    
    public Database() {
        // default constructor for Jackson
    }

    public Database(String name) {
        this.name = name;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public void removeTable(String tableName) {
        tables.removeIf(t -> t.getName().equals(tableName));
    }

    public List<Table> getTables() {
        return tables;
    }

    public String getName() {
        return name;
    }

    public void rename(String newName) {
        this.name = newName;
    }
}


