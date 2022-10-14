import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N, result;
	static List<Integer> tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int TC=1; TC<=tc; TC++) {
			//1. 입력받기
			N = sc.nextInt();
			tree = new ArrayList<>();
			for(int i=0; i<N; i++) {
				tree.add(sc.nextInt());
			}
			
			Collections.sort(tree);

			result = 0;
			boolean even = false;
			if (tree.get(N-1) % 2 == 0) {
				even = true;
			}
			
			//2. 계산 시작
			int max_value = tree.get(N-1);
			tree.remove(N-1);
			while(true) {
				Collections.sort(tree);
				//1. 종료 조건
				int check_idx = tree.size()-1;
				while(true) {
					if (tree.size() == 0) {
						break;
					}
					if(tree.get(check_idx) == max_value) {
						tree.remove(check_idx);
						check_idx--;
					}
					else {
						break;
					}
				}
				if(tree.size() == 0) {
					break;
				}
				
				result++;
				//2. 한 개 남았을 때
				if (tree.size() == 1) {
					if (max_value - tree.get(0) == 1) {
						if (result % 2 == 1) {
							tree.set(0, tree.get(0)+1);
						}
					}
					else if (max_value - tree.get(0) == 2) {
						if (result % 2 == 0) {
							tree.set(0, tree.get(0)+2);
						}
					}
					else {
						tree.set(0, tree.get(0) + (result%2==0 ? 2:1));
					}
					continue;
				}
				
				//3. 물을 준다.
				if (even) { //짝수이면?
					if(result % 2 == 0) { //날도 짝수일 때
						boolean c = true;
						for (int i=tree.size()-1; i>=0; i--) {
							if(tree.get(i) % 2 == 0) {
								tree.set(i, tree.get(i)+2); //물 주기
								c = false;
								break;
							}
						}
						if (c) { //물을 못줬어 ㅠ 다 홀수다.
							if (tree.get(0)+2 <= max_value) {
								tree.set(0, tree.get(0)+2);
							}
						}
					}
					else {//날이 홀수일 때
						boolean c = true;
						for (int i=tree.size()-1; i>=0; i--) {
							if (tree.get(i) % 2 == 1) { //홀수인애한테 1을 줘
								tree.set(i, tree.get(i)+1);
								c = false;
								break;
							}
						}
						if (c) {
							tree.set(0, tree.get(0)+1); //그냥 제일 작은 애 한테 1 줘.
						}
					}
				}
				
				else { //홀수이면?
					if(result % 2 == 0) { //날이 짝수일 때
						boolean c = true;
						for (int i=tree.size()-1; i>=0; i--) {
							if(tree.get(i) % 2 == 1) { //제일 큰 홀수애한테
								tree.set(i, tree.get(i)+2); //물 주기
								c = false;
								break;
							}
						}
						if (c) { //물을 못줬어 ㅠ 다 짝수다.
							if (tree.get(0)+2 <= max_value) {
								tree.set(0, tree.get(0)+2);
							}
						}
					}
					else {//날이 홀수일 때
						boolean c = true;
						for (int i=tree.size()-1; i>=0; i--) {
							if(tree.get(i) % 2 == 0) { //제일 큰 짝수애한테
								tree.set(i, tree.get(i)+1); //물 주기
								c = false;
								break;
							}
						}
						if(c) {
							tree.set(0, tree.get(0)+1); //그냥 제일 작은 애 한테 1 줘.
						}
					}
				}
			}//계산 끝

			System.out.printf("#%d %d\n", TC, result);
			
		}//테케 끝
	}
}
