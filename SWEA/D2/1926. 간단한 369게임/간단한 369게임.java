import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=1; i<=N; i++) {
			String check = Integer.toString(i);
			int count = 0;
			for(int j=0; j<check.length(); j++) {
				if (check.charAt(j) == '3' || check.charAt(j) == '6' || check.charAt(j) == '9') {
					count++;
				}
			}
			
			if (count == 0) {
				System.out.printf("%s ", check);
			}
			else {
				for(int k=0; k<count; k++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
		}
	}
}