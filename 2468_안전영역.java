import java.util.Scanner;

//2468_안전영역_dfs

class Main{
	
	static int N;
	static int[][] map;
	static int[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int max_count = 1;
	static int max_in = 1;
	
	public static void main(String agrs[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				max_in = max_in<map[i][j] ? map[i][j]:max_in;
			}
		} //input
		
		for(int height=1; height<=max_in; height++) {
			int count = 0;
			visit = new int[N+1][N+1]; //높이마다 visit 초기화
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] > height && visit[i][j]==0) {
						dfs(i,j,height);
						count ++;
					}
				}
				max_count = max_count<count ? count:max_count;
			}	
		}
		
		System.out.println(max_count);
	}
	
	public static void dfs(int x, int y, int height) {
		
		visit[x][y] = 1 ;
		
		for(int i=0; i<4; i++) {
			int x2 = x+dx[i];
			int y2 = y+dy[i];
			
			if(x2<0 || x2>=N || y2<0 || y2>=N) continue;
			if(visit[x2][y2] == 0 && map[x2][y2]>height) {
				dfs(x2,y2,height);
			}
		}
	}
}
