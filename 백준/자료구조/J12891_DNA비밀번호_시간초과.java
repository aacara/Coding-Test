package 백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J12891_DNA비밀번호_시간초과 {
  static int[] minNum;
  static int[] myNum;
  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    char A[] = new char[S];
    A = br.readLine().toCharArray();
  
    st = new StringTokenizer(br.readLine());
    minNum = new int[4];
    for (int i=0; i<4; i++) {
      minNum[i] = Integer.parseInt(st.nextToken());
    }

    // 부분문자열 확인
    for (int i=0; i<S-P+1; i++) {
      checkMinNum(Arrays.copyOfRange(A, i, i+P));
    }
    System.out.print(result);
  }

  static void checkMinNum(char[] arr) {
    // System.out.println(arr);
    myNum = new int[4];
    int arrLen = arr.length;
    for (int i=0; i<arrLen; i++) {
      switch(arr[i]) {
        case 'A':
          myNum[0] += 1;
          break;
        case 'C':
          myNum[1] += 1;
          break;
        case 'G':
          myNum[2] += 1;
          break;
        case 'T':
          myNum[3] += 1;
          break;
      }
    }
    isValid();
  }

  static void isValid() {
    // System.out.println(minNum);
    // System.out.println(myNum);
    // System.out.println("========");
    for (int i=0; i<4; i++) {
      // System.out.println("myNum[i]" + myNum[i]);
      // System.out.println("minNum[i]" + minNum[i]);
      if (myNum[i] < minNum[i]) {
        myNum = new int[4];
        return;
      }
    }
    result++;
    myNum = new int[4];
  }
  
}
