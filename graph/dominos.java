
/*
Dominos are lots of fun. Children like to stand the tiles on their side in long lines. When one domino falls, it knocks down the next one, which knocks down the one after that, all the way down the line.
However, sometimes a domino fails to knock the next one down. In that case, we have to knock it down by hand to get the dominos falling again.
Your task is to determine, given the layout of some domino tiles, the minimum number of dominos that must be knocked down by hand in order for all of the dominos to fall.
Input Format:
The first line of input contains one integer T, specifying the number of test cases to follow.
Each test case begins with a line containing two integers
The first integer n is the number of domino tiles and the second integer m is the number of lines to follow in the test case.
The domino tiles are numbered from 1 to n.
Each of the following lines contains two integers x and y indicating that if domino number x falls, it will cause domino number y to fall as well.
Constraints:
1 <= T <= 50
1 <= N, M <= 10^5
Output Format:
For each test case, output a line containing one integer, the minimum number of dominos that must be knocked over by hand in order for all the dominos to fall.
Sample Input 1:
1
3 2
1 2
2 3
Sample Output 2:
1
*/



import java.util.*;
class Graph{
    int v;
    List<List<Integer>> adjList;
    
    Graph(int v){
        this.v = v ;
        this.adjList = new ArrayList();
        for(int i =0;i<=v;i++){
            adjList.add(i,new ArrayList());
        }
        
    }
    
}

public class Main {

	
	public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int k =0;k<t;k++){
        int n = scn.nextInt();
        int m = scn.nextInt();
        Graph graph = new Graph(n);
        Graph newgraph = new Graph(n);
        List<List<Integer>> adjList= graph.adjList;
        for(int i =0;i<m;i++){
            int x = scn.nextInt();
            int y = scn.nextInt();
             adjList.get(x).add(y);
        }
       int count = 0;
        boolean visited[] = new boolean[n+1];
        Stack<Integer> stack = new Stack();
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                dfs(n,i,adjList,visited,stack);
            }
        }
        
          boolean newVisited[] = new boolean[n+1]; 
            while(!stack.isEmpty()){
                int no = stack.pop();
                if(!newVisited[no]){
                  
                     newdfs(n,no,adjList,newVisited);
                       count++;
                }
                
            }
         System.out.println(count);
        }
    
	}
    
    public static void dfs(int v,int source, List<List<Integer>> adjList
                           ,boolean visited[],Stack<Integer> stack){
        
        visited[source] = true;
            for(int num :adjList.get(source)){
                if(visited[num] == false)
                    dfs(v,num,adjList,visited,stack);
                
            }
        stack.push(source);
        
        
    }
    
        public static void newdfs(int v,int source, List<List<Integer>> adjList
                           ,boolean visited[]){
        
        visited[source] = true;
            for(int num :adjList.get(source)){
                if(visited[num] == false)
                    newdfs(v,num,adjList,visited);
             }
    }

}