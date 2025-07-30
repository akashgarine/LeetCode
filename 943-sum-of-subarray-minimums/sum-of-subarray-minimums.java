class Solution {
    public int sumSubarrayMins(int[] arr) {
       int nse []=new int[arr.length];
       int pse []=new int[arr.length];
       Arrays.fill(nse,arr.length);
       Arrays.fill(pse,-1);
       findNse(nse,arr);
       findPse(pse,arr);
         long mod =(long) 1000000007;
       long res=0;
       for(int i=0;i<arr.length;i++){
        int left=i-pse[i];
        int right=nse[i]-i;
        long prod = ((long)arr[i] * left) % mod;
        prod = (prod * right) % mod;
    res = (res + prod) % mod;

       }
    return (int)res;
    }
    public static void findNse(int nse[],int arr[]){
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
                stack.pop();
            if(!stack.isEmpty())
                nse[i]=stack.peek();
            stack.push(i);
        }
    }
    public static void findPse(int pse[],int arr[]){
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
          while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
          } 
          if(!stack.isEmpty())
            pse[i]=stack.peek();
          stack.push(i); 
        }
    }
}