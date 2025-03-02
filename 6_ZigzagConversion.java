 class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 ||numRows >=s.length())
            return s;
      List<Character>[] rows=new ArrayList[numRows];
      int idx=0;
      int d=1;
      for(int i=0;i<numRows;i++){
        rows[i]=new ArrayList<>();
      }
      for(char c:s.toCharArray()){
        rows[idx].add(c);
        if(idx==0)
            d=1;
        if(idx==numRows-1)
            d=-1;
        idx+=d;
      }
      StringBuilder res=new StringBuilder();
      for(List<Character>temp:rows ){
        for(char c: temp)
            res.append(c);
      }
     return  res.toString();
    }
}
