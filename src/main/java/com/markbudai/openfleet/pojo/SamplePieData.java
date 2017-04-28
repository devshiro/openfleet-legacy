package com.markbudai.openfleet.pojo;

/**
 * Created by Mark on 2017. 04. 20..
 */
public class SamplePieData {
    private String name;
    private double share;

    public SamplePieData() {
    }

    public SamplePieData(String name, double share) {
        this.name = name;
        this.share = share;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getShare() {
        return share;
    }

    public void setShare(double share) {
        this.share = share;
    }
}
