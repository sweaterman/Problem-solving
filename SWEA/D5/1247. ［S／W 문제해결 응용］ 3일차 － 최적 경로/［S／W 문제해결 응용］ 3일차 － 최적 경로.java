import java.util.Scanner;

class Solution {
	static int N;
	static int[][] xy;
	static int[][] wh;
	static int result;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc=1; tc<=TC; tc++) {
			result = Integer.MAX_VALUE;
			N = sc.nextInt();
			xy = new int[N][2];
			wh = new int[2][2];
			visit = new boolean[N];
			for (int i=0; i<N; i++) {
				visit[i] = false;
			}
			for(int i=0; i<2; i++) {
				wh[i][0] = sc.nextInt();
				wh[i][1] = sc.nextInt();
			}
			for(int i=0; i<N; i++) {
				xy[i][0] = sc.nextInt();
				xy[i][1] = sc.nextInt();
			}
			perm(0, 0, 0);
			System.out.printf("#%d %d\n", tc, result);
		}//테스트케이스

	}
	
	static void perm(int idx, int tmp, int pre) {
		if (idx == N) {
			tmp += Math.abs(wh[1][0]-xy[pre][0])+Math.abs(wh[1][1]-xy[pre][1]);
			if(tmp < result) {
				result = tmp;
			}
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				int tmp2 = tmp;
				// 회사와 거리
				if (idx == 0)
					tmp2 += Math.abs(wh[0][0]-xy[i][0])+Math.abs(wh[0][1]-xy[i][1]);
				else {
					tmp2 += Math.abs(xy[pre][0]-xy[i][0])+Math.abs(xy[pre][1]-xy[i][1]);
				}
				perm(idx+1, tmp2, i);
				visit[i] = false;
			}
		}	
	}	
}