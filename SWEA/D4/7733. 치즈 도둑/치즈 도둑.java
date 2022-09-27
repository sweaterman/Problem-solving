import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] cz;
	static int cnt;
	static int tmp;
	static boolean[][] visit;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			cz = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cz[i][j] = sc.nextInt();
				}
			}
			cnt = 1;
			
			for(int k=1; k<=100; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(cz[i][j] == k) {
							cz[i][j] = 0;
						}
					}
				}
				visit = new boolean[N][N];
				count();
				if (tmp > cnt) {
					cnt = tmp;
				}
				tmp = 0;
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}//테케 끝
	}
	
	//덩어리는 몇개인가
	static void count() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if (!visit[i][j] && cz[i][j] != 0) {
					tmp += 1;
					count1(i, j);
				}
			}
		}
	}
	
	//과연 몇개인가
	static void count1(int x, int y) {
		visit[x][y] = true;
		for (int k=0; k<4; k++) {
			if (x+delta[k][0] < N && y+delta[k][1] < N && x+delta[k][0] >= 0 && y+delta[k][1] >= 0
					&& !visit[x+delta[k][0]][y+delta[k][1]] && cz[x+delta[k][0]][y+delta[k][1]] != 0 ) {
				count1(x+delta[k][0], y+delta[k][1]);
			}
		}
	}
}