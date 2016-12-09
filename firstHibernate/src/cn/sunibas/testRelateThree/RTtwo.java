package cn.sunibas.testRelateThree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ibas on 12/2/16.
 */
public class RTtwo {
    private int id;
    private String label;
    private Set<RTone> set = new HashSet<RTone>();

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

    public Set<RTone> getSet() {
        return set;
    }

    public void setSet(Set<RTone> set) {
        this.set = set;
    }
}
