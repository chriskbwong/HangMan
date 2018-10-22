import java.util.Scanner;
//there is no front end to this game currently

public class gameRun {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		int guessCount = 0;
		String guessList[] = { "Do Not Guess", "Do Not Guess", "Do Not Guess", "Do Not Guess", "Do Not Guess" }; //fills array with values the user would not likely enter
		System.out.println("Enter a Phrase:");
		String caseSentence = kb.nextLine(); //saves inputs as caseSentence
		String sentence = caseSentence.toLowerCase();
		String presentedSentence = sentence.replaceAll("[a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z]", "_ "); //replaces all characters with blanks and saves as presentedSentence

		System.out.println(presentedSentence);
		boolean playGame = true;

		while (presentedSentence.contains("_ ") && playGame) {
			System.out.println("Enter your guess:");
			String caseGuess = kb.nextLine();
			String guess = caseGuess.toLowerCase();
			String changedGuess = guess.toUpperCase();//ensures the input is seen as uppercase
			if (sentence.contains(changedGuess)) { //checks to see if the player guessed already
				System.out.println("You have already guessed " + guess + ", try again!"); 
				System.out.println("You have made " + guessCount + " incorrect guesses.");
			}
			if (sentence.contains(guess)) { //replaces blank space with letter if player guesses correctly
				sentence = sentence.replace(guess, changedGuess);
				presentedSentence = sentence.replaceAll("[a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z]", "_ ");
				System.out.println(presentedSentence);
				System.out.println("You have made " + guessCount + " incorrect guesses.");
			}
			if (guessList[0].equals(guess) || guessList[1].equals(guess) || guessList[2].equals(guess)
					|| guessList[3].equals(guess)) {
				System.out.println("You have already guessed " + guess + ", try again!");
				System.out.println("You have made " + guessCount + " incorrect guesses.");
			} else if (!sentence.contains(guess) && !sentence.contains(changedGuess)) {
				System.out.println("Incorrect, try again!");
				guessCount++;
				/*
				 * this could have been done with a switch
				 * draws an image for the player to show how many guesses they made incorrectly
				 * could have been done with a U.I.
				 */
				if (guessCount == 1) { 
					System.out.println(presentedSentence);
					System.out.println("You have made " + guessCount + " incorrect guesses.");
					System.out.println(" O     ");
					System.out.println("       ");
					System.out.println("       ");
					guessList[0] = guess;
				}
				if (guessCount == 2) {
					System.out.println(presentedSentence);
					System.out.println("You have made " + guessCount + " incorrect guesses.");
					System.out.println(" O   O ");
					System.out.println("       ");
					System.out.println("       ");
					guessList[1] = guess;
				}
				if (guessCount == 3) {
					System.out.println(presentedSentence);
					System.out.println("You have made " + guessCount + " incorrect guesses.");
					System.out.println(" O   O ");
					System.out.println("   <   ");
					System.out.println("       ");
					guessList[2] = guess;
				}
				if (guessCount == 4) {
					System.out.println(presentedSentence);
					System.out.println("You have made " + guessCount + " incorrect guesses.");
					System.out.println(" O   O ");
					System.out.println("   <   ");
					System.out.println(" _____ ");
					guessList[3] = guess;
				}
			}
			if (guessCount == 5) {
				System.out.println("You have made " + guessCount + " incorrect guesses.");
				System.out.println(" X   X ");
				System.out.println(" ' < ' ");
				System.out.println(" _____ ");
				System.out.println("You have guessed too many times, game over.");
				guessList[4] = guess;
				playGame = false; // after 5 incorrect player loses
			}

			if (!presentedSentence.contains("_ ")) { //checks to see if there are blanks left
														//if no blanks then the player wins
				System.out.println("You guessed the phrase congratulations you win!");
				playGame = false;
			}
		}
		kb.close();
	}
}
