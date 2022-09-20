import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=0; tc<T; tc++) {
			//1. 입력받기
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] nums = new int[N];
			for (int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
			
			//2. 계산
			int cnt = 0;
			for (int i=0; i<(1<<N); i++) {
				int sum = 0;
				for (int j=0; j<N; j++) {
					if ((i & (1<<j)) > 0) {
						sum += nums[j];
					}
				}
				if (sum == K) {
					cnt += 1;
				}
			}
			
			//3. 출력
			System.out.printf("#%d %d\n", tc+1, cnt);
		}// tc 끝
	}
}