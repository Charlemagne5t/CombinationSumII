import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        
        dfs(candidates, target, res, 0, new ArrayList<>(), 0);
        

        return res;

    }

    void dfs(int[] candidates, int target, List<List<Integer>> res, int i, List<Integer> curList, int curSum) {

        if (i == candidates.length) {
            return;
        }
        if (curSum + candidates[i] > target) {
            return;
        }
        if (curSum + candidates[i] == target) {
                curList.add(candidates[i]);
                res.add(new ArrayList<>(curList));
                curList.remove(curList.size() - 1);
            int k = i;
            while(k < candidates.length && candidates[i] == candidates[k]) {
                k++;
            }
            dfs(candidates, target, res, k, curList, curSum);
        }
        if (curSum + candidates[i] < target) {
            
                curList.add(candidates[i]);
                dfs(candidates, target, res, i + 1, curList, curSum + candidates[i]);
                curList.remove(curList.size() - 1);
                int k = i;
            while(k < candidates.length && candidates[i] == candidates[k]) {
                k++;
            }
            dfs(candidates, target, res, k, curList, curSum);
        }

    }
}