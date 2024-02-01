class Solution {
    public int search(int[] nums, int target) {

        int k = 0;

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                k = i+1;
                break;
            }
        }

        ArrayList<Integer> fixedNums = new ArrayList<Integer>();

        for(int i = k; i < nums.length; i++){
            fixedNums.add(Integer.valueOf(nums[i]));
        }

        for(int i = 0; i < k; i++){
            fixedNums.add(Integer.valueOf(nums[i]));
        }

        int result = Collections.binarySearch(fixedNums, target);

        if(result >= 0){
            result = (result + k) % fixedNums.size();
        } else {
            result = -1;
        }

        return result;
        
    }
}