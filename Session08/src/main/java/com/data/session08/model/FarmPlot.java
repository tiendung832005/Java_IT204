package com.data.session08.model;

import com.data.session08.model.Bai8.Seeds;

public class FarmPlot {
    private int id;
    private Seeds seed;

    public FarmPlot(int id, Seeds seed) {
        this.id = id;
        this.seed = seed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seeds getSeed() {
        return seed;
    }

    public void setSeed(Seeds seed) {
        this.seed = seed;
    }
}
