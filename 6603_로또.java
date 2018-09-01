import java.util.Scanner;

//6603_로또
//k개의 숫자를 재귀를 통해 완전탐색 => 6개의 배열로 만들어 질 때 탈출조건으로 검사 =>출력
//백트래킹 => 방문 여부에 대한 visited같은 배열은 사실 상 필요 X.
//오름차순 되어있는 번호를 탐색할 때 마다 보다 큰 수를 탐색하기 때문이다.
                                       

class Main{
	
	static int k;
	static int[] lotto;
	static int[] ans;
	static int cnt;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		while((k=sc.nextInt())!=0) {
			lotto = new int[k+1];
			
			for(int i=0; i<k; i++) {
				lotto[i] = sc.nextInt();
			}
			
			for(int i=0; i<k; i++) {
				cnt = 1;
				dfs(i, lotto[i]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int v, String str) {
		if(cnt == 6) {
			sb.append(str + "\n");
		}
		for(int i = v+1; i<k; i++) {
			cnt ++;
			dfs(i, str + lotto[i]+" ");
			cnt--;
		}
	}
}
