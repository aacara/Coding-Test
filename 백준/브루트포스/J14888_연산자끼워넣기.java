package 백준.브루트포스;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J14888_연산자끼워넣기 {
  static int N, minVal, maxVal;
  static int[] A;
  static int[] operationArr;

  static StringBuilder sb = new StringBuilder();
  static FastReader scan = new FastReader();


  static void input() {
    N = scan.nextInt();
    A = new int[N+1];
    operationArr = new int[5];

    for (int i = 1; i < N+1; i++) {
      A[i] = scan.nextInt();
    }
    for (int i = 1; i < 5; i++) {
      operationArr[i] = scan.nextInt();
    }

    minVal = Integer.MAX_VALUE;
    maxVal = Integer.MIN_VALUE;
  }

  static void recFunction(int k, int value) {
    // 종료조건
    if (k == N) {
      // 결과를 연산하는 함수
      //int result = calculator();
      maxVal = Math.max(maxVal, value);
      minVal = Math.min(minVal, value);
    } else {
      // 연산자 선택
      for (int cand = 1; cand <= 4; cand++) {
        if (operationArr[cand] > 0) {
          operationArr[cand]--;
          int newValue = calculator(value, cand, A[k+1]);
          recFunction(k+1, newValue);
          operationArr[cand]++;
        }
      }
    }
  }

  // static int calculator() {
  //   int result = A[1];
  //   for (int i = 1; i< N; i++) {
  //     if (operationArr[i] == 1) { // +
  //       result += A[i+1];
  //     } else if (operationArr[i] == 2) { // -
  //       result -= A[i+1];
  //     } else if (operationArr[i] == 3) { // *
  //       result *= A[i+1];
  //     } else { // /
  //       result = result / A[i+1];
  //     }
  //   }
  //   return result;
  // }
  

  static int calculator(int operand1, int operator, int operand2) {
    // nums, order
    if (operator == 1) { // +
      return operand1 + operand2;
    } else if (operator == 2) { // -
      return operand1 - operand2;
    } else if (operator == 3) { // *
      return operand1 * operand2;
    } else { // /
      return operand1 / operand2;
    }
  }

  public static void main(String[] args) {
    input();
    recFunction(1, A[1]);
    sb.append(maxVal).append('\n').append(minVal);
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
      while (st == null || !st.hasMoreElements()) {
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
