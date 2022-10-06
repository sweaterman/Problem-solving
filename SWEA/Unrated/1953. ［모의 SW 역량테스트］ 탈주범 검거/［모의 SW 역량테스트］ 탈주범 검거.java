import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int x;
	int y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int N;
	static int M;
	static boolean[][] visit;
	static int[][] map;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우
	static int[][] check = {{1, 2, 5, 6}, {1, 2, 4, 7}, {1, 3, 4, 5}, {1, 3, 6, 7}};
	static int[][] tunnel = {{0, 0}, {0, 0}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			//1. 입력받기
			N = sc.nextInt();
			M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int L = sc.nextInt();
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//2. 계산
			int count = 0;
			visit = new boolean[N][M];
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(R, C));
			
			int t = 0;
			while (true) {
				//종료 조건
				if (t == L || q.isEmpty()) {
					break;
				}
				
				int s = q.size();
				for(int k=0; k<s; k++) {
					Node tmp = q.poll();
					if (visit[tmp.x][tmp.y]) {
						continue;
					}
					visit[tmp.x][tmp.y] = true;
					count++;
					
					if (map[tmp.x][tmp.y] == 1) { //1번 블럭
						for(int i=0; i<4; i++) {
							if (caseCheck(tmp.x, tmp.y, i)) {
								q.add(new Node(tmp.x+delta[i][0], tmp.y+delta[i][1]));
							}
						}
					}
					else { //2~7번 블럭
						for(int i=0; i<2; i++) {
							if (caseCheck(tmp.x, tmp.y, tunnel[map[tmp.x][tmp.y]][i])) {
								q.add(new Node(tmp.x+delta[tunnel[map[tmp.x][tmp.y]][i]][0], tmp.y+delta[tunnel[map[tmp.x][tmp.y]][i]][1]));
							}
						}
					}
				}
				t++;
			}
			
			//3. 출력
			System.out.printf("#%d %d\n", tc, count);
		}//테케 끝
	}//메인 끝

	//현재 x, y좌표, k는 델타
	static boolean caseCheck(int x, int y, int k) {
		int tx = x+delta[k][0];
		int ty = y+delta[k][1];
		//인덱스 범위 안에 있고
		if (tx < N && tx >= 0 && ty < M && ty >= 0) {
			//가야하는 방향과 연결되어 있고 방문을 안했다면?
			for(int j=0; j<4; j++) {
				if (map[tx][ty] == check[k][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}