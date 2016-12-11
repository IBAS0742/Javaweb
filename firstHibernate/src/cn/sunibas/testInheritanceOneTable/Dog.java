package cn.sunibas.testInheritanceOneTable;

import cn.sunibas.testInheritance.*;
import cn.sunibas.testInheritance.Animal;

/**
 * Created by ibas on 12/9/16.
 */
public class Dog extends cn.sunibas.testInheritanceOneTable.Animal {
    private int feedBone;

    public int getFeedBone() {
        return feedBone;
    }

    public void setFeedBone(int feedBone) {
        this.feedBone = feedBone;
    }
}