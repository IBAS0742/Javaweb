package cn.sunibas.testComponent;

/**
 * Created by ibas on 12/9/16.
 */
public class Car {
    private int id;
    private String name;
    private Wheel wheel;

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

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}
