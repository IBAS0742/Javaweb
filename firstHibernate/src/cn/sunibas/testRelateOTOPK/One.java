package cn.sunibas.testRelateOTOPK;

/**
 * Created by ibas on 12/4/16.
 */
public class One {
    private int id;
    private String name;
    private Two two;

    public Two getTwo() {
        return two;
    }

    public void setTwo(Two two) {
        this.two = two;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
