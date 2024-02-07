package edu.uob;

public class Triangle extends TwoDimensionalShape {

  double s2;
  double s1;
  double s3;
  private TriangleVariant variant;

  public Triangle(double side1, double side2, double side3) {
    s1 = side1;
    s2 = side2;
    s3 = side3;
    variant = determineVariant();
  }
  private TriangleVariant determineVariant() {
    double hypotenuse_2 = getLongestSide() * getLongestSide();
    if (s1 <= 0 || s2 <= 0 || s3 <= 0) {
      return TriangleVariant.ILLEGAL;
    }
    else if (s1 + s2 < s3 || s1 + s3 < s2 || s2 + s3 < s1) {
      return TriangleVariant.IMPOSSIBLE;
    }
    else if (isFlat()) {
      return TriangleVariant.FLAT;
    }
    else if (s1 == s2 && s2 == s3) {
      return TriangleVariant.EQUILATERAL;
    }
    else if (s1 == s2 || s2 == s3 || s1 == s3) {
      return TriangleVariant.ISOSCELES;
    }
    else if (hypotenuse_2 == (s1 * s1 + s2 * s2) ||
             hypotenuse_2 == (s3 * s3 + s2 * s2) ||
             hypotenuse_2 == (s3 * s3 + s1 * s1)) {
      double c = s1 * s1 + s2 * s2;
      System.out.println(hypotenuse_2 + "== " + c);
      return TriangleVariant.RIGHT;
    }
    else if (s1 != s2 && s2 != s3) {
      return TriangleVariant.SCALENE;
    }
    else {
      return TriangleVariant.ILLEGAL;
    }
  }

  public double getLongestSide() {
    if (s1 >= s2 && s1 >= s3) {
      return s1;
    }
    else return Math.max(s2, s3);
  }

  public boolean isFlat(){
    return s1 + s2 == s3 || s1 + s3 == s2 || s2 + s3 == s1;
  }

  public TriangleVariant getVariant() {
    return variant;
  }

  @Override
  public String toString() {
    String text = super.toString();
    return text +" triangle with side of length " + s1 +","+s2+","+s3;
  }

  public double calculateArea() {
    double s = (s1 + s2 + s3) / 2;
    return Math.sqrt(s * (s-s1) * (s-s2) * (s-s3));
  }

  public int calculatePerimeterLength() {
    return (int) Math.round(s1 + s2 + s3);
  }
}
