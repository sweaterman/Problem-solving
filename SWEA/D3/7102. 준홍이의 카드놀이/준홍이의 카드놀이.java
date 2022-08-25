import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] check = new int[N+M+1];
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					check[i+j] += 1;
				}
			}
			
			int max = 0;
			for(int i=0; i<check.length; i++) {
				if(max < check[i]) {
					max = check[i];
				}
			}
			
			System.out.printf("#%d ", tc);
			for(int i=0; i<check.length; i++) {
				if (max == check[i]) {
					System.out.printf("%d ", i);
				}
			}
			System.out.println();
			
		}
	}
}