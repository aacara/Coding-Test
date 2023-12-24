package 백준.시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J10158_개미_시간초과3 {
  static int w, h, x, y, t;

  public static void main(String[] args) throws IOException {
    input();
    movement();
  }

  static void input() throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String wh = bf.readLine();
    String xy = bf.readLine();
    t = Integer.parseInt(bf.readLine());

    w = Integer.parseInt(wh.split(" ")[0]);
    h = Integer.parseInt(wh.split(" ")[1]);

    x = Integer.parseInt(xy.split(" ")[0]);
    y = Integer.parseInt(xy.split(" ")[1]);
  }

  static void movement() {
    int Xmovements = x + t;
    int Xshare = Xmovements / w;
    int Xremainder = Xmovements % w;

    int Ymovements = y + t;
    int Yshare = Ymovements / h;
    int Yremainder = Ymovements % h;

    // System.out.println("Xmovements: " + Xmovements);
    // System.out.println("Xshare: " + Xshare);
    // System.out.println("Xremainder: " + Xremainder);
    // System.out.println("Ymovements: " + Ymovements);
    // System.out.println("Yshare: " + Yshare);
    // System.out.println("Yremainder: " + Yremainder);

    if (Xshare % 2 != 0) {
      Xremainder = w-Xremainder;
    }

    if (Yshare % 2 != 0) {
      Yremainder = h-Yremainder;
    }

    System.out.println(Xremainder + " " + Yremainder);

  }
}
