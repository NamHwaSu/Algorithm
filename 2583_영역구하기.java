import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//2583_영역구하기_dfs

class Main{
	
	static int M,N,K;
	static int[][] map;
	static boolean[][] visit;
	static int[]dx = {1,-1,0,0};
	static int[]dy = {0,0,1,-1};
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[M+1][N+1];
		visit = new boolean[M+1][N+1];
		
		for(int i=0; i<K; i++) {
			int a,b,c,d;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			
			for(int x=a; x<c; x++) {
				for(int y=b; y<d; y++) {
					map[y][x] = 1;
				}
			}
		} //input
		
		ArrayList<Integer> List = new ArrayList<Integer>();
		
		int total_count = 0;
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0 && !visit[i][j]) {
					int a = dfs(i,j,0);
					List.add(a);
					total_count++;
				}
			}
		}
		
		Collections.sort(List);
		System.out.println(total_count);
		
		for(int data:List) {
			System.out.print(data+" ");
		}
			
		/*
		 * 입력받은 그래프 출력
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.print("\n");
		}*/
	}
	
	public static int dfs(int x,int y,int count) {
		
		visit[x][y] = true;
		count++;
		
		for(int i=0; i<4; i++) {
			int x2 = x+dx[i];
			int y2 = y+dy[i];
			
			if(x2<0 || x2>=M || y2<0 || y2>=N) continue;
			if(map[x2][y2]==0 && !visit[x2][y2]) {
				count = dfs(x2,y2,count);
			}
		}
		return count;
	}	
}
