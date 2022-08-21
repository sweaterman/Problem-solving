import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int count = 0;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc=0; tc<TC; tc++) {
			String origin = sc.next();
			check(origin);
			System.out.printf("#%d %d\n", tc+1, count);
			count = 0;
		}
		sc.close();
	}
    static void check(String x) {
		for (int i=0; i<x.length(); i++) {
			if (x.charAt(i) == '1') {
				count++;
				if(i == x.length()-1) {
					break;
				}
				String y = " ";
				for (int j=i+1; j<x.length(); j++) {
					if (x.charAt(j)=='1') {
						y+= '0';
					}
					else if (x.charAt(j)=='0') {
						y+= '1';
					}
				}
				check(y);
				break;
			}
		}		
	}
}