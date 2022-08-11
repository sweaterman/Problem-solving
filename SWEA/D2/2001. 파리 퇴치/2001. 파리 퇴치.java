import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc=0; tc<TC; tc++) {
			//1. 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] flys = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					flys[i][j] = sc.nextInt();
				}
			}
			
			//2. 계산하기
			int max = 0;
			int result = 0;
			for (int i=M-1; i<N; i++) {
				for (int j=M-1; j<N; j++) {
					for(int ii=i; ii<M+i; ii++) {
						for(int jj=j; jj<M+j; jj++) {
							result += flys[ii-M+1][jj-M+1];
						}
					}
					if (result>max) {
						max = result;
					}
					result = 0;
				}
			}
			
			//3. 출력
			System.out.printf("#%d %d\n", tc+1, max);
		}
	}
}
