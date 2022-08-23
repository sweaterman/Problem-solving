import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int TC = 1; TC <= tc; TC++) {
			// 1. 입력받기
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				String a = sc.next();
				for (int j=0; j<N; j++) {
					farm[i][j] = a.charAt(j)-'0';
				}
			}

			// 2. 계산하기
			int sum = 0;
			int count = 1;
			for (int i = 0; i < N; i++) {
				for (int j = N / 2 - count/2; j < N / 2 + count/2+1; j++) {
					sum += farm[i][j];
				}
				if (i < N / 2) { // 위쪽 줄
					count += 2;
				} else { // 아래쪽 줄
					count -= 2;
				}
			}
			
			//3. 출력하기
			System.out.printf("#%d %d\n", TC, sum);
		}
	}
}