package _4_adobe;

public class _11_AmendTheSentence {
	
	public static String amendSentence(String s){
        //code here
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'a'){
                if(sb.length()>0) sb.append(' ');
                sb.append((char)('a'+s.charAt(i)-'A'));
            }else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "BruceWayneIsBatman";
		System.out.println(amendSentence(s));
	}

}
