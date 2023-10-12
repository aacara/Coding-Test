package 백준.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import java.util.Arrays;

//  1 5 2 3 6 2 3 7 3 5 2 6
public class J1103_최솟값찾기_시간초과 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); 
    int L = Integer.parseInt(st.nextToken()); 
    int[] Arr = new int[N];

    StringTokenizer inputString = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      Arr[i] = Integer.parseInt(inputString.nextToken());
    }

    // System.out.println("Arr: " + Arrays.toString(Arr));

    int minNum = Arr[0];
    bw.write(minNum + " ");

    // 초기화
    if (L != 1) {
      for (int i=1; i<L; i++) {
        if (Arr[i] < minNum) {
          minNum = Arr[i];
        }
        bw.write(minNum + " ");
      }
    }

    // 슬라이딩 윈도우
    if (N!=L) {
      for (int i=L; i<N; i++) {
        // 첫번째 요소
        if (Arr[i-L] == minNum) {
          minNum = Arr[i-L+1];
          if (L > 2) { // 이 부분에서 시간 초과가 발생했을 것으로 추측
            // 원인: 윈도우 내에 최솟값이었던 정보들이 보존되지 않았기 때문
            // 해결: 윈도우 내에 최솟값인 적이 있던 정보들을 남겨두고
            //       윈도우에서 벗어나는 정보들은 삭제
            for (int idx=i-L+2; idx<i; idx++) {
              if (Arr[idx] < minNum) {
                minNum = Arr[idx];
              }
            } 
          }
        }
        // 마지막 요소
        if (Arr[i] < minNum) {
          minNum = Arr[i];
        }
        bw.write(minNum + " ");
      }
    }
    
    bw.flush();
    bw.close();
  }
}
