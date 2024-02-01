class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int countOne = 0;
        int countTwo = 0;
        
        int mergedArray[] = new int[nums1.length + nums2.length];
        
        
        for(int i = 0; i < nums1.length + nums2.length ; i++) {
            
            if(countOne == nums1.length){
                mergedArray[i] = nums2[countTwo];
                countTwo++;
            } else if (countTwo == nums2.length) {
                mergedArray[i] = nums1[countOne];
                countOne++;
            } else if(nums1[countOne] < nums2[countTwo]){
                mergedArray[i] = nums1[countOne];
                countOne++;
            } else {
                mergedArray[i] = nums2[countTwo];
                countTwo++;
            }
        }
        
        /*
        int sum = 0;
        for(int i = 0; i < mergedArray.length; i++){
            sum += mergedArray[i];
        }
        return sum;
        */
        
         //even number of elements so median is middle 2
        if((nums1.length + nums2.length)%2 == 0) {
            return ((double)mergedArray[mergedArray.length/2]+(double)mergedArray[mergedArray.length/2-1])/2.0;
        } else { //odd
            return mergedArray[mergedArray.length/2];
        }
        
        
        
    }
}

// [1,2,x,x]
// count1 = 2
// count2 = 1