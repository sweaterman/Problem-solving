import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc=0; tc<TC; tc++) {
			// 1. 입력받기
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] puzzle = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			
			//2. 계산하기
			int sum = 0;
			int count = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (puzzle[i][j] == 0) { continue; }
					
						//가로 검사
						for(int jj=j; jj<N; jj++) {
							if (puzzle[i][jj] == 0) { break; }
							count++; 
						}
						if (count == K) {
							if (j>0 && puzzle[i][j-1]==1) {	sum--;	}
							sum++;
						}
						count = 0;
						
						//세로 검사
						for (int ii=i; ii<N; ii++) {
							if (puzzle[ii][j] == 0) { break; }
							count++; 
						}
						if (count == K) { 
							if (i>0 && puzzle[i-1][j]==1) {	sum--; }
							sum++; 
						}
						count = 0;
				}
			}
			
			//3. 출력
			System.out.printf("#%d %d\n", tc+1, sum);
		}
	}
}