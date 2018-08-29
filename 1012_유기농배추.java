import java.util.Scanner;

class Main{
	
	//1012 - 유기농 배추
	
	static int T; //TEST CASE 갯수
	static int M; //배추밭 가로 길이
	static int N; //세로 길이
	static int K; //배추가 심어져 있는 위치의 갯수
	static int map[][];
	static boolean visit[][];
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String arsg[]) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[M+1][N+1];
			visit = new boolean[M+1][N+1];
			
			for(int j=0; j<K; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			int count = 0;
			
			for(int a=0; a<M; a++) {
				for(int b=0; b<N; b++) {
					if(map[a][b] == 1 && !visit[a][b]) {
						dfs(a,b);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void dfs(int x, int y) {
		
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int x2 = x+dx[i];
			int y2 = y+dy[i];
			
			if(x2>=M || x2<0 || y2>=N || y2<0) continue;
			if(map[x2][y2]==1 && !visit[x2][y2]) {
				dfs(x2,y2);
			}
		}
	}
}

