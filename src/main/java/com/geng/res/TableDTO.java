package com.geng.res;

import java.util.Vector;

public class TableDTO {
   private  Vector<Vector<Object>> data;
   private int tatalCount;

    public Vector<Vector<Object>> getData() {
        return data;
    }

    public void setData(Vector<Vector<Object>> data) {
        this.data = data;
    }

    public int getTatalCount() {
        return tatalCount;
    }

    public void setTatalCount(int tatalCount) {
        this.tatalCount = tatalCount;
    }
}
