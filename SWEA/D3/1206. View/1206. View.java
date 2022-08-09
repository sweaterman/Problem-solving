import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = 0;
		int sum = 0;
		List<Integer> building = new ArrayList<>();
		
		for (int i=0; i<10; i++) { //10개의 테스트 케이스가 주어진다.
			n = sc.nextInt();
			for (int j=0; j<n; j++) { //입력받기
				building.add(sc.nextInt());
			}
			for (int k=2; k<n-2; k++) { //조망권 몇 세대 인지 세기
				if ( (building.get(k) > building.get(k-2)) && (building.get(k) > building.get(k-1)) 
						&& (building.get(k) > building.get(k+1)) && (building.get(k) > building.get(k+2)) ){
					//조망권이 2칸이상 확보가 된다면
					sum += building.get(k)-Math.max(Math.max(building.get(k-2), building.get(k-1)), Math.max(building.get(k+1), building.get(k+2)));
				}
			}
			System.out.printf("#%d %d\n", i+1, sum);
			sum = 0;
			building.clear();
        }
	}
}
