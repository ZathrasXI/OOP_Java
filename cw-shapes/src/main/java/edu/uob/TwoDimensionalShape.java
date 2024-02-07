package edu.uob;

public abstract class TwoDimensionalShape {
  private Colour colour;
  protected void setColour(Colour c) {
    this.colour = c;
  }
  protected Colour getColour() {
    return this.colour;
  }
  public String toString() {
    return "This is a " + getColour() + " coloured";
  }
  public TwoDimensionalShape() {};

  public abstract double calculateArea();

  public abstract int calculatePerimeterLength();
}
