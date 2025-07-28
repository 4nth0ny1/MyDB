package classes;

public class Column {
    private String name;
//    private String type;

    public Column() {} // Required for Jackson

    public Column(String name) { // add type if needed
    	
        this.name = name;
//        this.type = type;
    }

    public String getName() {
        return name;
    }

//    public String getType() {
//        return type;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setType(String type) {
//        this.type = type;
//    }
}
