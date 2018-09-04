import java.util.ArrayList;
import java.util.Scanner;

//15686_치킨배달_dfs
class Main{
	static int N;
	static int M;
	static int[][] map;
	static ArrayList<pair> store;
	static ArrayList<pair> person;
	static ArrayList<pair> ans;
	static int minn = Integer.MAX_VALUE;
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][N+1];
		store = new ArrayList<pair>();
		person = new ArrayList<pair>();
		ans = new ArrayList<pair>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==2) {
					store.add(new pair(i,j));
				}if(map[i][j]==1) {
					person.add(new pair(i,j));
				}
			}
		}
		
		for(int i=0; i<store.size(); i++) {
			ans.add(store.get(i));
			dfs(i,1);
		}
		
		System.out.println(minn);
	}
	
	public static void dfs(int start,int cnt) {
	
		if(cnt == M) {
			int a = calc(ans);
			minn = minn>a?a:minn;
		}
		
		for(int i=start+1; i<store.size(); i++) {
			ans.add(store.get(i));
			dfs(i,cnt+1);
		}
		ans.remove(ans.size()-1);
		cnt--;
	}
	
	public static int calc(ArrayList<pair> ar) {
		
		int total=0;
		
		for(int i=0; i<person.size(); i++) {
			
			int min = Integer.MAX_VALUE;
			
			int x = person.get(i).x;
			int y = person.get(i).y;
			//System.out.println("person"+ x+" "+y);
			for(int j=0; j<ar.size(); j++) {
				int x2 = ar.get(j).x;
				int y2 = ar.get(j).y;
				//System.out.println("ans"+x2+" "+y2);
				int aa = Math.abs(x-x2)+Math.abs(y-y2);
				min = min>aa?aa:min; 
			}
			total = total+min;
		}
		return total;
	}
}

class pair{
	int x;
	int y;
	
	pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}
