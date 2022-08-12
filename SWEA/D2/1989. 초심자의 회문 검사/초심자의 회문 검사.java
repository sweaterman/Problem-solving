import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int TC=0; TC<tc; TC++) {
			int result = 1;
			String a = sc.next();
			for(int i=0; i<a.length()/2; i++) {
                if(a.charAt(i) != a.charAt(a.length()-i-1)) {
                    result  = 0;
                    break;
                }
			}
			System.out.printf("#%d %d\n", TC+1, result);
		}
	}
}