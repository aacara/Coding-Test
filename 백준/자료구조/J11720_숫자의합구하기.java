package 백준.자료구조;
import java.util.Scanner;


public class J11720_숫자의합구하기 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int num = scan.nextInt();
    String N = scan.next();
    scan.close();

    char[] cN = N.toCharArray();
    int sum = 0;
    int len = cN.length;
    for (int i=0; i< len; i++) {
      sum += cN[i] - '0';
    }
    System.out.print(sum);
  }
}