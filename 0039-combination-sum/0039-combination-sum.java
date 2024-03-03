class Solution {
    private static List<List<Integer>> result;
    private static int[] candidates;
    private static int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        result = new ArrayList<>();
        combination(0, 0, new ArrayList<>());
        return result;
    }

    private static void combination(int index, int sum, List<Integer> selected) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(selected));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            selected.add(num);
            combination(i, sum + num, selected);
            selected.remove(selected.size() - 1);
        }
    }
}