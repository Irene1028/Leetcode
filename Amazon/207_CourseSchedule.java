class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] edges = new int[numCourses][numCourses];
        int[] comingEdges = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (edges[pre][cur] == 0) {
                comingEdges[cur]++;
            }
            edges[pre][cur] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (comingEdges[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (edges[course][i] == 1) {
                    comingEdges[i]--;
                    if (comingEdges[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}

// Time O(n^2)
// Space O(n^2)
