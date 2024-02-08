package edu.uob;

public class Triangle extends TwoDimensionalShape implements MultiVariantShape {

  long s2;
  long s1;
  long s3;
  private TriangleVariant variant;

  public Triangle(int side1, int side2, int side3) {
    s1 = (long) side1;
    s2 = (long) side2;
    s3 = (long) side3;
    variant = determineVariant();
  }
  private TriangleVariant determineVariant() {
    long hypotenuse_2 = (long) (getLongestSide() * getLongestSide());
    if (s1 <= 0 || s2 <= 0 || s3 <= 0) {
      return TriangleVariant.ILLEGAL;
    }
    else if (s1 + s2 < s3 || s1 + s3 < s2 || s2 + s3 < s1) {
      System.out.println(s1 + " " + s2 + " " + s3);
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
      return TriangleVariant.RIGHT;
    }
    else {
      return TriangleVariant.SCALENE;
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
    double s = (double) (s1 + s2 + s3) / 2;
    return Math.sqrt(s * (s-s1) * (s-s2) * (s-s3));
  }

  public int calculatePerimeterLength() {
    return (int) Math.round(s1 + s2 + s3);
  }
}
