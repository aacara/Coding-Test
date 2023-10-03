package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J1253_좋은수구하기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] A = new int[N];

    for (int i=0; i<N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(A);
    int start_idx, end_idx, sum;
    int cnt = 0;
    

    for (int i=0; i<N; i++) {
      start_idx = 0;
      end_idx = N-1;

      while (start_idx < end_idx) {
        sum = A[start_idx] + A[end_idx];
        if (sum < A[i]) {
          start_idx++;
        } else if (sum == A[i]) {
          if (start_idx != i && end_idx != i) {
            //  System.out.println("====sum: "+ sum + ", i: "+ i +", A[i]: "+ A[i] + ", A[start_idx]: " + A[start_idx] + ", A[end_idx]: " + A[end_idx]);
            cnt++;
            break;
          } else if (start_idx == i) {
            start_idx++;
          } else { // end_idx == i
            end_idx--;
          }
        } else { // sum > A[i]
          end_idx--;
        }
      }
    }
    System.out.println(cnt);
  }
  
}
