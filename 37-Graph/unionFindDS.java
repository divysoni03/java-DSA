public class unionFindDS {
    static int n = 7;
    static int[] parent = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for(int i=0; i<n; i++) {
            parent[i] = i; // at beginning parent of their own
        }
    }

    public static int find(int x) {
        if(x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(rank[parentA] == rank[parentB]) { // same rank
            parent[parentB] = parentA;
            rank[parentA]++;
        } else if(rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
        }
    }
    public static void main(String[] args) {
        init();

        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(2, 6);
        System.out.println(find(6));
        union(1, 2);
        System.out.println(find(6));
    }
}