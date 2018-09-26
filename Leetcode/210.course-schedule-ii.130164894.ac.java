class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        //build graph
        for(int i=0;i<prerequisites.length;i++){
            int pre = prerequisites[i][1];
            int after = prerequisites[i][0];
            if(graph[pre][after]==0){
                indegree[after]++;
            }
            graph[pre][after] = 1;
        }
        int count=0;
        Queue<Integer> queue = new LinkedList<>();
        //find root
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        //bfs
        while(!queue.isEmpty()){
            int current = queue.poll();
            res[count]=current;
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
        
        return count==numCourses? res: new int[0];
    }
}
