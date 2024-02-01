class Solution {
    public int maxArea(int[] height) {

        int max = 0;
        int temp;

        int leftB = 0;
        int rightB = height.length-1;


        while(leftB != rightB){
            
            temp = calculateVolume(leftB, rightB, height);

            if(max < temp){
                max = temp;
            }

            if(height[leftB] < height[rightB]){
                leftB += 1;
            } else {
                rightB -= 1;
            }
        }
        
        return max;
    }

    public int calculateVolume(int first, int second, int[] arr){
        int height = arr[first] < arr[second] ? arr[first] : arr[second];

        return height * (second - first);
    }
}