import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int x;
	int y;
	int w;
	Node (int x, int y, int w){
		this.x = x;
		this.y = y;
		this.w = w;
	}
	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
	
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc=1; tc<=TC; tc++) {
			//1. 입력 받기
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				String a = sc.next();
				for(int j=0; j<N; j++) {
					map[i][j] = a.charAt(j) - '0';
				}
			}
			//2. 최단거리 배열 초기화
			int[][] dist = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
			boolean[][] visit = new boolean[N][N];
			
			//3. 계산
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0,0,0));
			dist[0][0] = 0;
			while(!pq.isEmpty()) {
				Node tmp = pq.poll();
				visit[tmp.x][tmp.y] = true;
				for (int k=0; k<4; k++) {
					int a = tmp.x + delta[k][0];
					int b = tmp.y + delta[k][1];
					if (a < N && b < N && a >= 0 && b >= 0 && !visit[a][b] 
							&& dist[a][b] > (dist[tmp.x][tmp.y]+map[a][b])) {
						dist[a][b] = dist[tmp.x][tmp.y]+map[a][b];
						pq.add(new Node(a, b, dist[a][b]));
					}
				}
			}
			
			//4. 출력
			System.out.printf("#%d %d\n", tc, dist[N-1][N-1]);
		}//테케 끝
	}//메인 끝
}