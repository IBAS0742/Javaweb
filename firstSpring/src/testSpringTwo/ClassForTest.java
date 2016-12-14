package testSpringTwo;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ibas on 12/13/16.
 */
@Component("cft")
//@Component
public class ClassForTest {
    private int id;
    private String record;
    private long time_;

    public ClassForTest(){
        Date date = new Date();
        System.out.println("ClassForTest creating.");
        id = 0;
        record = "record";
        time_ = date.getTime();
    }

    public ClassForTest(String record){
        Date date = new Date();
        System.out.println("ClassForTest creating.");
        id = 0;
        this.record = record;
        time_ = date.getTime();
    }

    public long getTime_() {
        return time_;
    }

    public void setTime_(long time_) {
        this.time_ = time_;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    @Override
    public String toString(){
        return "{ id = " + id + " , record = " + record + " , time = " + time_ + "}";
    }
}
