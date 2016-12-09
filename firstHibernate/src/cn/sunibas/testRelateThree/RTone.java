package cn.sunibas.testRelateThree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ibas on 12/2/16.
 */
public class RTone {
    private int id;
    private String label;
    private Set<RTtwo> set = new HashSet<RTtwo>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<RTtwo> getSet() {
        return set;
    }

    public void setSet(Set<RTtwo> set) {
        this.set = set;
    }
}
