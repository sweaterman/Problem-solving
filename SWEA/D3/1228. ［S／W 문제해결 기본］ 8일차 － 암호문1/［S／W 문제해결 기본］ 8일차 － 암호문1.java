import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for (int tc=0; tc<10; tc++) {
			// 1. 원본 입력받기 (LinkedList에 저장)
			int N = sc.nextInt();
			List<Integer> origin = new LinkedList<>();
			for (int i=0; i<N; i++) {
				origin.add(sc.nextInt());
			}
			
			//2. 삽입 입력받기, 삽입하기
			int NN = sc.nextInt();
			for (int i=0; i<NN; i++) {
				sc.next(); // I 처리
				int x = sc.nextInt();
				int y = sc.nextInt();
				for (int j=0; j<y; j++) {
					origin.add(x+j, sc.nextInt());
				}
			}
			
			//3. 출력
			System.out.printf("#%d ", tc+1);
			for (int i=0; i<10; i++) {
				System.out.printf("%d ", origin.get(i));
			}
			System.out.println();
		}
		sc.close();
	}
}