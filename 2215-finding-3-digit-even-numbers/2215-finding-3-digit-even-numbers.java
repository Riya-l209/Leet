class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] digitCount= new int[10];
        for(int d:digits) digitCount[d]++;
        List<Integer> result=new ArrayList<>();
        for(int num=100;num<1000;num+=2){
            int a=num/100,b=(num/10)%10,c=num%10;
            int[] curCount=new int[10];
            curCount[a]++;
            curCount[b]++;
            curCount[c]++;
            boolean canBuild=true;
            for(int i=0;i<10;i++){
                if(curCount[i]>digitCount[i]){
                    canBuild=false;
                    break;
                }
            }
            if(canBuild) result.add(num);
        }
        int[] ans=new int[result.size()];
        for(int i=0;i<result.size();i++)
        ans[i]=result.get(i);
        return ans;
    }
}