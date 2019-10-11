/**
 * @auther ikaruga
 * 下午2:51 - 2019/9/27
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            return (
                    findKthNumber((totalLength + 1) / 2, nums1, 0, nums2, 0)
                            + findKthNumber((totalLength + 2) / 2, nums1, 0, nums2, 0)
            ) / 2;
        } else {
            return findKthNumber((totalLength + 1) / 2, nums1, 0, nums2, 0);
        }
    }


    public double findKthNumber(int k, int[] nums1, int aIdx, int[] nums2, int bIdx) {
        if (aIdx >= nums1.length) {
            return nums2[bIdx + k - 1];
        }
        if (bIdx >= nums2.length) {
            return nums1[aIdx + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[aIdx], nums2[bIdx]);
        }
        int mid = k / 2;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(aIdx + mid <= nums1.length){
            left = nums1[aIdx + mid - 1];
        }
        if(bIdx + mid <= nums2.length){
            right = nums2[bIdx + mid - 1];
        }
        if (left < right) {
            return findKthNumber(k - mid, nums1, aIdx + mid, nums2, bIdx);
        } else {
            return findKthNumber(k - mid, nums1, aIdx, nums2, bIdx + mid);
        }
    }

}
