// goldman sachs

/* friends pairing problem: given n friends, each one can ramian singe or can be paired up with some other friend.
 * each friend can be paired only once. find out the total number of ways in which friends can remain single or can be paired up.
 */

/* solve:
 * - each friend can only pair with one other friend
 * - find total number of way to pair(more like permutation combination)
 * - if not pair not found then friend can remain single
 * 
 * -> ex., n = 3
 * I -> I,I first friend have 2 ways to make pair, last one will remain single = 2 ways 
 * I<->I, I 
 * -> ex., n = 6
 * I-> I,I,I,I,I = 5 choice
 * I<->I, I->I,I,I = 1 pair, 3 choice 
 * I<->I, I<->I, I->I = 2 pair, 1 choice
 * I<->I, I<->I, I<->I = 3 pair, 0 choice
 * 
 * we didn't include inner permutation or position changes 
 * 
 * -> pattern 
 *  choice = n -> n-1 choice 
 *           n-2 -> n-1 -2 choice
 *           n-2-2 -> n-1 -2 -2 choice
 * 
 * 
 * 
 * 
 * n = 1 -> ways = 1
 *
 * n = 2 a,b
 * a,b both single or (a,b) in pair => 2 ways
 * 
 * n = 3 a,b,c
 * a,b,c all single
 * a(b,c)
 * b(a,c)
 * c(a,b)
 * => total 4 ways
 * 
 * base case -> n=1 -> way 1
 *              n=2 -> ways 2
 */

// My code
public class FriendsPairing {
    public static int find(int n) {
        //base case
        if(n==1 || n==2) return n;

        // choice
        // 1) choose to be single
        int single = find(n-1); // then have to make pair with remaining n-1 friends

        // 2) choose to make pair
        int pair = find(n-2); // then we have to make pair of remaining n-2 friends
        int waysToMakePair = (n-1) * pair;
        /* a (b,c,d) if a had to make pair with anyone from (b,c,d) 'a' can choose anyone so 
        * if there is n friends and one friends have to choose a pair from rest of the poeple(n-1) 
        * he/she has choice of n-1
        */ 

        return single + waysToMakePair;
    }

    public static void main(String[] args) {
        System.out.println(find(3));
    }
}
