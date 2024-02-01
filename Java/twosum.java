class Solution {
    public int[] twoSum(int[] nums, int target) {

        if(nums.length == 2){
            return new int[]{0, 1}; 
        }

        HashMap<Integer, Integer> potentialNums = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){
            if(potentialNums.containsKey(target - nums[i])){
                return new int[]{potentialNums.get(target - nums[i]), i};  
            } else {
                potentialNums.put(nums[i], i);
            }
        }

        return new int[]{-1, -1}; 
    }

    
}