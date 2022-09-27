import java.util.Scanner;

public class Solution {
	static int[] price; //1일, 1달, 3달, 1년
	static int[] plan;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			//1. 입력 받기
			price = new int[4];
			for(int i=0; i<4; i++) {
				price[i] = sc.nextInt();
			}
			plan = new int[12];
			for(int i=0; i<12; i++) {
				plan[i] = sc.nextInt();
			}
			result = price[3];
			
			//2. 계산
			dfs(0, 0);
			
			//3. 출력
			System.out.printf("#%d %d\n", tc, result);
		}//테케 끝
	}

	private static void dfs(int x, int tmp) {		
		if (x > 11) {
			if (tmp < result) {
				result = tmp;
			}
			return;
		}
		
		if (plan[x] == 0) {
			dfs(x+1, tmp);
		}
		else {
			dfs(x+1, tmp+plan[x]*price[0]); //1일
			dfs(x+1, tmp+price[1]); //1달
			dfs(x+3, tmp+price[2]); //3달
		}
	}
}