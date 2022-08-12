import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int tc=0; tc<10; tc++) {
			//1. 입력받기
			int TC = sc.nextInt();
			int[][] ladder = new int[100][100];
			for (int i=99; i>=0; i--) {
				for (int j=0; j<100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			
			//2. 도착지 찾기
			int idx = -1;
			for(int i=0; i<100; i++) {
				if (ladder[0][i]==2) {
					idx = i;
					break;
				}
			}
			
			//3. 사다리 탐색
			int ii = 0;
			int jj = idx;
			int result = -1;
			while(true) {
				// 좌 우 탐색 (1이 있으면 움직이기)
				if (jj-1>=0 && ladder[ii][jj-1] == 1) {
					while(jj-1>=0 && ladder[ii][jj-1]==1) { //왼쪽 끝까지 움직이기
						jj -= 1;
					}
				}
				else if (jj+1<100 && ladder[ii][jj+1] == 1) {
					while(jj+1<100 && ladder[ii][jj+1]==1) { //오른쪽 끝까지 움직이기
						jj += 1;
					}
				}
				//밑으로 움직이기
				if (ii+1<100 && ladder[ii+1][jj] == 1) {
					ii += 1;
				}
				
				if (ii == 99) {
					result = jj;
					break;
				}
			}
			System.out.printf("#%d %d\n", TC, result);
		}
	}
}