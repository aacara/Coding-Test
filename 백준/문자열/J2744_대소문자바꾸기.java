package 백준.문자열;

import java.util.Scanner;

public class J2744_대소문자바꾸기 {
  static char[] charArr;


  public static void main(String[] args) {
    input();
    changeUpperLower();
    String changedString = new String(charArr);
    System.out.println(changedString);
  }

  static void input() {
    Scanner scanner = new Scanner(System.in);
    String word = scanner.next();
    charArr = word.toCharArray();
    scanner.close();
  }

  static void changeUpperLower() {
    int charLen = charArr.length;
    for (int i = 0; i < charLen; i++) {
      char ch = charArr[i];
      // 대문자 -> 소문자
      if ('A' <= ch && ch <= 'Z') {
        charArr[i] = (char)((int)ch + 32);
        // 소문자 -> 대문자
      } else if ('a' <= ch && ch <= 'z') {
        charArr[i] = (char)((int)ch - 32);
      }
    }
  }
}

