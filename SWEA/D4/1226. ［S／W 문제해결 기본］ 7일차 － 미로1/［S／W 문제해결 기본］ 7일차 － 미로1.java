import java.util.Scanner;

class Solution {
	static int N = 16;
	static int[][] miro;
	static int start_i;
	static int start_j;
	static int result;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			//1. 입력받기
			int TC = sc.nextInt();
			miro = new int[N][N];
			visit = new boolean[N][N];
			for(int i=0; i<N; i++) {
				String input = sc.next();
				for(int j=0; j<N; j++) {
					miro[i][j] = input.charAt(j) - '0';
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visit[i][j] = false;
				}
			}
			
			//2. 출발지점 찾기
			end: for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (miro[i][j] == 2) {
						start_i = i;
						start_j = j;
						break end;
					}
				}
			}
			
			//3. 계산
			result = 0;
			dfs(start_i, start_j);
			System.out.printf("#%d %d\n", TC, result);
		}//테케 끝
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		
		// 도착지를 찾은 상태라면 끝내기
		if (result == 1) {
			return;
		}
		
		// 도착했는지 검사
		if (miro[x][y] == 3) {
			result = 1;
			return;
		}
		
		// 4방향 방문하기
		for (int k=0; k<4; k++) {
			//인덱스 검사, 갈 수 있는 곳인지 검사, 방문 검사
			if (x+delta[k][0] < N && y+delta[k][1] < N && x+delta[k][0] >= 0 && y+delta[k][1] >= 0
					&& miro[x+delta[k][0]][y+delta[k][1]] != 1 && visit[x+delta[k][0]][y+delta[k][1]] == false) {
				dfs(x+delta[k][0], y+delta[k][1]);
			}
		}
	}
}
