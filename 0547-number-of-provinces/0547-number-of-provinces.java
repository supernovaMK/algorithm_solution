class Solution {
    int [] parent;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    union(i,j);
                }
            }
        }
        int count =0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) count++;
        }
        return count;
    }

    public void union(int i,int j){
        int rootA = find(i);
        int rootB = find(j);

        if(rootA!=rootB)
            parent[rootB] = rootA;
    }

    public int find(int k){
        if(parent[k]==k){
            return parent[k];
        }

        parent[k]=find(parent[k]);
        return parent[k];
    }
}