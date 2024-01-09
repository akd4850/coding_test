package ct_lv1_java_64061;
import java.util.*;

public class MainClass 
{
	public static void main(String[] args) 
	{
		/*int[][] board = {
					{0,0,0,0,0},
					{0,0,1,0,3},
					{0,2,5,0,1},
					{4,2,4,4,2},
					{3,5,1,3,1}
				};*/
		int[][] board = {
				{1, 0, 0, 0, 0},
				{2, 0, 0, 0, 0},
				{2, 0, 0, 0, 0},
				{1, 0, 0, 0, 0},
				{3, 0, 0, 0, 0}
			};
		//int[] moves = {1,5,3,5,1,2,1,4};
		int[] moves = {1, 1, 1, 1};
		System.out.println(solution(board, moves));
	}
	
	public static int solution(int[][] board, int[] moves) 
	{
		List<Integer> pickList = new ArrayList<>();
		
		for(int i = 0; i < moves.length; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				if( board[ j ][ moves[ i ] - 1 ] > 0 )
				{
					pickList.add( board[ j ][ moves[ i ] - 1 ] );
					board[ j ][ moves[ i ] - 1 ] = 0;
					break;
				}
			}
		}

		int bombCount = 0;
		
		return GetUntilNotDistinct(pickList, bombCount);
    }
	
	public static int GetUntilNotDistinct(List<Integer> pickList, int bombCount)
	{
		int index = 0;
		
		if(pickList.size() == 0) return bombCount;
		
		for(Integer i : pickList)
		{
			if(index == pickList.size() - 1) return bombCount;
			
			if(i == pickList.get( index + 1) )
			{
				pickList.remove( index + 1);
				pickList.remove( index );
				bombCount += 2;
				
				return GetUntilNotDistinct( pickList, bombCount );
			}
			
			index++;
		}
		
		return 0;
	}
}