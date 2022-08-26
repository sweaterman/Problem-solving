import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			// 1. 입력 받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] flag = new char[N][M];
			for (int i=0; i<N; i++) {
				String a = sc.next();
				for (int j=0; j<M; j++) {
					flag[i][j] = a.charAt(j);				
				}
			}
			
			// 2. 계산
			List<Integer> c = new ArrayList<>();
			
			for(int W=1; W<N; W++) {
				for(int B=W+1; B<N; B++) {
					int ch = 0;
					//white
					for(int i=0; i<W; i++) {
						for(int j=0; j<M; j++) {
							if(flag[i][j] != 'W') {
								ch++;
							}
						}
					}
					
					//blue
					for(int i=W; i<B; i++) {
						for(int j=0; j<M; j++) {
							if(flag[i][j] != 'B') {
								ch++;
							}
						}
					}
					
					//Red
					for(int i=B; i<N; i++) {
						for(int j=0; j<M; j++) {
							if(flag[i][j] != 'R') {
								ch++;
							}
						}
					}
					c.add(ch);
				}				
			}//검사 끝
			
			//5. 출력
			Collections.sort(c);
			System.out.printf("#%d %d\n", tc, c.get(0));
		}//테스트 케이스 끝
	}
}