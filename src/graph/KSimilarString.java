package graph;

import java.util.*;

public class KSimilarString {
    public static int kSimilarity(String A, String B) {
        if(A.equals(B)) return 0;
        Set<String> vis = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        vis.add(A);
        q.offer(A);
        int res = 0;

        while(!q.isEmpty()) {
            res++;
            for(int sz = q.size(); sz > 0; sz--) {
                String s = q.poll();
                int i = 0;
                while(s.charAt(i) == B.charAt(i)) i++;
                for(int j = i + 1; j < s.length(); j++) {
                    if(s.charAt(j) == B.charAt(j) || s.charAt(j) != B.charAt(i)) continue;
                    String snew = swap(s, i, j);
                    if(snew.equals(B)) return res;
                    if(vis.add(snew)) q.offer(snew);
                }
            }
        }
        return res;
    }
    public static String swap(String s, int i, int j) {
        char[] scharArr = s.toCharArray();
        char temp = scharArr[i];
        scharArr[i] = scharArr[j];
        scharArr[j] = temp;
        return new String(scharArr);
    }

    public static void main(String[] args) {
        String s1 = "aabc";
        String s2 = "abca";
        System.out.println(kSimilarity(s1, s2));
    }
}
