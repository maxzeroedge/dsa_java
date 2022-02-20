// https://www.interviewbit.com/problems/gas-station/

public class GasStationStartingIndex {

  public static void main(String[] args) {
    // int[] A = new int[]{1,2};
    // int[] B = new int[]{2,1};
	int[] A = new int[]{8,0,0,0,0,2};
    int[] B = new int[]{2,2,2,2,2,2};
    System.out.println(getStartingIndex(A,B));
  }

  public static int getStartingIndex(int[] A, int[] B) {
    int len = A.length;
    int start = 0;
    int visited = 0;
    while(visited != len && start < len) {
      int current = start;
      int fuel = 0;
      do {
        if(B[current] > fuel + A[current]) {
          start++; visited = 0; break;
        } else {fuel += A[current] - B[current]; visited++;}
        current = (current + 1) % len;
      } while(current != start);
    }
    if(start >= len) {return -1;}
    return start;
  }
}

