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
			
			//2. 명령 입력하기, 명령 처리
			int NN = sc.nextInt();
			for (int i=0; i<NN; i++) {
				String ctrl = sc.next();
				int x = 0;
				int y = 0;
				switch(ctrl) {
				case "I":
					x = sc.nextInt();
					y = sc.nextInt();
					for (int j=0; j<y; j++) {
						origin.add(x+j, sc.nextInt());
					}
					break;
				case "D":
					x = sc.nextInt();
					y = sc.nextInt();
					for (int j=0; j<y; j++) {
						origin.remove(x);
					}
					break;
				case "A":
					y = sc.nextInt();
					for (int j=0; j<y; j++) {
						origin.add(sc.nextInt());
					}
					break;
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