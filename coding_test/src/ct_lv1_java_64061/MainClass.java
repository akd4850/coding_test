package ct_lv1_java_64061;
import java.util.*;

public class MainClass 
{
	public static void main(String[] args) 
	{
		int[][] board = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));
	}
	
	public static int solution(int[][] board, int[] moves) 
	{
		List< Stack<Integer> > boardList = new ArrayList<>();
		Queue<Integer> queueList = new LinkedList<>();
		
		for(int i = 0; i < board.length; i++) boardList.add( new Stack<Integer>() );
		
		for(int i = board.length - 1; i >= 0; i--)
			for(int j = 0; j < board[ i ].length; j++)
				boardList.get( j ).push( board[ i ][ j ] );
				
		for(int i = 0; i < moves.length; i++)
		{
			while( boardList.get( moves[ i ] - 1 ).isEmpty() == false )
			{
				int r = boardList.get( moves[ i ] - 1 ).pop();
				if( r > 0 )
				{
					queueList.add( r );
					break;
				}
			}
		}
		
		// 중간에 터지고 나서 다시 만나는 경우가 있음 /////// ------------------ 내일 다시 계산해보자
		// 큐 방식 말고 다른 방식으로 처리해야 함!!!!!!!!!!!!!
		int bombCount = 0;
		int temp = 0;
		while( queueList.isEmpty() == false )
		{
			if( temp > 0 )
			{
				int r = queueList.poll();
				if(r == temp)
				{
					bombCount += 2;
					temp = 0;
				}
			}
			else temp = queueList.poll();
		}
		
		return bombCount;
    }
}