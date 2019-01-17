class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        len1 = len(nums1)
        len2 = len(nums2)
        if (len1 + len2) % 2 == 1:
            return self.findK(nums1, 0, len1, nums2, 0, len2, (len1 + len2) / 2 + 1)
        else:
            return self.findK(nums1, 0, len1, nums2, 0, len2, (len1 + len2) / 2) * 0.5 + \
                   self.findK(nums1, 0, len1, nums2, 0, len2, (len1 + len2) / 2 + 1) * 0.5
        
    def findK(self, nums1, start1, len1, nums2, start2, len2, k):
        if len1 == 0:
            return nums2[start2 + k - 1]
        if len2 == 0:
            return nums1[start1 + k - 1]
        
        if k == 1:
            return min(nums1[start1], nums2[start2])
        
        if len1 < k / 2:
            if nums1[start1 + len1 - 1] < nums2[start2 + k / 2 - 1]:
                return nums2[start2 + k - 1 - len1]
            else:
                return self.findK(nums1, start1, len1, nums2, start2 + k / 2, len2 - k / 2, k - k / 2)
        
        if len2 < k / 2:
            if nums2[start2 + len2 - 1] < nums1[start1 + k / 2 - 1]:
                return nums1[start1 + k - 1 - len2]
            else:
                return self.findK(nums1, start1 + k / 2, len1 - k / 2, nums2, start2, len2, k - k / 2)
            
        if nums1[start1 + k / 2 - 1] < nums2[start2 + k / 2 - 1]:
            return self.findK(nums1, start1 + k / 2, len1 - k / 2, nums2, start2, len2, k - k / 2)
        else:
            return self.findK(nums1, start1, len1, nums2, start2 + k / 2, len2 - k / 2, k - k / 2)
