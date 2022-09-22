import java.util.Scanner;

class Solution {
	static int N;
	static int M;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc=1; tc<=10; tc++) {
			sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			result = 1;
			cal(0);
			System.out.printf("#%d %d\n", tc, result);
		}//테스트케이스
	}
	
	static void cal(int x) {
		if (x == M) {
			return;
		}
		result *= N;
		cal(x+1);
	}
}