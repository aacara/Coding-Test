package 백준.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class J1103_최솟값찾기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int[] Arr = new int[N];

    StringTokenizer inputString = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      Arr[i] = Integer.parseInt(inputString.nextToken());
    }

    Deque<Node> deque = new LinkedList<>();
    for (int i=0; i<N; i++) {
      while (!deque.isEmpty() && deque.getLast().val > Arr[i]) {
        deque.removeLast();
      }
      deque.addLast(new Node(i, Arr[i]));
      
      if (deque.getFirst().idx <= i-L) {
        deque.removeFirst();
      }
      bw.write(deque.getFirst().val + " ");
    }
    bw.flush();
    bw.close();

  }

  static class Node {
    public int idx;
    public int val;

    Node(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }
  }
}
