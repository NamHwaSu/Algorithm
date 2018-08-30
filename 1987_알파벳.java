import java.util.Scanner;

//1987_알파벳

class Main{
	
	static int R; //세로
	static int C; //가로
	static int[][] board;
	static int[] check;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int max = 0;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		board = new int[R+1][C+1];
		check = new int['Z'-'A'+1];
		
		for(int i=0; i<R; i++) {
			String s = sc.next();
			for(int j=0; j<s.length(); j++) {
				board[i][j] = s.charAt(j) -'A';
			}
		} //char형을 int형으로 변환하여 board에 저장
		
		check[board[0][0]] = 1;
		dfs(0,0,1);
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int count) {
		
		if(max<count) max = count;
		
		for(int i=0; i<4; i++) {
			int x2 = x+dx[i];
			int y2 = y+dy[i];
			
			if(x2<0 || x2>=R || y2<0 || y2>=C) continue;
			int alph = board[x2][y2];
			if(check[alph] == 0) {
				check[alph] = 1;
				dfs(x2,y2,count+1);
				check[alph] = 0; //초기화
			}
		}
	}
}
