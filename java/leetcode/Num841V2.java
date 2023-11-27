package leetcode;

import java.util.List;

public class Num841V2 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        int startVertex = 0;

        dfs(visited,rooms,startVertex);

        return isAllVisited(visited);
    }

    private void dfs(boolean[] visited, List<List<Integer>> rooms, int curVertex) {
        visited[curVertex] = true;
        for (int key : rooms.get(curVertex)) {
            if (visited[key] == false){
                dfs(visited,rooms,key);
            }
        }
    }

    private boolean isAllVisited(boolean[] visited) {
        for (boolean v: visited) {
            if (!v) return false;
        }
        return true;
    }
}
