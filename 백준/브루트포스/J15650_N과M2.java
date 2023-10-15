package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J15650_N과M2 {
  static int N, M;
  static int[] selected;

  static StringBuilder sb = new StringBuilder();

  static void input() {
    FastReader scan = new FastReader();
    N = scan.nextInt(); // 총 자연수의 수
    M = scan.nextInt(); // 수열의 길이
    selected = new int[M + 1];
  }

  static void recFunction(int k) {
    if (k == M + 1) {
      for (int i = 1; i<= M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
    } else {
      for (int cand = selected[k-1] + 1; cand <= N; cand++) {
        selected[k] = cand;
        recFunction(k+1);
        selected[k] = 0;
      }
    }
  }

  public static void main(String[] args) {
    input();
    recFunction(1);
    System.out.println(sb.toString());
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
      br = new BufferedReader(new FileReader(new File(s)));
    }
    
    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }

  }
}
