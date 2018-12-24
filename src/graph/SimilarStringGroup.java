package graph;

public class SimilarStringGroup {
    public int numSimilarGroups(String[] A) {
        UF uf = new UF(A.length);
        for(int i = 0; i < A.length - 1; i++) {
            for(int j = i + 1; j < A.length; j++) {
                if(similar(A[i], A[j])) uf.union(i, j);
            }
        }
        return uf.count();
    }

    private boolean similar(String s1, String s2) {
        int count = 0;
        // 如果有两个字符不同则相似
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)!= s2.charAt(i) && ++count > 2) return false;
        }
        return true;
    }

    private class UF {
        private int[] parents;
        private int[] size;
        private int count;

        public UF(int n) {
            parents = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
            count = n;
        }

        public int count() {return count;}

        public boolean connected(int p, int q) {return find(p) == find(q);}

        public int find(int id) {
            while(id != parents[id])
                id = parents[id];
            return id;
        }

        public void union(int i, int j) {
            int iid = find(i);
            int jid = find(j);
            if(iid == jid) return;

            if(size[iid] > size[jid]) {
                size[iid] += size[jid];
                parents[jid] = iid;
            } else {
                size[jid] += size[iid];
                parents[iid] = jid;
            }
            count--;
        }
    }
}
