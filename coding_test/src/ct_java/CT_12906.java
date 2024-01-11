package ct_java;
import java.util.*;
import java.util.stream.IntStream;

public class CT_12906 
{
	int temp = -1;
	
	public int[] solution(int []arr) 
	{
		IntStream stream = Arrays.stream( arr );
		return stream.filter(i -> !isInARow( i ) ).toArray();
    }
	
	private boolean isInARow(int i)
	{
		boolean b = (temp == i);
		temp = i;
		return b;
	}
}