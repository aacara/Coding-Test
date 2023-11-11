package 백준.문자열;

import java.util.Scanner;

public class J1543_문서검색_풀이1 {

  static String document;
  static String word;
  static char[] docArr;
  static char[] wordArr;

  public static void main(String[] args) {
    input();
    int documentLen = document.length();
    int wordLen = word.length();
    int wordIdx = 0;
    int documentIdx = 0;
    int documentRollbackIdx = 1;
    int cnt = 0;
    while (documentIdx < documentLen) {

      if (docArr[documentIdx] == wordArr[wordIdx]) {
        wordIdx++;
        documentIdx++;
      } else {
        wordIdx = 0;
        documentIdx = documentRollbackIdx;
        documentRollbackIdx = documentIdx + 1;
      }

      if (wordIdx == wordLen) {
        wordIdx--;
        cnt++;
        wordIdx = 0; 
        documentRollbackIdx = documentIdx;
      }
    }
    System.out.println(cnt);
  }

  static void input() {
    Scanner scanner = new Scanner(System.in);
    document = scanner.nextLine();
    word = scanner.nextLine();
    scanner.close();

    docArr = document.toCharArray();
    wordArr = word.toCharArray();
  }  
}
