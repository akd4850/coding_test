package ct_lv1_java_150370;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClass 
{
	public static void main(String[] args)
	{
		String[] terms = new String[] {"A 6", "B 12", "C 3"};
		String[] privacies = new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		solution("2022.05.19", terms, privacies);
	}
	
	public static int[] solution(String today, String[] terms, String[] privacies) 
	{
		Map<String, Integer> termsMap = new HashMap<String, Integer>();
		List<Integer> resultList = new ArrayList<>();
		Calendar todayCal = Calendar.getInstance();
		
		for(int i = 0; i < terms.length; i++)
		{
			String[] termsAry = terms[ i ].split(" ");
			termsMap.put( termsAry[ 0 ], Integer.parseInt( termsAry[ 1 ] ) );
		}
		
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat( "yyyy.MM.dd" );
			Date todayDate = formatter.parse( today );
			todayCal.setTime( todayDate );
		} catch(ParseException e) {}
		
		for(int i = 0; i < privacies.length; i++)
		{
			String[] priAry = privacies[ i ].split(" ");
			
			try
			{
				SimpleDateFormat formatter = new SimpleDateFormat( "yyyy.MM.dd" );
				Date priDate = formatter.parse( priAry[ 0 ] );
				
				Calendar cal = Calendar.getInstance();
				cal.setTime( priDate );
				cal.add(Calendar.MONTH, termsMap.get( priAry[ 1 ] ) );
				
				if( !cal.after( todayCal ) ) resultList.add( i + 1 );
			} catch(ParseException e) {}
		}
		
		return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}