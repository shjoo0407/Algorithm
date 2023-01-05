import java.io.*;
import java.util.*;

public class matrixChain {
	static int N;
	static int r, c;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 6; //편의상 6으로 두었습니다.
		map = new int[N][2];
		dp = new int[N][N];
		StringTokenizer st;
		

		st = new StringTokenizer(br.readLine(), "x"); //x로 숫자를 구분.
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());

			
		map[0][0] = a;
		map[0][1] = b;
		map[1][0] = b;
		map[1][1] = c;
		map[2][0] = c;
		map[2][1] = d;
		map[3][0] = d;
		map[3][1] = e;
		map[4][0] = e;
		map[4][1] = f;
		map[5][0] = f;
		map[5][1] = g;
		

			
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					dp[i][j] = 0;
				else if(i<j)
					dp[i][j] = Integer.MAX_VALUE;
				else if(i>j)
					dp[i][j]=0; //0으로 처리했습니다.
			}
		}
		for (int j = 1; j < N; j++) {
			for (int i = 0; i + j < N; i++) {
				calcul(i, i + j);
			}
		}
		for (int i = 0; i < dp.length; i++) {

		    for (int j = 0; j < dp[i].length; j++) {

		        System.out.print(dp[i][j] + " ");

		    }

		    System.out.println();

		}
		
		System.out.print("최소 곱셈 횟수 :");
		System.out.println(dp[0][N - 1]);
		
	}

	private static void calcul(int start, int end) {
		for (int i = start; i < end; i++) {
			int cost = dp[start][i] + dp[i + 1][end] + map[start][0] * map[i][1] * map[end][1];
			dp[start][end] = Math.min(dp[start][end], cost);
		}

	}
	
	
}
