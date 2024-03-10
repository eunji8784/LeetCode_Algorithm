class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(0, nums.length, result, nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    
    private static void permutation(int depth, int n, List<List<Integer>> result, int[] nums, List<Integer> selected, boolean[] vst) {
        if (depth == n) {
            result.add(new ArrayList<>(selected));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!vst[i]) {
                vst[i] = true;
                selected.add(nums[i]);
                permutation(depth + 1, n, result, nums, selected, vst);
                vst[i] = false;
                selected.remove(selected.size() - 1);
            }
        }
    }
}