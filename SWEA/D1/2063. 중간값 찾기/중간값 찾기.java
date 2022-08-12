import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		ArrayList numbers = new ArrayList();
		
		Scanner sc = new Scanner(System.in);
		int a;
		a = sc.nextInt();
        
        for (int i=0; i<a; i++){
            numbers.add(sc.nextInt());
        }
		
		Collections.sort(numbers);
	    System.out.println(numbers.get(a/2));
	}
}