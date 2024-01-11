package ct_lv1_java_120846;
import java.util.*;

public class MainClass 
{
	public static void main(String[] args)
	{
		System.out.println(solution(100));
	}
	
	public static int solution(int n) 
	{
		List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= n; i++)
        {
            int l = n / i;
            for(int j = 2; j <= l; j++) if( !list.contains( (Integer)(i * j) ) ) list.add( (Integer)(i * j) ); 
        }
        
        return list.size();
    }
}