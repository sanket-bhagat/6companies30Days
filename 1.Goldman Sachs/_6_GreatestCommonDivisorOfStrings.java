package goldman_sachs;

public class _6_GreatestCommonDivisorOfStrings {
	
	public static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        if(str1.equals(str2)) return str1;
        if(str1.length()>str2.length()) return gcdOfStrings(str1.substring(str2.length()),str2);
        return gcdOfStrings(str1,str2.substring(str1.length()));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ABABAB";
		String s2 = "ABAB";
		System.out.println(gcdOfStrings(s1,s2));
	}

}
