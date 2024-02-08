package edu.uob;

public class Shapes {

  public static void main(String[] args) {
    TwoDimensionalShape[] shapes = new TwoDimensionalShape[100];
    for (int i = 0; i < 100; i++) {
      double num = Math.random();
      shapes[i] = (num < 0.3)
              ? new Triangle((int)(1*num),(int)(2*num),(int)(3*num))
              : (num < 0.6)
              ? new Circle((int)(10*num))
              : new Rectangle((int)(10*num), (int)(12*num));
    }
    int triangleCounter = 0;
    for (int i = 0; i < 100; i++) {
        if (shapes[i] instanceof Triangle) {
          triangleCounter++;
        }
    }
    System.out.println(triangleCounter + " triangles");
  }
}
