package testSpringOne;

/**
 * Created by ibas on 12/13/16.
 */
public class OverCFT {
    private int id;
    private ClassForTest cft;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassForTest getCft() {
        return cft;
    }

    public void setCft(ClassForTest cft) {
        this.cft = cft;
    }

    @Override
    public String toString() {
        return "{ id = " + id + " , " + cft + " }";
    }
}
