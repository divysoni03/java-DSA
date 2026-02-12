import java.util.LinkedList;
import java.util.ArrayList;

public class customHashMap {
    @SuppressWarnings("unchecked")
    static class HashMap<K, V> {
        private class Node{
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for(int i=0;i<buckets.length;i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }
        
        private int searchInLL(K key, int bi) {
            LinkedList<Node> curr = buckets[bi];
            for(int i=0;i<curr.size();i++) {
                if(curr.get(i).key == key) {
                    return i;
                }
            }

            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            N = N*2;
            this.buckets = new LinkedList[N];
            for(int i=0;i<buckets.length;i++) {
                buckets[i] = new LinkedList<>();
            }

            for(int i=0;i<oldBucket.length;i++) {
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0;j<ll.size();j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n/N;
            if(lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di != -1) return true;
            else return false;
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di != -1) {
                return buckets[bi].get(di).value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            
            Node node;
            if(di != -1) {
                node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public int size() {
            return n;
        }

        public boolean isEmpty() {
            return n==0;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> res = new ArrayList<>();
            for(int i=0;i<buckets.length;i++) {
                LinkedList<Node> ll = buckets[i];
                for(int j=0;j<ll.size();j++) {
                    res.add(ll.get(j).key);
                }
            }
            
            return res;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("china", 110);

        System.out.println(hm.get("India"));

        System.out.println(hm.keySet());
    }
}
