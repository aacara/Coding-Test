package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J12891_DNA비밀번호 {
  static int[] minNum;
  static int[] myNum;
  static int result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    char[] A = br.readLine().toCharArray();

    st = new StringTokenizer(br.readLine());
    minNum = new int[4];
    myNum = new int[4];

    // 필요한 최소 A, C, G, T의 갯수
    for (int i=0; i<4; i++) {
      minNum[i] = Integer.parseInt(st.nextToken());
    }

    // 부분문자열 확인, 초기화
    for (int i=0; i<P; i++) {
      if (A[i] == 'A') {
        myNum[0] += 1;
      } else if (A[i] == 'C') {
        myNum[1] += 1;
      } else if (A[i] == 'G') {
        myNum[2] += 1;
      } else { // 'T'
        myNum[3] += 1;
      }
    }

    // 부분문자열이 조건을 만족하는지 확인
    isValid();

    // 부분문자열 슬라이딩 윈도우
    for (int i=1; i<S-P+1; i++) {
      // 부분 배열의 첫 번째 요소
      if (A[i-1] == 'A') {
        myNum[0] -= 1;
      } else if (A[i-1] == 'C') {
        myNum[1] -= 1;
      } else if (A[i-1] == 'G') {
        myNum[2] -= 1;
      } else { // 'T'
        myNum[3] -= 1;
      }

      // 부분 배열의 마지막 요소
      if (A[i+P-1] == 'A') {
        myNum[0] += 1;
      } else if (A[i+P-1] == 'C') {
        myNum[1] += 1;
      } else if (A[i+P-1] == 'G') {
        myNum[2] += 1;
      } else { // 'T'
        myNum[3] += 1;
      }
      isValid();
    }
    System.out.println(result);
    
  }

  static void isValid() {
    // System.out.println(minNum);
    // System.out.println(myNum);
    // System.out.println("========");
    for (int i=0; i<4; i++) {
      // System.out.println("myNum[i]" + myNum[i]);
      // System.out.println("minNum[i]" + minNum[i]);
      if (myNum[i] < minNum[i]) {
        return;
      }
    }
    result++;
  }
}
