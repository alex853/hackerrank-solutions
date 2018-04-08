package hr.algorithms.graphtheory.bfsshortreach;

import java.util.*;

public class BFSShortReach {

    static int[] bfs(int n, int m, int[][] edges, int s) {
        int UNEXPLORED = -1;
        int EDGE_WEIGHT = 6;

        int[] distances = new int[n+1];
        Arrays.fill(distances, UNEXPLORED);
        distances[s] = 0;

        Map<Integer, List<Integer>> nodeEdges = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int[] edge = edges[i];

            int v = edge[0];
            int w = edge[1];

            List<Integer> eachNodes = nodeEdges.getOrDefault(v, new ArrayList<>());
            eachNodes.add(w);
            nodeEdges.put(v, eachNodes);

            eachNodes = nodeEdges.getOrDefault(w, new ArrayList<>());
            eachNodes.add(v);
            nodeEdges.put(w, eachNodes);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int nextDistance = distances[curr] + EDGE_WEIGHT;

            List<Integer> nodes = nodeEdges.getOrDefault(curr, new ArrayList<>());

            for (int each : nodes) {

                if (distances[each] == UNEXPLORED) {
                    distances[each] = nextDistance;
                    queue.add(each);
                }

            }

        }

        int[] result = new int[n-1];
        // n = 7, s = 4
        //   0  1  2  3  4  5  6  7
        // [-1, a, b, c, S, d, e, f]
        System.arraycopy(distances, 1, result, 0, s-1);
        System.arraycopy(distances, s+1, result, s-1, n-s);

        return result;
    }

}
