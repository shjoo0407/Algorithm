import java.io.*;

public class KMP {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		KMP(s1,s2);
		
	}
	static int[] makeTable(String pattern) {
		int n = pattern.length();
		int[] table = new int[n];
		
		int idx = 0;
		for (int i =1; i<n; i++) {
			while(idx>0 && pattern.charAt(i)!= pattern.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if(pattern.charAt(i)== pattern.charAt(idx)) {
				idx += 1;
				table[i] = idx;
			}
		}
		return table;
	}
	static void KMP(String parent, String pattern) {
		int[] table = makeTable(pattern);
		
		int n1 = parent.length();
		int n2 = pattern.length();
			
		int idx = 0; // 현재 대응되는 글자 수
		for(int i=0; i< n1; i++) {
			// idx번 글자와 짚더미의 해당 글자가 불일치할 경우, 
			// 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다.
			while(idx>0 && parent.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx-1];
			}
			// 글자가 대응될 경우	
			if(parent.charAt(i) == pattern.charAt(idx)) {
				if(idx == n2-1) {
					System.out.println((i-idx+1)+"-"+(i+1)+"번째 입력 문자 : 매치");
					idx =table[idx];
				}else {
					idx += 1;
				}
			}
		}
	}
}
