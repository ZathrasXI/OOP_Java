package edu.uob;

public abstract class TwoDimensionalShape {
  private Colour colour;
  protected void setColour(Colour c) {
    this.colour = c;
  }
  protected Colour getColour() {
    return this.colour;
  }
  public TwoDimensionalShape() {};

  public abstract double calculateArea();

  public abstract int calculatePerimeterLength();
}
