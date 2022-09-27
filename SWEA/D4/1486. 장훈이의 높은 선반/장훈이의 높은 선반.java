import java.util.Scanner;

public class Solution {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			//1. 입력 받기
			int N = sc.nextInt();
			int B = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			//2. 계산
			int result = Integer.MAX_VALUE;
			for(int i=1; i<(1 << N); i++) {
				//i의 경우?
				int tmp = 0;
				for (int j=0; j<N; j++) {
					if ((i & (1 << j)) > 0) {
						tmp += arr[j];
					}
				}
				if (tmp >= B && result > tmp-B) {
					result = tmp-B;
				}
			}
			//3. 출력
			System.out.printf("#%d %d\n", tc, result);
		}
	}	
}