package com.group39.fitbot.group39_fitbot.model;

public class XY {
    private String X;
    private int Y;

    public XY() {
    }

    public XY(String x, int y) {
        X = x;
        Y = y;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    @Override
    public String toString() {
        return "XY{" +
                "X='" + X + '\'' +
                ", Y=" + Y +
                '}';
    }
}
