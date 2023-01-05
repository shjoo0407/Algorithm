import java.io.*;
import java.util.*;

public class Baekjoon_2217 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ropes_cnt = Integer.parseInt(st.nextToken());
		int ropes [] = new int[ropes_cnt];
		for (int i=0;i<ropes_cnt;i++) {
			st = new StringTokenizer(br.readLine());
			ropes[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ropes);
		
		
		long max = 0;
		for(int i = ropes_cnt-1; i>=0; i--) {
			ropes[i] = ropes[i] * (ropes_cnt-i);
			if(max < ropes[i]) {
				max = ropes[i];
			}
		}
		System.out.println(max);
	}

}
