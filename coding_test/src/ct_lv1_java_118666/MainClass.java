package ct_lv1_java_118666;
import java.util.*;

public class MainClass 
{
	public static void main(String[] args) 
	{
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		solution(survey, choices);
	}
	
	public static String solution(String[] survey, int[] choices) 
	{
		String[] mbtis = new String[] { "RT", "CF", "JM", "AN" };
		Map<String, Integer> mbtiMap = new HashMap<String, Integer>();
		for(int i = 0; i < mbtis.length; i++)
		{
			mbtiMap.put( Character.toString( mbtis[ i ].charAt( 0 ) ), 0);
			mbtiMap.put( Character.toString( mbtis[ i ].charAt( 1 ) ), 0);
		}
		
		for(int i = 0; i < survey.length; i++)
		{
			// 4(모르겠음)을 기준으로 계산
			if( choices[ i ] != 4)
			{
				String scoreString = Character.toString( ( choices[ i ] < 4 ) ? survey[ i ].charAt(0) : survey[ i ].charAt(1) );
				int curScore = mbtiMap.get( scoreString );
				mbtiMap.put( scoreString, curScore + GetScore( choices[ i ] ) );
			}
		}
		
		// 최종 성향 계산
		String yourMbti = "";
		for(int i = 0; i < mbtis.length; i++)
		{
			int score1 = mbtiMap.get( Character.toString( mbtis[ i ].charAt( 0 ) ) );
			int score2 = mbtiMap.get( Character.toString( mbtis[ i ].charAt( 1 ) ) );
			yourMbti += ( score1 >= score2 ) ? Character.toString( mbtis[ i ].charAt( 0 ) ) : Character.toString( mbtis[ i ].charAt( 1 ) );
		}
        
        return yourMbti;
    }
	
	public static int GetScore(int choice)
	{
		if( choice == 1 || choice == 7 ) return 3;
		else if( choice == 2 || choice == 6 ) return 2;
		else if( choice == 3 || choice == 5 ) return 1;
		return 0;
	}
}