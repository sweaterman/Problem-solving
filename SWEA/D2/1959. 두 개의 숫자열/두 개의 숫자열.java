import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int TC=0; TC<tc; TC++) {
			//1. 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] ns = new int[N];
			int[] ms = new int[M];
			
			for(int i=0; i<N; i++) {
				ns[i] = sc.nextInt();
			}
			
			for(int i=0; i<M; i++) {
				ms[i] = sc.nextInt();
			}
			
			//2. 길이가 짧은 배열을 ns에 두기 
			if (N>M) {
				int[] temp = ns;
				ns = ms;
				ms = temp;
				int tmp = N;
				N = M;
				M = tmp;
			}
			
			//3. 최댓값 구하기
			int max = Integer.MIN_VALUE;
			int check = 0;
			for(int i=0; i<M-N+1; i++) {
				for (int j=0; j<N; j++) {
					check += ms[i+j] * ns[j];
				}
				if (check > max) {
					max = check;
				}
				check = 0;
			}
			
			//4. 출력
			System.out.printf("#%d %d\n", TC+1, max);
		}
	}
}