class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        Set<String> resultSet = new TreeSet<>(); 
        queue.offer(expression);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.indexOf('{') == -1) {
                resultSet.add(curr);
                continue;
            }
            
            int right = curr.indexOf('}');
            int left = right;
            while (curr.charAt(left) != '{') {
                left--;
            }
            String before = curr.substring(0, left);
            String after = curr.substring(right + 1);
            String[] midParts = curr.substring(left + 1, right).split(",");
            
            for (String part : midParts) {
                queue.offer(before + part + after);
            }
        }
        return new ArrayList<>(resultSet);
    }
}