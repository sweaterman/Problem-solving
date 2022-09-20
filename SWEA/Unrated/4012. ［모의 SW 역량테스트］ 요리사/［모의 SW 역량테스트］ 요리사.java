import java.util.Scanner;

public class Solution {
	static boolean[] check;
	static int N;
	static int distance;
	static int[][] S;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=0; tc<T; tc++) {
			N = sc.nextInt();
			S = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					S[i][j] = sc.nextInt();
				}
			}
			check = new boolean[N];
			for(int i=0; i<N; i++) {
				check[i] = false;
			}
			distance = Integer.MAX_VALUE;
			combination(0, 0);
			
			System.out.printf("#%d %d\n", tc+1, distance);
		}
	}
	
	//식재료 선택하기
	static void combination(int idx, int cnt) {
		if (cnt == N/2) {
			cal();
		}
		
		else {
			for(int i=idx; i<N; i++) {
				check[i] = true;
				combination(i+1, cnt+1);
				check[i] = false;
			}
		}
	}
	
	//시너지 계산하기
	static void cal() {
		int sumA = 0;
		int sumB = 0;
		for(int i=0; i<N; i++) {
			if (check[i]) {
				for(int j=0; j<N; j++) {
					if(i!=j && check[j]) {
						sumA += S[i][j];
					}
				}
			}
			else {
				for(int j=0; j<N; j++) {
					if(i!=j && !check[j]) {
						sumB += S[i][j];
					}
				}
			}
		}
		
		int result = Math.abs(sumA-sumB);
		if (result < distance) {
			distance = result;
		}
	}
}