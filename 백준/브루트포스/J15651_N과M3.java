package 백준.브루트포스;

import java.io.*;
import java.util.*;

public class J15651_N과M3 {
  static int N, M;
  static int[] selected;

  static StringBuilder sb = new StringBuilder();

  static void input() {
    FastReader scanner = new FastReader();
    N = scanner.nextInt();
    M = scanner.nextInt();
    selected = new int[M + 1];
  }

  // 재귀 함수
  static void recFunction(int k) {
    if (k == M + 1) { // 모두 고름
      for (int i=1; i<=M; i++) {
        sb.append(selected[i]).append(" ");
      } 
      sb.append("\n");
    } else {
      for (int cand = 1; cand <= N; cand++) {
        selected[k] = cand;

        recFunction(k+1);
        // 백트래킹에서 가능한 모든 해를 검색하는데,
        // 어떤 해가 조건에 맞지 않을 경우 그 해를 더 이상 탐색하지 않고 이전 상태로 되돌아간다.
        // 이 때, 이전 상태로 돌아가기 위해 선택을 취소하는 과정이 필요
        // selected[k] = 0;
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
        while(st == null ||!st.hasMoreElements()) {
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

