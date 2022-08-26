import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
	static String[] tree;
	static int[] lpc;
	static int[] rpc;
	static int result;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			result = 0;
			// 1. 입력
			int n = sc.nextInt();
			tree = new String[n + 1];
			lpc = new int[n + 1];
			rpc = new int[n + 1];
			sc.nextLine();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(sc.nextLine());
				int node = Integer.parseInt(st.nextToken());
				tree[node] = st.nextToken();
				if (st.hasMoreTokens()) {
					lpc[Integer.parseInt(st.nextToken())] = node;
					rpc[Integer.parseInt(st.nextToken())] = node;
				}
			}
			// 2. 계산
			System.out.printf("#%d %d\n", tc, inorder(1));
		} // 테스트 케이스 끝
	}

	static int inorder(int r) {
		// 자식이 있는지 검사
		int L = -1; // 왼자식의 인덱스
		int R = -1; // 오자식의 인덱스
		for (int i = 0; i < lpc.length; i++) {
			if (lpc[i] == r) {
				L = i;
			}
			if (rpc[i] == r) {
				R = i;
			}
		}

		// 자식이 없을 때
		if (L == -1) {
			return Integer.parseInt(tree[r]);
		}

		switch (tree[r]) {
		case "+":
			return inorder(L) + inorder(R);
		case "-":
			return inorder(L) - inorder(R);
		case "*":
			return inorder(L) * inorder(R);
		case "/":
			return inorder(L) / inorder(R);
		}
		return 0;
	}
}