package graph;

public class CouplesHoldingHands {
    public static int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] pos = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            pos[row[i]] = i;
        }

        for(int i = 0; i < n - 1 ; i += 2) {
            int j = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
            if(row[i + 1] != j) {
                swap(row, pos, i + 1, pos[j]);
                res++;
            }
        }
        return res;
    }

    private static void swap(int[] row, int[] pos, int i, int j) {
        int temp = row[i];
        row[j] = row[i];
        pos[row[j]] = i;
        row[i] =temp;
        pos[row[i]] = j;
    }

    public static void main(String[] args) {
        int[] r = {3,2,0,1, 4};
        System.out.println(minSwapsCouples(r));
    }
}
