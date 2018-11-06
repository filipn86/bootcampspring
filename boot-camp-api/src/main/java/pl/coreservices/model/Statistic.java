package pl.coreservices.model;

import java.io.Serializable;

public class Statistic implements Serializable{
    private String name;
    private Integer count;

    public Statistic(){
    }

    public Statistic(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
