package testTool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ibas on 12/14/16.
 */
public class toolOne {

    private String obj_;

    private int time_;

    public int getTime_() {
        return time_;
    }

    public void setTime_(int time_) {
        this.time_ = time_;
    }

    public String getObj_() {
        return obj_;
    }

    public toolOne(){}

    public toolOne(String obj_){
        this.obj_ = obj_;
    }

    public toolOne(int time_){
        this.time_ = time_;
    }

    public toolOne(String obj_,int time_){
        this.obj_ = obj_;
        this.time_ = time_;
    }

    public void setObj_(String obj_) {
        this.obj_ = obj_;
    }

    public void commonTest(String loc,String obj,int time) {
        ApplicationContext context = new ClassPathXmlApplicationContext(loc);

        System.out.println("before using.");

        if (time <= 0) {
            time = 1;
        }

        for (int i = 0;i < time;i++) {
            System.out.println(context.getBean(obj));
        }
    }

    public void commonTest(String loc,int time) {
        this.commonTest(loc,obj_,time);
    }

    public void commonTest(String loc) {
        this.commonTest(loc,obj_,time_);
    }

    public void commonTest(String loc,String obj) {
        this.commonTest(loc,obj,time_);
    }
}
