// 3- pointer O(n^3)*nlogn
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        if (!res.contains(triplet))  // Avoid duplicates
                            res.add(triplet);
                    }
                }
            }
        }
        return res;
    }
}
//-----------------------------------------------------------------
// 2 pointers+hashing -O(n^2)*nLogn;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set=new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int t=-(nums[i]+nums[j]);
                if(set.contains(t)){
                    List<Integer> ans=Arrays.asList(t,nums[i],nums[j]);
                    Collections.sort(ans);
                    if(!res.contains(ans))
                        res.add(ans);
                    }
                set.add(nums[j]);
            }
        }
        return res;
    }
}
//----------------------------------------------------------------------
