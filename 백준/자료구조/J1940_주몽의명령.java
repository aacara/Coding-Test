package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J1940_주몽의명령 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 재료의 수
    int M = Integer.parseInt(br.readLine()); // 갑옷이 완성되는 번호의 합
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] A = new int[N];
    int start_idx = 0;
    int end_idx = N-1;
    int cnt = 0;
    
    for (int i=0; i<N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(A);
    int sum = A[end_idx] + A[start_idx];

    while (start_idx < end_idx) {
      if (sum < M) {
        start_idx++;
      } else if (sum == M) {
        cnt++;
        start_idx++;
        end_idx--;
      } else { // sum > M
        end_idx--;
      }
      sum = A[start_idx] + A[end_idx];
    }
    System.out.println(cnt);
  }
  
}
