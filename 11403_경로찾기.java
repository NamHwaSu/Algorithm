import java.util.Arrays;
import java.util.Scanner;

//11403_경로찾기_dfs

class Main{
	
	static int N; //정점의 갯수
	static int map[][]; //입력받을 그래프
	static int visit[];
	static int new_map[][]; //출력할 그래프
	
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		visit = new int[N+1];
		new_map = new int[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		} //input
		
		for(int i=0; i<N; i++) {
			dfs(i);
			for(int j=0; j<N; j++) {
				new_map[i][j] = visit[j];
			}
			Arrays.fill(visit, 0); //visit 배열 초기화
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(new_map[i][j]+" ");
			}
			System.out.print("\n");
		} //output	
	}
	
	public static void dfs(int v) {
		
		for(int i=0; i<N; i++) {
			if(map[v][i]==1 && visit[i]==0) {
				visit[i]=1;
				dfs(i);
			}
		}
	}
}
