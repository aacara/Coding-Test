package 백준.시간복잡도;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class J10158_개미_시간초과 {
  static int w, h, x, y, t;
  
  public static void main(String[] args) {
    input();
    movement();
    // ArrayList<Integer> finalXY = movement();
    // System.out.println(finalXY.get(0) + " " + finalXY.get(1));
  }

  static void input() {
    Scanner scanner = new Scanner(System.in);
    String wh = scanner.nextLine();
    String xy = scanner.nextLine();
    t = scanner.nextInt();
    scanner.close();

    w = Integer.parseInt(wh.split(" ")[0]);
    h = Integer.parseInt(wh.split(" ")[1]);

    x = Integer.parseInt(xy.split(" ")[0]);
    y = Integer.parseInt(xy.split(" ")[1]);
  }

  static void movement() {
    int nextStepX = 1;
    int nextStepY = 1;
    for (int i = 0; i < t; i++) {
      if (x == w) {
        nextStepX = -1;
      } else if (x == 0) {
        nextStepX = 1;
      }

      if (y == h) {
        nextStepY = -1;
      } else if (y == 0) {
        nextStepY = 1;
      }

      x += nextStepX;
      y += nextStepY;
    }
    System.out.println(x + " " + y);
  // ArrayList<Integer> finalPosition = new ArrayList<Integer>(2);
  // finalPosition.set(0, x);
  // finalPosition.set(1, y);
  // return finalPosition;
  }
}
