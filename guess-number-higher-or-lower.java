/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return guessNumberUtil(0, n);
    }
    
    public int guessNumberUtil(int low, int high) {
        if(low < high){
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if(res == 0)
                return mid;
            if(res < 0)
                return guessNumberUtil(low, mid - 1);
            return guessNumberUtil(mid + 1, high);
        }
        if(low == high && guess(low) == 0)
            return low;
        return -1;
            
    }
}