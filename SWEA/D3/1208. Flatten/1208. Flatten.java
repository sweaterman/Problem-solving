import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			// 입력받기
			int dump = sc.nextInt();
			int[] box = new int[100];
			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}
			bubbleSort(box); // 정렬
			// dump 수행
			for (int i = 0; i < dump; i++) {
				box[99] -= 1;
				box[0] += 1;
				bubbleSort(box);
			}
			System.out.printf("#%d %d\n", tc + 1, box[99] - box[0]);
		}
		sc.close();
	}
    public static void bubbleSort(int[] box) {
		int tmp = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 99 - i; j++) {
				if (box[j] > box[j + 1]) {
					tmp = box[j + 1];
					box[j + 1] = box[j];
					box[j] = tmp;
				}
			}
		}
	}
}
