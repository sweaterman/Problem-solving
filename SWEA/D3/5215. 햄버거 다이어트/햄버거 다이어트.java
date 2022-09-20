import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=0; tc<T; tc++) {
			//1. 입력받기
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[] score = new int[N];
			int[] cal = new int[N];
			for (int i=0; i<N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			//2. 계산
			int max_score = 0;
			for (int i=0; i<(1<<N); i++) {
				int sum_cal = 0;
				int sum_score = 0;
				for(int j=0; j<N; j++) {
					if ((i & 1<<j) > 0) {
						sum_cal += cal[j];
						sum_score += score[j];
					}
				}
				if (sum_cal <= L && sum_score > max_score) {
					max_score = sum_score;
				}
			}
			
			//3. 출력
			System.out.printf("#%d %d\n", tc+1, max_score);
		}
	}
}