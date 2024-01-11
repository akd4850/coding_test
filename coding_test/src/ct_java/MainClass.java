package ct_java;
import java.util.*;

public class MainClass 
{
	public static void main(String[] args) 
	{
		CT_12906 test = new CT_12906();
		int[] arr = test.solution( new int[] { 4,4,4,3,3 } );
		for(int i : arr) System.out.println( i );
	}
}