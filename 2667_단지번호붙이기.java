import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main{
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1][N+1];
		String[] s = new String[N+1];
		
		for(int i=0; i<N; i++) {
			s[i] = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = s[i].charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int total = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					int count = dfs(i,j,0);
					list.add(count);
					total ++;
				}
			}
		}
		
		System.out.println(total);
		Collections.sort(list);
		for(int data:list) {
			System.out.println(data);
		}
		
	}
	
	public static int dfs(int x, int y, int count) {
		
		count++;
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int x2 = x + dx[i];
			int y2 = y + dy[i];
			
			if(x2<0 || x2>=N || y2<0 || y2>=N) continue;
			
			if(map[x2][y2] == 1 && !visit[x2][y2]) {
				count = dfs(x2,y2,count);
			}
		}
		
		return count;
	}
}
