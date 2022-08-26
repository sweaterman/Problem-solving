import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			//1. 입력 받기
			int N = sc.nextInt();
			int[] buy = new int[N];
			for(int i=0; i<N; i++) {
				buy[i] = sc.nextInt();
			}
			
			//2. 계산
			long profit = 0;
			int maxidx = N-1;
			for(int i=N-2; i>=0; i--) {
				//이윤을 더해야할 때
				if(buy[maxidx] > buy[i]) {
					 profit += buy[maxidx] - buy[i];
				}
				//맥스 인덱스 교체
				else {
					maxidx = i;
				}
				
			}
			
			//3. 출력
			System.out.printf("#%d %d\n", tc, profit);
		}
	}
}