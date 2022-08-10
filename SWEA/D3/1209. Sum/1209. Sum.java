import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for (int tc=0; tc<10; tc++) {
			int TC = sc.nextInt();
			int[][] arr = new int[100][100];
			
			//1. 입력받기
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int sumA = 0, sumB = 0;
			int[] C = new int[100];
			int[] D = new int[100];
			
			//2. 돌면서 합 구하기
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					if(i==j) { sumA += arr[i][j]; } //1번 대각선 합
					if(i+j == 99) { sumB += arr[i][j]; } //2번 대각선 합
					C[j] += arr[i][j];
					D[i] += arr[i][j];
				}
			}
			
			//3. 결과
			int result = sumA;
			if (sumA < sumB) { result = sumB; }
			for (int i=0; i<C.length; i++) {
				if(C[i] > result) { result = C[i]; }
				if(D[i] > result) { result = D[i]; }
			}
			System.out.printf("#%d %d\n", TC, result);
		}
	}
}
