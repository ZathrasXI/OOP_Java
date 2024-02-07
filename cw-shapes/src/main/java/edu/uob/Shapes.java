package edu.uob;

public class Shapes {

  // TODO use this class as then entry point; play around with your shapes, etc
  public static void main(String[] args) {

    Triangle t = new Triangle(1, -2, 3);
    t.setColour(Colour.BLACK);
    System.out.println("The longest side of the triangle is " + t.getLongestSide());
    System.out.println(t);
    System.out.println(t.getVariant());

    Circle c = new Circle(3, Colour.BROWN);
    System.out.println(c);

    Rectangle r = new Rectangle(4,5);
    System.out.println(r);

  }
}
