package 백준.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class J1236_성지키기 {
  static int N, M;
  static char[][] A;

  public static void main(String[] args) throws IOException {
    input();
    int totalNeededGuards = cntGuardsPerColumn();
    System.out.println("totalNeededGuards: " + totalNeededGuards);
    // 겹치는 지점에 대하여 빼줄 필요가 있어보임
  }

  static void input() throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    String nextLine;

    A = new char[N+1][M+1];
    for (int i = 1; i <= N; i++) {
      nextLine = bf.readLine();
      for (int j = 0; j < M; j++) {
        A[i][j+1] = nextLine.charAt(j);
      }
    }
  }

  static int cntGuardsPerColumn() {
    int guardsX = 0;
    int guardsY = 0;

    int totalNeededGuards = 0;
    for (int j = 1; j <= M; j++) {
      guardsY = 0;
      for (int i = 1; i <= N; i++) {
        if (A[i][j] == 'X') {
          guardsY++;
        }
      }
      System.out.println("guardsY: " + guardsY);
      if (guardsY == 0) {
        totalNeededGuards++;
      }
    }

    for (int i = 1; i <= N; i++) {
      guardsX = 0;
      for (int j = 0; j <= M; j++) {
        if (A[i][j] == 'X') {
          guardsX++;
        }
      }
      System.out.println("guardsX: " + guardsX);
      if (guardsX == 0) {
        totalNeededGuards++;
      }
    }

    return totalNeededGuards;
  }
}
