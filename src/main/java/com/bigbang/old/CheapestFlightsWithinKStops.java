package com.bigbang.old;
/*
 * @ Description
 * @ Author Bangpeng Gao
 * @ Version 1.0.0
 * @ Since 1.0.0
 * @ Date 2019/8/9
 */

import java.util.*;

public class CheapestFlightsWithinKStops {
    /**
     * 787. Cheapest Flights Within K Stops
     * Medium
     * <p>
     * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
     * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
     * Example 1:
     * Input:
     * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
     * src = 0, dst = 2, k = 1
     * Output: 200
     * Explanation:
     * The graph looks like this:
     * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
     * Example 2:
     * Input:
     * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
     * src = 0, dst = 2, k = 0
     * Output: 500
     * Explanation:
     * The graph looks like this:
     * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
     * Note:
     * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
     * The size of flights will be in range [0, n * (n - 1) / 2].
     * The format of each flight will be (src, dst, price).
     * The price of each flight will be in the range [1, 10000].
     * k is in the range of [0, n - 1].
     * There will not be any duplicated flights or self cycles.
     */
    public int solution1(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[]{0, src, k + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[]{price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }

    public int solution2(int n, int[][] flights, int src, int dst, int K) {
        int[][] srcToDst = new int[n][n];
        for (int i = 0; i < flights.length; i++)
            srcToDst[flights[i][0]][flights[i][1]] = flights[i][2];

        PriorityQueue<City> minHeap = new PriorityQueue();
        minHeap.offer(new City(src, 0, 0));

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        int[] stop = new int[n];
        Arrays.fill(stop, Integer.MAX_VALUE);
        stop[src] = 0;

        while (!minHeap.isEmpty()) {
            City curCity = minHeap.poll();
            if (curCity.id == dst) return curCity.costFromSrc;
            if (curCity.stopFromSrc == K + 1) continue;
            int[] nexts = srcToDst[curCity.id];
            for (int i = 0; i < n; i++) {
                if (nexts[i] != 0) {
                    int newCost = curCity.costFromSrc + nexts[i];
                    int newStop = curCity.stopFromSrc + 1;
                    if (newCost < cost[i]) {
                        minHeap.offer(new City(i, newCost, newStop));
                        cost[i] = newCost;
                    } else if (newStop < stop[i]) {
                        minHeap.offer(new City(i, newCost, newStop));
                        stop[i] = newStop;
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    private class City implements Comparable<City> {
        int id;
        int costFromSrc;
        int stopFromSrc;

        public City(int id, int costFromSrc, int stopFromSrc) {
            this.id = id;
            this.costFromSrc = costFromSrc;
            this.stopFromSrc = stopFromSrc;
        }

        public boolean equals(City c) {
            if (c instanceof City)
                return this.id == c.id;
            return false;
        }

        public int compareTo(City c) {
            return this.costFromSrc - c.costFromSrc;
        }
    }
}
