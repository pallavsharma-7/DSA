class Solution {
    private int[] jobs;
    private int[] workloads;
    private int k;

    public int minimumTimeRequired(int[] jobs, int k) {
        this.jobs = jobs.clone();
        this.k = k;

        Arrays.sort(this.jobs);
        reverse(this.jobs);

        int low = this.jobs[0];
        int high = 0;

        for (int job : jobs) high += job;

        while (low < high) {
            int mid = low + (high - low) / 2;

            workloads = new int[k];

            if (canAssign(0, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canAssign(int index, int limit) {
        if (index == jobs.length) return true;

        int job = jobs[index];
        Set<Integer> triedLoads = new HashSet<>();

        for (int i = 0; i < k; i++) {
            if (workloads[i] + job > limit) continue;
            if (!triedLoads.add(workloads[i])) continue;

            workloads[i] += job;

            if (canAssign(index + 1, limit)) {
                return true;
            }

            workloads[i] -= job;

            if (workloads[i] == 0) break;
        }

        return false;
    }

    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
