package com.melnyk.model;

public class VisualParameters {

  private String color;
  private double transparency;
  private int wayOfCutting;

  public VisualParameters() {
  }

  public VisualParameters(String color, double transparency,
      int way_of_cutting) {
    this.color = color;
    this.transparency = transparency;
    this.wayOfCutting = way_of_cutting;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getTransparency() {
    return transparency;
  }

  public void setTransparency(double transparency) {
    this.transparency = transparency;
  }

  public int getWayOfCutting() {
    return wayOfCutting;
  }

  public void setWayOfCutting(int wayOfCutting) {
    this.wayOfCutting = wayOfCutting;
  }

  @Override
  public String toString() {
    return "VisualParameters{" +
        "color='" + color + '\'' +
        ", transparency='" + transparency + '\'' +
        ", wayOfCutting='" + wayOfCutting + '\'' +
        '}';
  }
}
