class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {    
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        if ((length1 + length2) % 2 == 0){
            return findK(nums1, 0, length1, nums2, 0, length2, (length1 + length2) / 2) * 0.5 + findK(nums1, 0, length1, nums2, 0, length2, (length1 + length2) / 2 + 1) * 0.5;
        }
        else{
            return findK(nums1, 0, length1, nums2, 0, length2, (length1 + length2) / 2 + 1);
        }
    }
    
    private double findK(int[] nums1, int start1, int length1, int[] nums2, int start2, int length2, int k){
        if (length1 == 0){
            return nums2[k - 1];
        }
        if (length2 == 0){
            return nums1[k - 1];
        }
        
        if (k == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        if (length1 <= k / 2){
            if (nums1[start1 + length1 - 1] < nums2[start2 + k / 2 - 1]){
                return nums2[start2 + k - 1 - length1];
            } 
            else{
                return findK(nums1, start1, length1, nums2, start2 + k / 2, length2 - k / 2, k - k / 2);
            }
        }
        
        if (length2 <= k / 2){
            if (nums2[start2 + length2 - 1] < nums1[start1 + k / 2 - 1]){
                return nums1[start1 + k - 1 - length2];
            }
            else{
                return findK(nums1, start1 + k / 2, length1 - k / 2, nums2, start2, length2, k - k / 2);
            }
        }
        
        if (nums1[start1 + k / 2 - 1] < nums2[start2 + k / 2 - 1]){
            return findK(nums1, start1 + k / 2, length1 - k / 2, nums2, start2, length2, k - k / 2);
        }
        else{
            return findK(nums1, start1, length1, nums2, start2 + k / 2, length2 - k / 2, k - k / 2);
        }
    }
}
