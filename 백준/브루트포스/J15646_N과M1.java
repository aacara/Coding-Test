package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J15646_N과M1 {
  static int N, M;
  static int[] selected, used;

  static StringBuilder sb = new StringBuilder();

  static void input() {
    FastReader scan = new FastReader();
    N = scan.nextInt(); // 자연수의 범위
    M = scan.nextInt(); // 수열의 길이
    selected = new int[M+1];
    used = new int[N+1];
  }

  static void recFunction(int k) {
    if (k == M+1) {
      for (int i = 1; i <= M; i++) {
        sb.append(selected[i]).append(' ');
      }
      sb.append("\n");
    } else {
      for (int cand = 1; cand <= N; cand++) {
        if (used[cand] == 1) continue;
        selected[k] = cand;
        used[cand] = 1;
        recFunction(k+1);
        selected[k] = 0;
        used[cand] = 0;
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
