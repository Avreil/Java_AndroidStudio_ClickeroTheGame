package com.avreil.clickero;

public class MaterialsClass {

    Integer Stone,Wood,Coal;
    long time;

    public MaterialsClass(){
        Stone=0;
        Wood=0;
        time=0;
        Coal=0;
    }

    public void reset (){
        this.Stone = 0;
        this.Wood = 0;
        this.Coal = 0;
    }
    public Integer getStone() {
        return Stone;
    }

    public void setStone(Integer _stone) {
        Stone = _stone;
    }

    public Integer getWood() {
        return Wood;
    }

    public void setWood(Integer _wood) {
        Wood = _wood;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public Integer getCoal() {
        return Coal;
    }

    public void setCoal(Integer coal) {
        Coal = coal;
    }
}
