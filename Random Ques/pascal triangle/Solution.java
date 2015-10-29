public class Solution {
    public void getRow(int rowIndex) {
        ArrayList<Integer> result=new ArrayList<Integer>(rowIndex+1);
        for(int i=0;i<=rowIndex;++i){
            result.add(0);
        }
        result.set(0,1);
        for(int i=1;i<=rowIndex;++i){
            result.set(i,1);
            for(int j=i-1;j>0;--j){
                result.set(j,result.get(j)+result.get(j-1));
            }
        }
        return result;
    }
}