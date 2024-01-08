package ct_lv1_java_72410;

import java.util.*;

public class MainClass 
{
	// 분명 정규식 활용하는 코테인 것을 알았음에도 참 좆같이 짯네 ㅡㅡ 반성해라 새뀌야
	public static void main(String[] args) 
	{
		String result = Solution("z-+.^.");
		System.out.println( result + " : " + result.length() );
	}
	
	public static String Solution(String new_id) {

        String s = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();


        return s;
    }

    private static class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }

	// What the fucking code 반성
	/*public static String Solution(String new_id) 
	{
		new_id = new_id.toLowerCase();
		
		for(char c : new_id.toCharArray())
			if( CheckWrongChar( c ) ) new_id = new_id.replace( String.valueOf( c ), "" );
		
		for(Integer i : FindIndexes('.', new_id) ) 
			if( i - 1 >= 0 && new_id.charAt( i - 1 ) == '.' ) new_id = new_id.substring(0, i) + new_id.substring(i + 1);
		
		if( new_id.charAt(0) == '.' ) new_id = new_id.substring(1);
		if( new_id.length() > 0 && new_id.charAt( new_id.length() - 1 ) == '.' ) new_id = new_id.substring(0, new_id.length() - 1);
		
		if( new_id.equals("") ) new_id = "a";
		
		if( new_id.length() >= 16 )
		{
			new_id = new_id.substring(0, 15);
			if( new_id.charAt( new_id.length() - 1 ) == '.' ) new_id = new_id.substring(0, new_id.length() - 1);
		}
		
		if( new_id.length() <= 2 )
			while( new_id.length() != 3 ) new_id += new_id.charAt( new_id.length() - 1 );
		
        return new_id;
    }
	
	public static boolean CheckWrongChar(char c)
	{
		int asc = (int)c;
		if( (asc >= (int)'a' && asc <= (int)'z') || (asc >= (int)'0' && asc <= (int)'9') ||
			asc == (int)'-' || asc == (int)'_' || asc == (int)'.')
			return false;
		
		return true;
	}
	
	public static List<Integer> FindIndexes(char c, String document)
	{
		List<Integer> indexList = new ArrayList<Integer>();
		int index = document.lastIndexOf( c );
		
		while( index != -1 )
		{
			indexList.add( index );
			index = document.lastIndexOf(c, index - 1);
		}
		
		return indexList;
	}*/
}