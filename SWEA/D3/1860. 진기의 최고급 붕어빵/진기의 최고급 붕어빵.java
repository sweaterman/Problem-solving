import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int TC = 1; TC <= tc; TC++) {
			// 1. 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] people = new int[N];
			for (int i = 0; i < N; i++) {
				people[i] = sc.nextInt();
			}
			Arrays.sort(people);
			// 2. 계산
			int sec = 0;
			int bread = 0;
			boolean check = true;
			int i = 0;
			
			while(i<N) { //M초씩 증가시키면서 돈다
				while(true) {
					if (i<N && people[i] < sec+M ) {
						if (bread == 0) {
							check = false;
							break;
						}
						else {
							bread--;
							i++;
						}
					}
					else {
						break;
					}
				}
				if (!check) {
					break;
				}
				sec += M;
				bread += K;
			}
			
			if(check) {
				System.out.printf("#%d Possible\n", TC);
			}
			else {
				System.out.printf("#%d Impossible\n", TC);
			}
		}
	}
}