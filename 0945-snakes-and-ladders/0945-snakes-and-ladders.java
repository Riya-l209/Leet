class Solution {
    public int snakesAndLadders(int[][] board) {
       int n=board.length;
       int N=n*n;
       boolean[] visited=new boolean[N+1];
       Queue<Integer> queue=new LinkedList<>();
       queue.offer(1);
       visited[1]=true;
       int moves=0;
       while(!queue.isEmpty()) {
        int size=queue.size();
        moves++;
        for(int i=0;i<size;i++){
            int curr=queue.poll();
            for(int dice=1;dice<=6;dice++){
                int next=curr+dice;
                if(next>N) continue;
                int[] pos=getRC(next,n);
                int r=pos[0],c=pos[1];
                if(board[r][c]!=-1){
                    next=board[r][c];
                }
                if(next==N) return moves;
                if(!visited[next]){
                    visited[next]=true;
                    queue.offer(next);
                }
            }
        }
       }
 return -1;      
    }
    private int[] getRC(int num, int n){
        int quot=(num-1)/n;
        int rem=(num-1)%n;
        int row=n-1-quot;
        int col=(quot%2==0)?rem:(n-1-rem);
        return new int[]{row,col};
    }
}