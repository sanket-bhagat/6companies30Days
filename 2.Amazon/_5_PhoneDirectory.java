package amazon;

import java.util.*;

public class _5_PhoneDirectory {

	static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
// code here
		Arrays.sort(contact);
		Set<String> set = new HashSet<>();
		int len = s.length();
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		for (int i = 0; i < len; i++)
			ans.add(new ArrayList<>());
		for (String str : contact)
			if (str.length() > 0 && s.charAt(0) == str.charAt(0) && set.add(str))
				ans.get(0).add(str);
		for (int i = 1; i < len; i++) {
			for (String str : ans.get(i - 1))
				if (str.length() > i && s.charAt(i) == str.charAt(i))
					ans.get(i).add(str);
		}
		for (ArrayList<String> list : ans)
			if (list.size() == 0)
				list.add("0");
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		String contact[] = { "geeikistest", "geeksforgeeks", "geeksfortest" };
		String s = "geeips";
		ArrayList<ArrayList<String>> ans = displayContacts(n, contact, s);
		for(int i=0;i<s.length();i++) {
			for(String str: ans.get(i)) System.out.print(str+" ");
			System.out.println();
		}
	}

}
