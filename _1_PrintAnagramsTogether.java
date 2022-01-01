package goldman_sachs;
import java.util.*;

public class _1_PrintAnagramsTogether {
	
	public static  List<List<String>> Anagrams(String[] string_list) {
        // Code here
        int len = string_list.length;
        Map<String,Integer> map = new HashMap<>();
        int count = 0;
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<len;i++){
            char tempString[] = string_list[i].toCharArray();
            Arrays.sort(tempString);
            String anagram = new String(tempString);
            if(map.containsKey(anagram)){
                int idx = map.get(anagram);
                ans.get(idx).add(string_list[i]);
            }else{
                map.put(anagram,count);
                ans.add(new ArrayList<>());
                ans.get(count++).add(string_list[i]);
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		String words[] = {"act","god","cat","dog","tac"};
		List<List<String>> ans = Anagrams(words);
		for(int i=0;i<ans.size();i++) {
			for(String s: ans.get(i)) System.out.print(s+" ");
			System.out.println();
		}
	}

	
}
