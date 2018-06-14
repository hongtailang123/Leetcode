class Solution {
    public int[] twoSum(int[] nums, int target){
	int[] res = new int[]{-1, -1};
	if (nums == null || nums.length < 2){
	    return res;
	}
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	int length = nums.length;
	for (int i = 0; i < length; i++){
	    if (map.containsKey(target - nums[i])){
		res[0] = map.get(target - nums[i]);
		res[1] = i;
		return res;
	    }
	    map.put(nums[i], i);
	}
	return res;
    }
}

