package classes;

import java.util.*;

public class Row {
    private Map<String, Object> data = new HashMap<>();

    public Row() {} // Required for Jackson

    public void set(String columnName, Object value) {
        data.put(columnName, value);
    }

    public Object get(String columnName) {
        return data.get(columnName);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
