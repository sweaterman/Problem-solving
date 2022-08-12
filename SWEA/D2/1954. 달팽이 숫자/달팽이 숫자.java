import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 0; tc < TC; tc++) {
			// 1. 입력받고 -1로 n*n배열을 초기화
			int n = sc.nextInt();
			int[][] snail = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					snail[i][j] = -1;
				}
			}

			int count = 1;
			int[][] d = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우 하 좌 상
			int i = 0, j = 0;
			snail[0][0] = 1;
			
			for (int k=0; k<n*n-1; k++) {
				while(true) {
					if (i+d[k%4][0]>=n || j+d[k%4][1]>=n || i+d[k%4][0]<0 || j+d[k%4][1]<0 || snail[i+d[k%4][0]][j+d[k%4][1]]!=-1) {
						break;
					}
					i += d[k%4][0];
					j += d[k%4][1];
					snail[i][j] = ++count;
				}
			}
			
			System.out.printf("#%d\n", tc+1);
			for (int ii = 0; ii < n; ii++) {
				for (int jj = 0; jj < n; jj++) {
					System.out.printf("%d ", snail[ii][jj]);
				}
				System.out.println();
			}
		}
	}
}