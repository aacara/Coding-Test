package 백준.문자열;

import java.util.Arrays;
import java.util.Scanner;

public class J1919_애너그램만들기 {
  static char[] charArr1;
  static char[] charArr2;
  static int cnt;

  public static void main(String[] args) {
    input();
    makeAnagram();
    int deleteNum = charArr1.length + charArr2.length - cnt*2;
    System.out.println(deleteNum);
  }

  static void input() {
    Scanner scanner = new Scanner(System.in);
    String word1 = scanner.nextLine();
    String word2 = scanner.nextLine();
    charArr1 = word1.toCharArray();
    charArr2 = word2.toCharArray();
    Arrays.sort(charArr1);
    Arrays.sort(charArr2);
    scanner.close();
  }

  static void makeAnagram() {
    int startIdx1 = 0;
    int startIdx2 = 0;
    while (startIdx1 < charArr1.length && startIdx2 < charArr2.length) {
      if (charArr1[startIdx1] < charArr2[startIdx2]) {
        startIdx1++;
      } else if (charArr1[startIdx1] == charArr2[startIdx2]) {
        cnt++;
        startIdx1++;
        startIdx2++;
      } else { // startIdx1 > startIdx2
        startIdx2++;
      }
    }
  }
  
}
