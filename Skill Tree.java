class Solution {
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;

        for (String tree : skill_trees) {
            StringBuilder sb = new StringBuilder();

            for (char c : tree.toCharArray()) {
                if (skill.indexOf(c) != -1) {
                    sb.append(c);
                }
            }

            if (skill.startsWith(sb.toString())) {
                ans++;
            }
        }
        return ans;
    }
}
