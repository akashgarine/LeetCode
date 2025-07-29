class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int ans[]=new int[nums1.length];
        Stack<Integer> stack=new Stack<>();
        for(int temp:nums2)
            hm.put(temp,-1);
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
              stack.pop();  
            }
            if(!stack.isEmpty())
                hm.put(nums2[i],stack.peek());
            stack.push(nums2[i]);
        }
        int i=0;
        for(int num:nums1){
            ans[i++]=hm.get(num);
        }
        return ans;
    }
}