import java.util.*;

class Solution {
    private Map<String, List<String>> parents;
    private List<List<String>> result;
    private List<String> path;

    public List<List<String>> findLadders(
            String beginWord, String endWord,
            List<String> wordList) {

        result = new ArrayList<>();
        parents = new HashMap<>();

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        chars[j] = c;
                        String next = new String(chars);

                        if (!dict.contains(next)) continue;

                        // Record every parent in this BFS level.
                        if (!visited.contains(next)) {
                            parents.computeIfAbsent(
                                next, k -> new ArrayList<>()
                            ).add(word);

                            if (levelVisited.add(next)) {
                                queue.offer(next);
                            }

                            if (next.equals(endWord)) {
                                found = true;
                            }
                        } else if (levelVisited.contains(next)) {
                            // Another shortest parent in the same level.
                            parents.get(next).add(word);
                        }
                    }

                    chars[j] = original;
                }
            }

            visited.addAll(levelVisited);
        }

        if (found) {
            path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord);
        }

        return result;
    }

    private void dfs(String word, String beginWord) {
        if (word.equals(beginWord)) {
            List<String> sequence = new ArrayList<>(path);
            Collections.reverse(sequence);
            result.add(sequence);
            return;
        }

        for (String parent :
                parents.getOrDefault(word, Collections.emptyList())) {
            path.add(parent);
            dfs(parent, beginWord);
            path.remove(path.size() - 1);
        }
    }
}