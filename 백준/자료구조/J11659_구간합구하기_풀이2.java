package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J11659_구간합구하기_풀이2 {
  public static void main(String[] args) throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int N = Integer.parseInt(stringTokenizer.nextToken());
    int M = Integer.parseInt(stringTokenizer.nextToken());
    int[] S = new int[N+1];
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i=1; i<=N; i++) {
      S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
    }
    for (int j=0; j<=M; j++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int start = Integer.parseInt(stringTokenizer.nextToken());
      int end = Integer.parseInt(stringTokenizer.nextToken());
      System.out.println(S[end] - S[start-1]);
    }
  }
}