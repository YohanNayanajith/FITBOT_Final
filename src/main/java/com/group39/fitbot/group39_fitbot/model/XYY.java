package com.group39.fitbot.group39_fitbot.model;

public class XYY {
    private String X;
    private int Y1;
    private int Y2;

    public XYY() {
    }

    public XYY(String x, int y1, int y2) {
        X = x;
        Y1 = y1;
        Y2 = y2;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public int getY1() {
        return Y1;
    }

    public void setY1(int y1) {
        Y1 = y1;
    }

    public int getY2() {
        return Y2;
    }

    public void setY2(int y2) {
        Y2 = y2;
    }

    @Override
    public String toString() {
        return "XYY{" +
                "X='" + X + '\'' +
                ", Y1=" + Y1 +
                ", Y2=" + Y2 +
                '}';
    }
}
