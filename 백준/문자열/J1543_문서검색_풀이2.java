package 백준.문자열;

import java.util.Scanner;

public class J1543_문서검색_풀이2 {

  static String document;
  static String word;
  static int documentLen;
  

  public static void main(String[] args) {
    input();
    documentLen = document.length();
    deleteWords();
    int cnt = CntDeletedWords();
    System.out.println(cnt);
  }

  static void input() {
    Scanner scanner = new Scanner(System.in);
    document = scanner.nextLine();
    word = scanner.nextLine();
    scanner.close();
  }

  static void deleteWords() {
    // System.out.println("before document: " + document);
    document = document.replace(word, "");
    // System.out.println("changed document: " + document);
  }

  static int CntDeletedWords() {
    int wordLen = word.length();
    int cnt = (documentLen - document.length()) / wordLen; 
    return cnt;
  }
}
    