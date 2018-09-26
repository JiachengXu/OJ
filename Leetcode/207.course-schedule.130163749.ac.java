class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if((prerequisites==null
           ||prerequisites.length==0
           ||prerequisites[0]==null
           ||prerequisites[0].length==0)&&numCourses==0){
            return false;
        }
        //build graph
        int[][] graph = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int pre = prerequisites[i][1];
            int after = prerequisites[i][0];
            if(graph[pre][after]==0){
                indegree[after]++;
            }
            graph[pre][after]=1;
        }
        
        //find the root
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            count++;
            for(int i=0;i<numCourses;i++){
                if(graph[current][i]!=0){
                    indegree[i]--;
                    if(indegree[i]==0){
                        queue.add(i);
                    }
                }
            }
        }
        return count==numCourses;
    }
}
