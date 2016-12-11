package cn.sunibas.testInheritanceOneTable;

import cn.sunibas.testInheritance.*;
import cn.sunibas.testInheritance.Animal;

/**
 * Created by ibas on 12/9/16.
 */
public class Cat extends cn.sunibas.testInheritanceOneTable.Animal {
    private int feedFish;

    public int getFeedFish() {
        return feedFish;
    }

    public void setFeedFish(int feedFish) {
        this.feedFish = feedFish;
    }

    @Override
    public String toString(){
        return "{id : " + getId() + ",name = " + getName() + ",feedFish = " + getFeedFish() + "};";
    }
}
