import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
	
	static int N; //수빈이
	static int K; //동생
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		bfs();
		sc.close();
	}
	
	public static void bfs() {
		
		int[] road = new int[100005];
		
		Queue<Integer> q = new LinkedList<>();
		road[N] = 1;
		q.offer(N);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			if(temp == K) {
				System.out.println(road[temp]-1);
				return;
			}else {
				if((temp-1)>=0 && road[temp-1]==0) {
					road[temp-1] = road[temp]+1;
					q.offer(temp-1);
				}if((temp+1)<=100000 && road[temp+1]==0) {
					road[temp+1] = road[temp]+1;
					q.offer(temp+1);
				}if((temp*2)<=100000 && road[temp*2]==0) {
					road[temp*2] = road[temp]+1;
					q.offer(temp*2);
				}
			}
		}
	}
}
