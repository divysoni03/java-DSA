import java.util.ArrayList;

public class heapFromArr {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

       public void add(int data) {
            arr.add(data);

            int x = arr.size() - 1;

            while (x > 0) {
                int parent = (x - 1) / 2;

                if (arr.get(x) < arr.get(parent)) {
                    int temp = arr.get(x);
                    arr.set(x, arr.get(parent));
                    arr.set(parent, temp);

                    x = parent; // move up
                } else {
                    break;
                }
            }
        }

        private void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if(minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(arr.size()-1);

            // step 1. swap the first and last elements
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // step 2. remove the last element from the AL
            arr.remove(arr.size()-1);

            // step 3. heapify
            heapify(0);

            return data;
        }

        public int peek() {
            return arr.get(0);
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }


        public void print() {
            for(int i=0;i<arr.size();i++) {
                System.out.print(arr.get(i) + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Heap myHeap = new Heap();

        myHeap.add(2);
        myHeap.add(1);
        myHeap.add(5);
        myHeap.add(3);
        myHeap.add(0);

        myHeap.print();

        myHeap.remove();

        myHeap.print();

        System.out.println(myHeap.peek());
        System.out.println(myHeap.isEmpty());
    }
}
