package edu.uob;

public class Triangle extends TwoDimensionalShape {

  int s1;
  int s2;
  int s3;
  TriangleVariant type;

  public Triangle(int side1, int side2, int side3) {
    s1 = side1;
    s2 = side2;
    s3 = side3;
    type = setType();
  }
  protected TriangleVariant setType() {
    int hyp_2 = getLongestSide() * getLongestSide();
    if (s1 + s2 < s3 || s1 + s3 < s2 || s2 + s3 < s1) {
      return TriangleVariant.ILLEGAL;
    }
    else if (s1 < 0 || s2 < 0 || s3 < 0) {
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
    else if (hyp_2 == (s1 * s1 + s2 * s2) ||
             hyp_2 == (s3 * s3 + s2 * s2) ||
             hyp_2 == (s3 * s3 + s1 * s1)) {
      return TriangleVariant.RIGHT;
    }
    else {
      return TriangleVariant.SCALENE;
    }
  }

  public int getLongestSide() {
    if (s1 >= s2 && s1 >= s3) {
      return s1;
    }
    else return Math.max(s2, s3);
  }

  public boolean isFlat(){
    if (s1 == 0 || s2 ==0 || s3 == 0) {
      return true;
    }
    return s1 + s2 == s3 || s1 + s3 == s2 || s2 + s3 == s1;
  }

  public TriangleVariant getVariant() {
    return type;
  }

  @Override
  public String toString() {
    String text = super.toString();
    return text +" triangle with side of length " + s1 +","+s2+","+s3;
  }

  public double calculateArea() {
    return 0;
  }

  public int calculatePerimeterLength() {
    return s1 + s2 + s3;
  }
}
