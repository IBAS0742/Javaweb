package cn.sunibas.testRelateTwo;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by ibas on 12/2/16.
 */
public class Two {
    private int id;
    private Set<One> ones = new HashSet<One>();
    public int getId() {
        return id;
    }
    //getter and setter

    public void setId(int id) {
        this.id = id;
    }

    public Set<One> getOnes() {
        return ones;
    }

    public void setOnes(Set<One> ones) {
        this.ones = ones;
    }
}
