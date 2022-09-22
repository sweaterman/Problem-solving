import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	static int win;
	static int lose;
	static int[] A;
	static int[] B;
	static boolean[] visit;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc=1; tc<=TC; tc++) {
			List<Integer> nums = new ArrayList<>();
			for(int i=1; i<=18; i++) {
				nums.add(i);
			}
			A = new int[9];
			B = new int[9];
			for(int i=0; i<9; i++) {
				A[i] = sc.nextInt();
				nums.remove(Integer.valueOf(A[i]));
			}
			for(int i=0; i<9; i++) {
				B[i] = nums.get(i);
			}
			win = 0;
			lose = 0;
			result = new int[9];
			visit = new boolean[9];
			for (int i=0; i<9; i++) {
				visit[i] = false;
			}
			cal(0);
			System.out.printf("#%d %d %d\n", tc, win, lose);
		}//테스트케이스
	}
	
	public static void cal(int idx) {
		if (idx == 9) {
			int checkA = 0;
			int checkB = 0;
			for(int i=0; i<9; i++) {
				if (A[i] > result[i]) {
					checkA += A[i] + result[i];
				}
				else {
					checkB += A[i] + result[i];
				}
			}
			if(checkA > checkB) {
				win += 1;
			}
			else if (checkA < checkB) {
				lose += 1;
			}
			return;
		}
		
		for (int i=0; i<9; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				result[idx] = B[i];
				cal(idx+1);
				visit[i] = false;
			}
		}
	}
}