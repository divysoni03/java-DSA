// public class mergeSortOnChar {
//     public static void mergeSort(String arr[], int si, int ei) {
//         if(si>=ei) return;

//         int mid = si + (ei-si)/2;
//         mergeSort(arr, si, mid);
//         mergeSort(arr, mid + 1, ei);
//         merge(arr, si, mid, ei);
//     }

//     public static void merge(String arr[], int si, int mid, int ei) {
//         String temp[] = new String[ei-si+1];
//         int i = si;
//         int j = mid;
//         int k = 0;

//         while(i<=mid && j<=ei) {
//             if(arr[i].compareTo(arr[j]) < 0) {
//                 temp[k++] = arr[i++];
//             } else {
//                 temp[k++] = arr[j++];
//             }
//         }

//         while(i<=mid) {
//             temp[k++] = arr[i++];
//         }
//         while(j<=ei) {
//             temp[k++] = arr[j++];
//         }

//         for(k=0,i=si;k<temp.length;k++, i++) {
//             arr[i] = temp[k];
//         }
//     }

//     public static void printArr(String arr[]) {
//         for(String i: arr) {
//             System.out.print(i + ", ");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         String words[] = {"sun", "earth", "mars", "mercury"};
//         printArr(words);
//         mergeSort(words, 0, words.length - 1);
//         printArr(words);
//     }
// }
