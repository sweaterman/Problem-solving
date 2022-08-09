import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int check = 0;
		int max = 0;
		int count = 0;

		for (int tc=0; tc<n; tc++) {
			int[] student = new int[101];
			check = sc.nextInt();
			for (int i=0; i<1000; i++) {
				int score = sc.nextInt();
				student[score] += 1;
			}
			for (int i=0; i<student.length; i++) {
				if (student[i] >= count) {
					max = i;
					count = student[i];
				}
			}
			System.out.printf("#%d %d\n", check, max);
			max = 0;
			count = 0;
		}
	}
}
