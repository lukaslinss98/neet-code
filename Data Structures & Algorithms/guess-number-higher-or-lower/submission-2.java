/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

// 26/2=13 12+1/2 = 6 12+7/2 = 9 12+10/2 10+10/2= 10
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lower = 0;
        int upper = n;

        while(lower < upper) {
            int guess = lower + (upper - lower) / 2;

            int isCorrect = guess(guess);

            if(isCorrect < 0 ){
                upper = guess - 1;
            } else if (isCorrect > 0 ) {
                lower = guess + 1;
            } else {
                break;
            }
        }

        return lower + (upper - lower) / 2;
        
    }
}