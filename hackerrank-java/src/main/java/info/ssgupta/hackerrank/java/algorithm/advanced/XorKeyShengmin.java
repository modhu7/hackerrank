/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.ssgupta.hackerrank.java.algorithm.advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

/**
 *
 * @author ssgupta
 */
/*
0 - 14
0 - 14
0 - 14
0 - 14
0 - 14
0 - 14
0 - 14
0 - 14
0 - 14
0 - 14
0 - 14
0 - 14
0 - 14
0 - 6
7 - 14
0 - 2
3 - 6
7 - 10
11 - 14
0 - 0
1 - 2
3 - 4
5 - 6
7 - 8
9 - 10
11 - 12
13 - 14
0 - 0
1 - 1
2 - 2
3 - 3
4 - 4
5 - 5
6 - 6
7 - 7
8 - 8
9 - 9
10 - 10
11 - 11
12 - 12
13 - 13
14 - 14
*/
public class XorKeyShengmin {

  static final int MAX_NUM = 32768;

  static class Node {

    Node(int start, int end) {
      this.start = start;
      this.end = end;
    }

    int start, end;

    boolean intersects(int s, int e) {
      if (start < s && end >= s) {
        return true;
      }
      if (start >= s && start <= e) {
        return true;
      }
      return false;
    }
  }

  static class BinaryTree {

    Node[] nodes;
    int[] nums;

    BinaryTree(int[] nums) {
      this.nums = nums;
      nodes = new Node[100000]; // should be enough for this problem
      initialize(nums, 0, 0, nums.length - 1, MAX_NUM);
    }

    int getLeftChildIndex(int i) {
      return 2 * i + 1;
    }

    int getRightChildIndex(int i) {
      return 2 * i + 2;
    }

    void initialize(int[] nums, int index, int start, int end, int mask) {
      nodes[index] = new Node(start, end);

      if (mask == 0) {
        return;
      }

      int leftIndex = getLeftChildIndex(index);
      int rightIndex = getRightChildIndex(index);

      // if the first number's current digit is 1, then left child doesn't exist
      if ((mask & nums[start]) == mask) {
        initialize(nums, rightIndex, start, end, mask >>> 1);
        return;
      }

      // find the split point
      int i = start;
      for (; i <= end; i++) {
        if ((mask & nums[i]) == mask) {
          // this digit is 1
          break;
        }
      }

      initialize(nums, leftIndex, start, i - 1, mask >>> 1);

      if (i <= end) {
        // right child
        initialize(nums, rightIndex, i, end, mask >>> 1);
      }
    }

    int query(int A, int start, int end) {
      return query(A, start, end, 0, MAX_NUM);
    }

    int query(int A, int start, int end, int index, int mask) {
      if (start == end) {
        return nums[start];
      }
      if (mask == 0) {
        return nums[start];
      }

      int leftIndex = getLeftChildIndex(index);
      int rightIndex = getRightChildIndex(index);

      Node left = nodes[leftIndex];
      Node right = nodes[rightIndex];

      if ((A & mask) == mask) {
        // current digit is 1
        // go to the right child if intersects the range
        if (left != null && left.intersects(start, end)) {
          return query(A, start, Math.min(end, left.end), leftIndex, mask >>> 1);
        } else {
          return query(A, Math.max(start, right.start), end, rightIndex, mask >>> 1);
        }
      } else if (right != null && right.intersects(start, end)) {
        return query(A, Math.max(start, right.start), end, rightIndex, mask >>> 1);
      } else {
        return query(A, start, Math.min(end, left.end), leftIndex, mask >>> 1);
      }
    }

    void print() {
      for (Node node : nodes) {
        if (node == null) {
          continue;
        }
        System.out.printf("%d - %d", node.start, node.end);
        System.out.println();
      }
    }
  }

  void sort(int[] nums) {
    int count[] = new int[MAX_NUM + 1];
    for (int i = nums.length - 1; i >= 0; i--) {
      count[nums[i]]++;
    }

    for (int i = 0, j = 0; j <= MAX_NUM; j++) {
      while (count[j] != 0) {
        nums[i++] = j;
        count[j]--;
      }
    }
  }

  void solve(BufferedReader rd, int Q, int[] nums) throws Exception {
    sort(nums);
    
    BinaryTree tree = new BinaryTree(nums);
    tree.print();

    for (; Q > 0; Q--) {
      StringTokenizer st = new StringTokenizer(rd.readLine());
      int a = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      int n = tree.query(a, p - 1, q - 1);
      int max = n ^ a;
//			for(int i = p - 1; i < q; i++){ 
//				int xor = nums[i] ^ a;
//				if(xor > max) max = xor;
//				//System.out.printf("%4d ^ %4d = %4d : %10s ^ %10s = %10s", nums[i], a, xor, Integer.toBinaryString(nums[i]), Integer.toBinaryString(a), Integer.toBinaryString(xor));
//				//System.out.println();
//			}

      System.out.println(max);
    }
  }

  void run(BufferedReader rd) throws Exception {
    int T = Integer.parseInt(rd.readLine());
    for (; T > 0; T--) {
      StringTokenizer st = new StringTokenizer(rd.readLine());
      int N = Integer.parseInt(st.nextToken());
      int Q = Integer.parseInt(st.nextToken());
      int[] nums = new int[N];

      st = new StringTokenizer(rd.readLine());
      for (int i = 0; i < N; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
      }

      solve(rd, Q, nums);
    }
  }

  public static void main(String[] args) throws Exception {
    Reader rd = (args.length == 0) ? new InputStreamReader(System.in) : new FileReader(args[0]);
    new XorKeyShengmin().run(new BufferedReader(rd));
  }

}
