package _6_walmart;
import java.util.*;

public class _1_PathWithMaximumProbability {
	
	static class Edge implements Comparable<Edge>{
        int vtx;
        double wt;
        Edge(int vtx, double wt){
            this.vtx = vtx;
            this.wt = wt;
        }
        public int compareTo(Edge e){
            double temp =  this.wt - e.wt;
            if(temp<0) return -1;
            if(temp>0) return 1;
            return 0;
        }
    }
    
    
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Edge(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new Edge(edges[i][0],succProb[i]));
        }
        double prob[] = new double[n];
        prob[start] = -1;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start,-1));
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            for(Edge e: adj.get(curr.vtx)){
                if(prob[curr.vtx]*e.wt<prob[e.vtx]){
                    prob[e.vtx] = prob[curr.vtx]*e.wt;
                    pq.offer(new Edge(e.vtx,prob[e.vtx]));
                }
            }
        }
        return -prob[end];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int edges[][] = {{0,1},{1,2},{0,2}};
		double succProb[] = {0.5,0.5,0.2};
		int start = 0, end = 2;
		System.out.println(maxProbability(n, edges, succProb, start, end));
	}

}
