class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long maxcontribution = 0;
        long mincontribution = 0;

        int[] right = new int[n];
        int[] left = new int[n];
        int[] mright = new int[n];
        int[] mleft = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int l = i - left[i];
            int r = right[i] - i;
            mincontribution += (long) nums[i] * l * r;
        }

        stack.clear();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            mleft[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            mright[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int l = i - mleft[i];
            int r = mright[i] - i;
            maxcontribution += (long) nums[i] * l * r;
        }

        return maxcontribution - mincontribution;
    }
}
