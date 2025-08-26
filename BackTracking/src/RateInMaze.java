
public class RateInMaze {

	static public Choice[] choices= {new Choice('R',0, 1), new Choice('L', 0, -1), new Choice('U', -1, 0), new Choice('D', 1, 0)};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] M= {{1, 1, 0},
					{0, 1, 1},
					{0, 1, 1}};
		int n=3;
		int m=3;
		if(M[0][0]!=0)
			solve(M, 0, 0, n, m, new StringBuilder());
	}
	
	static void solve(int[][] M, int x, int y, int n, int m, StringBuilder path)
	{
		if(x==n-1 && y==m-1)
		{
			System.out.println("path: "+path.toString());
			return;
		}
		
		for(Choice choice: choices)
		{
			int x1=x+choice.dx;
			int y1=y+choice.dy;
			if(isValid(x1, y1, M, n, m))
			{
				path.append(choice.dir);
				M[x][y]=0;
				solve(M, x1, y1, n, m, path);
				M[x][y]=1;
				path.deleteCharAt(path.length()-1);
			}
		}
		
	}
	
	static boolean isValid(int x, int y, int[][] M, int n, int m)
	{
		if(x<n && x>=0 && y<m && y>=0 && M[x][y]!=0)
			return true;
		return false;
	}
}

class Choice
{
	char dir;
	int dx;
	int dy;
	
	public Choice(char dir, int dx, int dy)
	{
		this.dir=dir;
		this.dx=dx;
		this.dy=dy;
	}
}
