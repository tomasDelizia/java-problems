package com.tomasdelizia.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = candidates.length;
        class DFS {
            DFS(int i, List<Integer> current, int sum) {
                // Base case
                if (sum == target) {
                    result.add(List.copyOf(current));
                    return;
                }
                // Base case: no combination found
                if (i >= n || sum > target) {
                    return;
                }
                // Recursive step with two decisions.
                // Decide whether to include the candidate in the current list or not.
                int value = candidates[i];
                current.add(value);
                new DFS(i, current, sum + value);
                // In the next decision we don't add the candidate and indicate that we can't include the element i.
                current.removeLast();
                new DFS(i + 1, current, sum);
            }
        }

        new DFS(0, new LinkedList<>(), 0);
        return result;
    }
}
