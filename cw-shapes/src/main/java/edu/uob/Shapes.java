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
    int tri_count = 0;
    int static_count = 0;
    for (int i = 0; i < 100; i++) {
      if (shapes[i] instanceof Triangle) {
        tri_count++;
        static_count = ((Triangle) shapes[i]).getPopulation();
      }
    }
    System.out.println("loop count: "+ tri_count + " static count: " + static_count);
  }

}
