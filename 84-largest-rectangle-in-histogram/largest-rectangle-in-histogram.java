class Solution {
    public int largestRectangleArea(int[] heights) {
        int nse[]=new int [heights.length];
        int pse[]=new int [heights.length]; 
        Arrays.fill(nse,heights.length);
        Arrays.fill(pse,-1);
        findNse(nse,heights);
        findPse(pse,heights);
        int res=0;
        for(int i=0;i<heights.length;i++){
           int temp= heights[i]*(nse[i]-pse[i]-1);
           res=Math.max(res,temp);
        }
    return res;
    }
    public static void findNse(int nse[],int heights[]){
        Stack<Integer> stack=new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty())
                nse[i]=stack.peek();
            stack.push(i);
        }
    }
    public static void findPse(int pse[], int heights[]){
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty())
                pse[i]=stack.peek();
            stack.push(i);
        }
    }   
}