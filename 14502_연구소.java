import java.util.Scanner;

//14502_연구소_dfs

class Main{
	
	static int N; //세로 크기
	static int M; //가로 크기
	static int[][] map;
	static int[][] copy_map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int max=0;
	static int result=0;
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][M+1];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		walls();
		System.out.println(max);
	}
	
	public static void walls() {
		
		for(int i=0; i<N*M; i++) {
			for(int j=i+1; j<N*M; j++) {
				for(int k=j+1; k<N*M; k++) {
					
					copy(); //매번 map을 초기화 해야 하므로 copy를 한 것을 이용.
					
					if(copy_map[i/M][i%M]==0 && copy_map[j/M][j%M]==0 &&
							copy_map[k/M][k%M]==0) {
						copy_map[i/M][i%M]=1;
						copy_map[j/M][j%M]=1;
						copy_map[k/M][k%M]=1;
						
						for(int x=0; x<N; x++) {
							for(int y=0; y<M; y++) {
								if(copy_map[x][y]==2) virus(x,y);
							}
						}//바이러스 전파
						
						result = find();
						max = max<result ? result:max;
					}
				}
			}
		}
	}
	
	public static void copy() {
		
		copy_map = new int[N+1][M+1];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy_map[i][j] = map[i][j];
			}
		}	
	}//map을 copy

	public static void virus(int x, int y) {
		
		for(int i=0; i<4; i++) {
			int x2 = x+dx[i];
			int y2 = y+dy[i];
			
			if(x2<0 || x2>=N || y2<0 || y2>=M) continue;
			if(copy_map[x2][y2]==0) { 
				copy_map[x2][y2]=2;
				virus(x2,y2);
			}
		}
	}//virus 전파
	
	public static int find() {
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copy_map[i][j]==0)
					cnt++;
			}
		}
		return cnt;
	}//안전영역 찾기
}                 
