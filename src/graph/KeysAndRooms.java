package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
    Set<Integer> s = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(rooms, 0);
        return s.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int i) {
        s.add(i);
        List<Integer> keys = rooms.get(i);
        for(int key : keys) {
            if(!s.contains(key))
                dfs(rooms, key);
        }

    }
}
