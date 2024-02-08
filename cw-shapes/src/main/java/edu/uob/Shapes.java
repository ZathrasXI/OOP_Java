package edu.uob;

public class Shapes {

  public static void main(String[] args) {
    TwoDimensionalShape[] shapes = new TwoDimensionalShape[100];
    int triangleCounter = 0;
    for (int i = 0; i < 100; i++) {
      double num = Math.random();
      if (num < 0.3) {
        shapes[i] = new Triangle(10 * num, 12 * num, 13 * num);
        triangleCounter++;
      }
      else if (num > 0.3 && num < 0.6) {
        shapes[i] = new Rectangle((int) Math.round(10 * num), (int) Math.round(15 * num));
      }
      else {
        shapes[i] = new Circle((int) Math.round(10 * num));
      }
      System.out.println(shapes[i]);
    }
    System.out.println(triangleCounter + " many triangles were created");


  }
}
