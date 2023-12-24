package 백준.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J2630_색종이만들기 {
  static int N;
  static int[][] A;
  static int whiteNum, blueNum;

  public static void main(String[] args) throws IOException {
    input();
    fold(0, N-1, 0, N-1);
    System.out.println(whiteNum);
    System.out.println(blueNum);
  }
  
  static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    
    A = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    br.close();
  }

  static void fold(int startX, int endX, int startY, int endY) {
    boolean isAllZerosOrOnes = checkAllZerosOrOnes(startX, endX, startY, endY);
    if (!isAllZerosOrOnes) {
      int middleX = (startX + endX) / 2;
      int middleY = (startY + endY) / 2;
      fold(startX, middleX, startY, middleY);
      fold(middleX + 1, endX, startY, middleY);
      fold(startX, middleX, middleY + 1, endY);
      fold(middleX + 1, endX, middleY + 1, endY);
    }
  }

  static boolean checkAllZerosOrOnes(int startX, int endX, int startY, int endY) {
    int startNum = A[startX][startY];
    for (int i = startX; i <= endX; i++) {
      for (int j = startY; j <= endY; j++) {
        if (A[i][j] != startNum) {
          return false;
        }
      }
    }
    if (startNum == 0) {
      whiteNum++;
    } else {
      blueNum++;
    }

    return true;
  }
}
