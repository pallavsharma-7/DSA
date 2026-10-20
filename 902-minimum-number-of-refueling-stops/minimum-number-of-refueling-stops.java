class Solution {
    public int minRefuelStops(
            int target, int startFuel, int[][] stations) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        int fuel = startFuel;
        int stops = 0;
        int previous = 0;

        for (int i = 0; i <= stations.length; i++) {
            int position = (i == stations.length)
                ? target : stations[i][0];

            fuel -= position - previous;

            while (fuel < 0 && !pq.isEmpty()) {
                fuel += pq.poll();
                stops++;
            }

            if (fuel < 0) return -1;

            if (i < stations.length) {
                pq.offer(stations[i][1]);
            }

            previous = position;
        }

        return stops;
    }
}