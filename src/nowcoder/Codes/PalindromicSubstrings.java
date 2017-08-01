package nowcoder.Codes;

/**
 * Created by jetta on 2017/8/1.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        char[] schar = s.toCharArray();
        int cnt = 0;
        for(int i =0;i<schar.length;i++){

            for(int start = i, end =i;start>=0&&end<schar.length;start--,end++){
                if(isExtend(schar,start,end)){
                    cnt++;
                }
                else break;
            }
            for(int start = i, end =i+1;start>=0&&end<schar.length;start--,end++){
                if(isExtend(schar,start,end)){
                    cnt++;
                }
                else break;
            }
        }
        return cnt;
    }
    private boolean isExtend(char[] s, int i, int j){
        return s[i]==s[j];
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new PalindromicSubstrings().countSubstrings(s));
    }
}
