package edu.uob;

public abstract class TwoDimensionalShape {
  protected Colour col;

  protected void setColour(Colour c) {
    this.col = c;
  }
  public TwoDimensionalShape() {};

  public abstract double calculateArea();

  public abstract int calculatePerimeterLength();
}
