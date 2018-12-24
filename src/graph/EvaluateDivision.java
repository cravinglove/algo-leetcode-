package graph;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, ArrayList<String>> pairs = new HashMap<>();
        Map<String, ArrayList<Double>> valuePairs = new HashMap<>();
        // 建图
        for(int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            String x = equation[0];
            String y = equation[1];
            if(!pairs.containsKey(x)) {
                pairs.put(x, new ArrayList<>());
                valuePairs.put(x, new ArrayList<>());
            }
            if(!pairs.containsKey(y)) {
                pairs.put(y, new ArrayList<>());
                valuePairs.put(y, new ArrayList<>());
            }

            pairs.get(x).add(y);
            valuePairs.get(x).add(values[i]);

            pairs.get(y).add(x);
            valuePairs.get(y).add(1 / values[i]);
        }

        double[] result = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuePairs, new HashSet<String>(), 1.0);
            if(result[i] == 0.0) result[i] = -1.0;
        }
        return result;
    }

    private double dfs(String start, String end, Map<String, ArrayList<String>> pairs, Map<String, ArrayList<Double>> valuePairs, Set<String> set, double value) {
        if(set.contains(start)) return 0.0;
        if(!pairs.containsKey(start)) return 0.0;
        if(start.equals(end)) return value;

        set.add(start);
        ArrayList<String> pairList = pairs.get(start);
        ArrayList<Double> valueList = valuePairs.get(start);
        double tmp = 0.0;
        for(int i = 0; i < pairList.size(); i++) {
            tmp = dfs(pairList.get(i), end, pairs, valuePairs, set, value * valueList.get(i));
            if(tmp != 0.0) break;
        }
        set.remove(start);
        return tmp;
    }
}
