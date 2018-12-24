package sort;

public class H_index {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int length = citations.length;
        int[] aux = new int[length + 1];

        for(int i = 0; i < length; i++) {
            if(citations[i] >= length) aux[length]++;
            else aux[citations[i]]++;
        }

        int t = 0;
        for(int i = length; i >= 0; i--) {
            t += aux[i];
            if(t >= i) return i;
        }
        return 0;
    }
}
