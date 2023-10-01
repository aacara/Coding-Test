package 백준.자료구조;

import java.util.Scanner;

public class J11659_구간합구하기 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] arr = new int[N+1];
    for (int i=1; i<N+1; i++) {
      arr[i] = arr[i-1] + sc.nextInt();
    }
    int start, end, sum;
    for (int j=0; j<M; j++) {
      start = sc.nextInt();
      end = sc.nextInt();
      sum = arr[end]- arr[start-1];
      System.out.println(sum);
    }
  }
  
}
