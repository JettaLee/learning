package nowcoder.Codes;

import java.util.*;

/**
 * Created by jetta on 2017/8/1.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) return ans;
        HashMap<String, ArrayList<String>> list = new HashMap<>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String newStr = String.valueOf(strArr);
            if (list.containsKey(newStr)) {
                list.get(newStr).add(str);
            } else {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                list.put(newStr, strings);
            }
        }
        for (String s : list.keySet()) {
            ans.add(list.get(s));
        }
        return ans;
    }
}
