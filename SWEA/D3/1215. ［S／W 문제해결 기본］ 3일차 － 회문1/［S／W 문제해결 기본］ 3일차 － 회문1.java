import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			// 1. 입력받기
			int n = sc.nextInt();
			char[][] words = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String tmp = sc.next();
				words[i] = tmp.toCharArray();
			}
			
			// 2. 탐색.
			int sum =0;
			for (int i=0; i<8; i++) {
				for (int j=0; j<8; j++) {
					int row=1, col=1;
					//가로 검사
					if(j+n-1<8) {
						for(int k=0; k<n/2; k++) {
							if(words[i][j+k] != words[i][j+n-k-1]) {
								row=0;
								break;
							}
						}
					}
					else {
						row=0;
					}
					//세로 검사
					if(i+n-1<8) {
						for(int k=0; k<n/2; k++) {
							if(words[i+k][j] != words[i+n-k-1][j]) {
								col=0;
								break;
							}
						}
					}
					else {
						col=0;
					}					
					sum += col+row;
				}
			}
			
			//3. 출력
			System.out.printf("#%d %d\n", tc+1, sum);
		}
	}
}