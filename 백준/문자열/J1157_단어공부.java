package 백준.문자열;

import java.util.Arrays;
import java.util.Scanner;

public class J1157_단어공부 {
  static char[] charArr;
  static int[] alphabetNum = new int[26];
  static int max;
  static int maxIdx;
  static boolean isOverlap = false; 

  public static void main(String[] args) {
    input();
    cntAlphabet();
    getMax();
    // System.out.println("charArr"+Arrays.toString(charArr));
    // System.out.println("alphabetNum"+Arrays.toString(alphabetNum));
    if (!isOverlap) {
      System.out.println((char)(maxIdx + 65));
    } else { // isOverlap: 가장 많이 사용된 알파벳이 여러 개 존재하는 경우
      System.out.println("?");
    }
  }

  static void input() {
    Scanner scanner = new Scanner(System.in);
    String word = scanner.next();
    String upperCaseWord = word.toUpperCase();
    charArr = upperCaseWord.toCharArray();
  }

  static void cntAlphabet() {
    int charLen = charArr.length;
    for (int i = 0; i <charLen; i++) {
      int idx = (int)charArr[i] - 65;
      alphabetNum[idx]++;
    }
  }

  static void getMax() {
    max = 0;
    for (int i = 0; i < alphabetNum.length; i++) {
      if (alphabetNum[i] > max) {
        max = alphabetNum[i];
        maxIdx = i;
        isOverlap = false;
      } else if (alphabetNum[i] != 0 && alphabetNum[i] == max) {
        isOverlap = true;
      }
    }
  }
}
