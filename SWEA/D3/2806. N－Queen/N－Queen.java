import java.util.Scanner;

class Solution {
	static int N;
	static int[][] map;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			ans = 0;
			map = new int[N][N];
			
			putQueen(0);
			System.out.println("#"+tc+" "+ans);
		}//테스트 케이스
	}//메인
	
	static void putQueen(int r) {
		if(r==N) {
			ans++;
			return;
		}
		
		for(int c=0; c<N; c++) {
			if(isPutable(r,c)) {
				map[r][c] = 1; //퀸 놓기
				putQueen(r+1);
				map[r][c] = 0; // 다음 자리를 위해 퀸 회수
			}
		}
	}
	
	static boolean isPutable(int r, int c) {
		int left = c;
		int right = c;
		
		for(int i=r-1; i>=0; i--) {
			left--;
			right++;
			
			if(map[i][c] == 1) return false;
			if(left >= 0 && map[i][left] == 1) return false;
			if(right <N && map[i][right] == 1) return false;
		}
		
		return true;
	}
	
}