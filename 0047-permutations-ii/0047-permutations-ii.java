class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permutation(0, nums.length, nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    
    private static void permutation(int depth, int n, int[] nums, List<List<Integer>> result, List<Integer> selected, boolean[] vst) {
        if (depth == n) {
            result.add(new ArrayList<>(selected));
            return;
        }
        
        int prev = -11;
        
        for (int i = 0; i < n; i++) {
            if (!vst[i] && prev != nums[i]) {
                vst[i] = true;
                prev = nums[i];
                selected.add(nums[i]);
                permutation(depth + 1, n, nums, result, selected, vst);
                vst[i] = false;
                selected.remove(selected.size() - 1);
            }
        }
    }
}