import java.util.Scanner;

public class Solution {
	static int N;
	static int K;
	static int[][] san;
	static int result;
	static int tmp;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static boolean[][] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			//1. 입력 받기
			N = sc.nextInt();
			K = sc.nextInt();
			san = new int[N][N];
			result = 0;
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					san[i][j] = sc.nextInt();
					if (san[i][j] > max) {
						max = san[i][j];
					}
				}
			}
			
			//2. 출발지 설정
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (san[i][j] == max) {
						visit = new boolean[N][N];
						tmp = 1;
						findMax(i, j, false, 1);
					}
				}
			}
			
			//3. 출력
			System.out.printf("#%d %d\n", tc, result);
		}//테케 끝
	}

	
	//등산로 탐색
	static void findMax(int x, int y, boolean check, int tmp) {
		if (tmp > result) result = tmp;
		visit[x][y] = true;
		
		for (int k=0; k<4; k++) {
			//범위 안에 있고, 방문을 안했다면?
			if(x+delta[k][0] < N && y+delta[k][1] < N && x+delta[k][0] >= 0 && y+delta[k][1] >= 0
					&& !visit[x+delta[k][0]][y+delta[k][1]]) {
				
				// 그냥 갈 수 있으면?
				if (san[x][y] > san[x+delta[k][0]][y+delta[k][1]]) {
					findMax(x+delta[k][0], y+delta[k][1], check, tmp+1);
					visit[x+delta[k][0]][y+delta[k][1]] = false;
				}
				
				// 그냥 못 가고 깎아서 갈 수 있으면?
				else if (!check && san[x][y] > san[x+delta[k][0]][y+delta[k][1]]-K ) { // 깎는닫 ㅏ
					int tmpp = san[x+delta[k][0]][y+delta[k][1]];
					while (true) {
						san[x+delta[k][0]][y+delta[k][1]] -= 1;
						if (san[x][y] > san[x+delta[k][0]][y+delta[k][1]]) {
							findMax(x+delta[k][0], y+delta[k][1], true, tmp+1);
							visit[x+delta[k][0]][y+delta[k][1]] = false;
							san[x+delta[k][0]][y+delta[k][1]] = tmpp;
							break;
						}
					}
				}
			}
		}
	}
}
