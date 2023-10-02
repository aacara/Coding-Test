package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class J10986_나머지합구하기 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    long[] S = new long[N];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      S[i] = (S[i-1] + Integer.parseInt(st.nextToken())) % M;
    }

    long cnt = 0;
    long[] remainders = new long[M];
    for (int i=1; i<=N; i++) {
      remainders[(int)S[i]]++;
    }

    // 0끼리 묶어줄 수 있음
    cnt += remainders[0] * (remainders[0] + 1) / 2;

    // 0이 아닌 나머지
    for (int i=1; i<M; i++) {
      cnt += (remainders[i] - 1) * remainders[i] / 2;
    }

    System.out.println(cnt);

  }
  
}
