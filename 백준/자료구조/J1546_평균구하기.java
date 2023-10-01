package 백준.자료구조;

import java.util.Scanner;

public class J1546_평균구하기 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int[] arr = new int[N];
    int sum = 0;
    int max = 0;

    for (int i=0; i<N; i++) {
      arr[i] = scan.nextInt();
      sum += arr[i];
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    double average = sum * 100.0 / max / N;
    System.out.print(average);
     
  }
  
}
