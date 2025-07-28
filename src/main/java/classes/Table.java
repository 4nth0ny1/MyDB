package classes;

import java.util.*;

public class Table {
    private String name;
    private List<Column> columns = new ArrayList<>();
    private TreeMap<String, Row> rows = new TreeMap<>();

    public Table() {} // Required for Jackson

    public Table(String name) {
        this.name = name;
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public void insertRow(String primaryKey, Row row) {
        rows.put(primaryKey, row);
    }

    public Row getRow(String primaryKey) {
        return rows.get(primaryKey);
    }

    public String getName() {
        return name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public Map<String, Row> getRows() {
        return rows;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public void setRows(TreeMap<String, Row> rows) {
        this.rows = rows;
    }
}
