class Solution {
    public double mincostToHireWorkers(
            int[] quality, int[] wage, int k) {

        int n = quality.length;
        double[][] workers = new double[n][2];

        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }

        Arrays.sort(workers,
            (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        int qualitySum = 0;
        double answer = Double.MAX_VALUE;

        for (double[] worker : workers) {
            int q = (int) worker[1];

            pq.offer(q);
            qualitySum += q;

            if (pq.size() > k) {
                qualitySum -= pq.poll();
            }

            if (pq.size() == k) {
                answer = Math.min(
                    answer, qualitySum * worker[0]
                );
            }
        }

        return answer;
    }
}