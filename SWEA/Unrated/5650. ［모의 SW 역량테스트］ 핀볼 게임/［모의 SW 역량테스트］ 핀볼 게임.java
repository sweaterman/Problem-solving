import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] map;
	static int result;
	static int tmp;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //우, 좌, 하, 상
	static int[][] block = {{1, 3, 0, 2}, {1, 2, 3, 0}, {2, 0, 3, 1}, {3, 0, 1, 2}, {1, 0, 3, 2}};
	static int[] wall = {1, 0, 3, 2};
	static int start_x;
	static int start_y;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc=1; tc<=TC; tc++) {
			// 1. 입력 받기
			N = sc.nextInt();
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			result = 0;
			
			//2. 전체 경우 계산 - 시작위치 선택
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j] == 0) {
						//시작가능 - 시작 방향 선택
						start_x = i;
						start_y = j;
						for(int k=0; k<4; k++) {
							tmp = 0;
							game(i, j, k);
							if (tmp > result) {
								result = tmp;
							}
						}
					}
				}
			}
			
			//3. 출력
			System.out.printf("#%d %d\n", tc, result);
		}//테케 끝
	}//메인 끝
	
	//좌표, 방향
	static void game(int x, int y, int k) {
		int a = x+delta[k][0];
		int b = y+delta[k][1];
		
		//종료조건 1. 처음 위치
		if (a == start_x && b == start_y) {
			return;
		}
		
		//이동 했는데 벽이면?
		else if (a == N || a == -1 || b == N || b == -1) {
			tmp += 1;
			game(a, b, wall[k]);
		}
		
		//빈칸이라면?
		else if (map[a][b] == 0) {
			game(a, b, k);
		}
		
		//블록 중 하나라면?
		else if (map[a][b] >= 1 && map[a][b] <= 5) {
			tmp+= 1;
			game(a, b, block[map[a][b]-1][k]);
		}
		
		//웜홀이라면?
		else if (map[a][b] >= 6 && map[a][b] <= 10) {
			for (int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (map[a][b] == map[i][j] && (i != a || j != b)) {
						game(i, j, k);
					}
				}
			}
		}
		//종료조건 2. 블랙홀
		else if (map[a][b] == -1) {
			return;
		}
	}
}