package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Num841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        Map<Integer, List<Integer>> roomsToMap = roomsToMap(rooms);
        Queue<Integer> q = new LinkedList<>();

        visited[0] = true;
        q.offer(0);

        while (!q.isEmpty()) {
            Integer roomNumber = q.poll();
            if (isAllVisited(visited)) {  // 모두 방문했나? -> return true
                return true;
            }
            List<Integer> keys = roomsToMap.get(roomNumber);
            for (int key : keys) {        //방에 들어가 열쇠 꾸러미를 반복한다.
                if (!visited[key]) {          //not visited 이면
                    visited[key] = true;          //visited[i] =true 하고 하고 Queue에 넣는다.
                    q.offer(key);
                }
            }
        }
        return false;
    }

    private Map<Integer, List<Integer>> roomsToMap(List<List<Integer>> rooms) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < rooms.size(); i++) {
            result.put(i, rooms.get(i));
        }
        return result;
    }

    private boolean isAllVisited(boolean[] visited) {
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}
