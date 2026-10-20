class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]});
            events.add(new int[]{b[1], b[2]});
        }

        events.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> active = new HashMap<>();
        active.put(0, 1);

        int previousHeight = 0;

        for (int[] event : events) {
            int height = Math.abs(event[1]);

            if (event[1] < 0) {
                pq.offer(height);
                active.put(height,
                    active.getOrDefault(height, 0) + 1);
            } else {
                active.put(height, active.get(height) - 1);
            }

            while (!pq.isEmpty() &&
                   active.getOrDefault(pq.peek(), 0) == 0) {
                pq.poll();
            }

            int currentHeight = pq.peek();

            if (currentHeight != previousHeight) {
                result.add(Arrays.asList(
                    event[0], currentHeight
                ));
                previousHeight = currentHeight;
            }
        }

        return result;
    }
}