class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combination(0, 0, new ArrayList<>(), candidates, target, result);
        return result;
    }

    private static void combination(int index, int sum, List<Integer> selected, int[] candidates, int target, List<List<Integer>> result) {
        if (sum >= target) { 
            if (sum == target) {
                result.add(new ArrayList<>(selected));
            }
            return;
        }

        int prev = -1;

        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            if (prev != num) {
                prev = num;
                selected.add(num);
                combination(i + 1, sum + num, selected, candidates, target, result);
                selected.remove(selected.size() - 1);
            }
        }
    }
}