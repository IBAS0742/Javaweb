package cn.sunibas.testQueryOne;

/**
 * Created by ibas on 11/29/16.
 */
public class mytableCp {
    private int col1;
    private String col2;

    public mytableCp(){

    }

    public mytableCp(int col1,String col2) {
        this.col1 = col1;
        this.col2 = col2;
    }

    public int getCol1() {
        return col1;
    }

    public void setCol1(int col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    @Override
    public String toString(){
        return "{ col1 : " + col1 + " , col2 : " + col2 + "}";
    }
}
