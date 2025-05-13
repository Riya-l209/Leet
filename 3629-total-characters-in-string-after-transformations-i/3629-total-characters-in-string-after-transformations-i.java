class Solution {
    public int lengthAfterTransformations(String s, int t) {
    final int MOD= 1_000_000_007;
    int[] count= new int[26];
    for(char c:s.toCharArray()){
        count[c - 'a']++;
    }
    while(t-- > 0){
        int[] next=new int[26];
        for(int i=0;i<25;i++){
            next[i+1]=count[i];
        }
        next[0]=(next[0]+count[25])%MOD;
        next[1]=(next[1]+count[25])%MOD;
        count=next;
    }
    int result=0;
    for(int val:count){
        result=(result+val)%MOD;
    }
    return result;
    }
    }
