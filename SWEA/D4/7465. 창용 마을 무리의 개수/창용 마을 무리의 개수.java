import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] graph;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			//1. 입력 받기
			N = sc.nextInt();
			int M = sc.nextInt();
			graph = new int[N+1][N+1];
			for(int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph[a][b] = 1;
				graph[b][a] = 1;
			}
			//2. 계산
			int cnt = 0;
			visit = new boolean[N+1];
			for (int i=1; i<N+1; i++) {
				if (!visit[i]) {
					cal(i);
					cnt++;
				}
			}
			//3. 출력
			System.out.printf("#%d %d\n", tc, cnt);
		}//테케 끝
	}
	
	static void cal(int x) {
		visit[x] = true;
		for (int i=1; i<N+1; i++) {
			if(!visit[i] && graph[x][i]==1) {
				cal(i);
			}
		}
	}
}