import java.util.*;

class Solution {
    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        int m = reqSkills.length;

        // Map each required skill to a bit position
        Map<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            skillMap.put(reqSkills[i], i);
        }

        int fullMask = (1 << m) - 1;

        // Convert each person's skills into a bitmask
        int[] personMask = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int mask = 0;
            for (String skill : people.get(i)) {
                if (skillMap.containsKey(skill)) {
                    mask |= (1 << skillMap.get(skill));
                }
            }
            personMask[i] = mask;
        }

        // dp[mask] = smallest team that covers 'mask'
        List<Integer>[] dp = new ArrayList[1 << m];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < people.size(); i++) {
            List<Integer>[] temp = dp.clone();

            for (int mask = 0; mask <= fullMask; mask++) {
                if (dp[mask] == null) continue;

                int newMask = mask | personMask[i];

                if (temp[newMask] == null ||
                        temp[newMask].size() > dp[mask].size() + 1) {

                    temp[newMask] = new ArrayList<>(dp[mask]);
                    temp[newMask].add(i);
                }
            }

            dp = temp;
        }

        List<Integer> ans = dp[fullMask];
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
