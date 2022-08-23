import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc=1; tc<=TC; tc++) {
			int N = sc.nextInt();
			int move = 0;
			int speed = 0;
			for (int i=0; i<N; i++) {
				int c = sc.nextInt();
				switch(c) {
				case 0:
					move += speed;
					break;
				case 1:
					speed += sc.nextInt();
					move += speed;
					break;
				case 2:
					speed -= sc.nextInt();
					if (speed<0) {
						speed = 0;
					}
					move += speed;
					break;
				}
			}
			System.out.printf("#%d %d\n", tc, move);
		}
	}
}