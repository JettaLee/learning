package nowcoder.Codes;

import java.util.*;

/**
 * Created by jetta on 2017/8/1.
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        HashSet<String> hashSet = new HashSet<>(Arrays.asList("","..","."));
        Deque<String> deque = new LinkedList<>();
        for(String str: strs){
            if(str.equals("..")&&!deque.isEmpty())deque.pop();
            else if(!hashSet.contains(str))deque.push(str);
        }
        String ans = "";
        for(String str : deque){
            ans = "/"+str+ans;
        }
        return ans.isEmpty()?"/":ans;
    }


}
