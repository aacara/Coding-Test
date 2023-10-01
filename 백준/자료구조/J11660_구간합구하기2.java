package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J11660_구간합구하기2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 표의 크기
    int M = Integer.parseInt(st.nextToken()); // 합을 구하는 횟수
    
    int[][] A = new int[N+1][N+1];

    for (int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=1; j<=N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] S = new int[N+1][N+1];
    for (int i=1; i<=N; i++) {
      for (int j=1; j<=N; j++) {
        S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j];
      }        
    }

    int startX, startY, endX, endY, sum;
    for (int i=1; i<=M; i++) {
      st = new StringTokenizer(br.readLine());
      startX = Integer.parseInt(st.nextToken());
      startY = Integer.parseInt(st.nextToken());
      endX = Integer.parseInt(st.nextToken());
      endY = Integer.parseInt(st.nextToken());
      sum = S[endX][endY] - S[startX-1][endY] - S[endX][startY-1] + S[startX-1][startY-1];
      System.out.println(sum);
    }
  }
  
}
