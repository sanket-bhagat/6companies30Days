package _4_adobe;

public class _15_MostRecentVersion {
	
	public static String mostRecent(String a, String b) {
		for(int i=0;i<Math.min(a.length(), b.length());i++) {
			if(a.charAt(i)>b.charAt(i)) return a;
			else if(b.charAt(i)>a.charAt(i)) return b;
		}
		if(a.length()>b.length()) return a;
		return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "10.1.1.3";
		String b = "10.1.1.9";
		System.out.println(mostRecent(a,b));
	}

}
