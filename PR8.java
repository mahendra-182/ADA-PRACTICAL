import java.util.Arrays;

public class PR8 {
    
    static int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        
        int[][] edges = {
            {0, 1, 2}, {0, 3, 6}, {1, 2, 3},
            {1, 3, 8}, {1, 4, 5}, {2, 4, 7}, {3, 4, 9}
        };

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i; 
        }

        System.out.println("Edge \tWeight");
        int totalWeight = 0;
        int edgesInMST = 0;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if (rootU != rootV) {
                System.out.println(u + " - " + v + " \t" + weight);
                totalWeight += weight;
                parent[rootU] = rootV; 
                edgesInMST++;
            }

            if (edgesInMST == V - 1) {
                break;
            }
        }

        System.out.println("Total MST Weight: " + totalWeight);
    }
}
