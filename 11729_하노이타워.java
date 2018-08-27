import java.util.Scanner;

class Main{
	
	static int count = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		hanoi_tower(N,1,2,3);
		System.out.println(count);
		System.out.println(sb.toString());
		
	}
	
	public static void hanoi_tower(int n, int from, int tmp, int to) {
		
		count++;
		
		if(n==1) {
			sb.append(from+" "+to+"\n");
			//System.out.println(from + " " + to);
		}else {
			hanoi_tower(n-1, from, to, tmp);
			//from의 맨 밑의 원판을 제외한 나머지 원판을 tmp로 옮긴다.
			sb.append(from+" "+to+"\n");
			//System.out.println(from+" "+to);
			//from에 있는 한 개의 원판을 to로 옮긴다.
			hanoi_tower(n-1, tmp, from, to);
			//tmp의 원판들을 to로 옮긴다.
		}
	}
}
