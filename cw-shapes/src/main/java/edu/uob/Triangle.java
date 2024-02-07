package edu.uob;

public class Triangle extends TwoDimensionalShape {

  int s1;
  int s2;
  int s3;

  public Triangle(int side1, int side2, int side3, Colour c) {
    super.setColour(c);
    s1 = side1;
    s2 = side2;
    s3 = side3;

  }

  public int getLongestSide() {
    if (s1 >= s2 && s1 >= s3) {
      return s1;
    }
    else return Math.max(s2, s3);
  }

  @Override
  public String toString() {
    String text = super.toString();
    return "This is a "+ this.col +" triangle with side of length " + s1 +","+s2+","+s3;
  }

  public double calculateArea() {
    return 0;
  }

  // TODO implement me!
  public int calculatePerimeterLength() {
    return 0;
  }
}
