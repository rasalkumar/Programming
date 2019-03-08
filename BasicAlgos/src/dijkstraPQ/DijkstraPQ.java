package dijkstraPQ;
import java.util.*;
public class DijkstraPQ {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    static class Pair
    {
    	int x,y; //distance,vertex
    	Pair(int x,int y)
    	{
    		this.x = x;
    		this.y = y;
    	}
    }
    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge); //for undirected graph
        }

        public void dijkstra_GetMinDistances(int sourceVertex){

            boolean[] SPT = new boolean[vertices];
            //distance used to store the distance of vertex from a source
            int [] distance = new int[vertices];

            //Initialize all the distance to infinity
            for (int i = 0; i < vertices ; i++) {
                distance[i] = Integer.MAX_VALUE;
            }
            //Initialize priority queue
            //override the comparator to do the sorting based keys
            PriorityQueue<Pair> pq = new PriorityQueue<>(vertices, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    //sort using distance values
                    int key1 = p1.x;
                    int key2 = p2.x;
                    return key1-key2;
                }
            });
            //create the pair for for the first index, 0 distance 0 index
            distance[0] = 0;
            Pair p0 = new Pair(distance[0],0);
            //add it to pq
            pq.offer(p0);

            //while priority queue is not empty
            while(!pq.isEmpty()){
                //extract the min
                Pair extractedPair = pq.poll();

                //extracted vertex
                int extractedVertex = extractedPair.y;
                if(SPT[extractedVertex]==false) {
                    SPT[extractedVertex] = true;

                    //iterate through all the adjacent vertices and update the keys
                    LinkedList<Edge> list = adjacencylist[extractedVertex];
                    for (int i = 0; i < list.size(); i++) {
                        Edge edge = list.get(i);
                        int destination = edge.destination;
                        //only if edge destination is not present in mst
                        if (SPT[destination] == false) {
                            ///check if distance needs an update or not
                            //means check total weight from source to vertex_V is less than
                            //the current distance value, if yes then update the distance
                            int newKey =  distance[extractedVertex] + edge.weight ;
                            int currentKey = distance[destination];
                            if(currentKey>newKey){
                                Pair p = new Pair(newKey, destination);
                                pq.offer(p);
                                distance[destination] = newKey;
                            }
                        }
                    }
                }
            }
            //print Shortest Path Tree
            printDijkstra(distance, sourceVertex);
        }

        public void printDijkstra(int[] distance, int sourceVertex){
            System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
            for (int i = 0; i <vertices ; i++) {
                System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                        " distance: " + distance[i]);
            }
        }

        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
            graph.addEdge(0, 1, 4);
            graph.addEdge(0, 2, 3);
            graph.addEdge(1, 2, 1);
            graph.addEdge(1, 3, 2);
            graph.addEdge(2, 3, 4);
            graph.addEdge(3, 4, 2);
            graph.addEdge(4, 5, 6);
            graph.dijkstra_GetMinDistances(0);
        }
    }
}