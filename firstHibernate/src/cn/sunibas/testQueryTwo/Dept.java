package cn.sunibas.testQueryTwo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ibas on 12/2/16.
 */
public class Dept {
    private int deptId;
    private String deptName;
    private Set<Employee> emps = new HashSet<Employee>();

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Employee> getEmps() {
        return emps;
    }

    public void setEmps(Set<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString(){
        return "{ deptId : " + deptId + " , deptName : " + deptName + " }";
    }
}
