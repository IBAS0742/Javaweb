package testSpringTwo;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by ibas on 12/13/16.
 */
@Component("ocft")
//@Component
public class OverCFT {
    private int id;
    @Resource(name = "cft") // for name
    //@Resource             // for type
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
