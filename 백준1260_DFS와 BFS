import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
	
	static int N; //정점의 갯수
	static int M; //간선의 갯수
	static int V; //정점 번호
	
	static int[][] map;
	static boolean[] check;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		map = new int[1001][1001];
		check = new boolean[1001];
		
		int a;
		int b;
		
		for(int i=0; i<M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			map[a][b] = map[b][a] = 1;
		}
		
		dfs(V);
		for(int i=1; i<=N; i++) {
			check[i] = false;
		}
		System.out.println("");
		
		bfs(V);
	}
	
	public static void dfs(int start) {
		
		check[start] = true;
		System.out.print(start+" ");
		
		for(int i=1; i<=N; i++) {
			if(map[start][i] == 1 && !check[i]) {
				dfs(i);
			}	
		}
	}
	
	public static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		check[start] = true;
		System.out.print(start+" ");
		
		int temp;
		
		while(!q.isEmpty()) {
			temp = q.poll();
	
			for(int i=1; i<=N; i++) {
				if(map[temp][i] == 1 && !check[i]) {
					q.offer(i);
					check[i] = true;
					System.out.print(i+" ");
				}	
			}
		}
	}
}
