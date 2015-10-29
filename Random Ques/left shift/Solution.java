public class Solution {
  public static void main(String args[]) {
    int n = 6;
    for (int i = 0; i < 16; i++) {
      n = Integer.rotateLeft(n, 1);
      System.out.println(n);
    }
  }
}