package ct_lv1_java_161990;

public class MainClass 
{
	/*
	 * 
class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i=0; i< wallpaper.length;i++ ){
            for(int j=0; j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minX = Math.min(minX,i);
                    minY = Math.min(minY,j);
                    maxX = Math.max(maxX,i);
                    maxY = Math.max(maxY,j);
                }
            }
        }
        return new int[]{minX,minY,maxX+1,maxY+1};
    }
}

	 */
	// 뭐 이리 어렵게 생각함 ㅡㅡ
	public static void main(String[] args) 
	{
		solution(new String[]{
				".##...##.", 
				"#..#.#..#", 
				"#...#...#", 
				".#.....#.", 
				"..#...#..", 
				"...#.#...", 
				"....#...."});
	}
	
	public static int[] solution(String[] wallpaper) 
	{
		int[] r = new Wallpager( wallpaper )
				.GetMinX()
				.GetMinY()
				.GetMaxX()
				.GetMaxY()
				.GetResult();
		
		for(int i = 0; i < r.length; i++)
			System.out.println(r[ i ]);
		
		return r;
    }
	
	private static class Wallpager
	{
		private String[] board;
		
		private int minX;
		private int minY;
		private int maxX;
		private int maxY;
		
		public Wallpager(String[] wallpaper) { board = wallpaper; } 
		
		public Wallpager GetMinX()
		{
			for(int i = 0; i < board.length; i++)
			{
				for(int j = 0; j < board[ i ].length(); j++)
				{
					if( board[ i ].charAt( j ) == '#' )
					{
						minX = i;
						return this;
					}
				}
			}
			
			return this;
		}
		
		public Wallpager GetMinY()
		{
			for(int j = 0; j < board[ 0 ].length(); j++)
			{
				for(int i = 0; i < board.length; i++)
				{
					if( board[ i ].charAt( j ) == '#' )
					{
						minY = j;
						return this;
					}
				}
			}
			
			return this;
		}
		
		public Wallpager GetMaxX()
		{
			for(int i = board.length - 1; i >= 0 ; i--)
			{
				for(int j = 0; j < board[ i ].length(); j++)
				{
					if( board[ i ].charAt( j ) == '#' )
					{
						maxX = i + 1;
						return this;
					}
				}
			}
			
			return this;
		}
		
		public Wallpager GetMaxY()
		{
			for(int j = board[ 0 ].length() - 1; j >= 0; j--)
			{
				for(int i = 0; i < board.length; i++)
				{
					if( board[ i ].charAt( j ) == '#' )
					{
						maxY = j + 1;
						return this;
					}
				}
			}
			return this;
		}
		
		public int[] GetResult() { return new int[] {minX, minY, maxX, maxY}; }
	}
}