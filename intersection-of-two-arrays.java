class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i< nums1.length;i++){
            set.add(nums1[i]);
        }
        List<Integer> ans = new LinkedList<Integer>();
        for(int i = 0;i <nums2.length;i++){
            if(set.contains(nums2[i])) {
                ans.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}