package 백준.자료구조;

import java.util.Scanner;

public class J2018_연속된자연수의합구하기 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int cnt = 1, sum = 1;
    int start_idx = 1, end_idx = 1;
    while (end_idx != N) {
      if (sum < N) {
        end_idx++;
        sum += end_idx;
      } else if (sum == N) {
        cnt++;
        end_idx++;
        sum += end_idx;
      } else { // sum > N
        sum -= start_idx;
        start_idx++;
      }
    }
    System.out.println(cnt);
  }
  
}
