// This class defines a Sudoku puzzle.  It has two representations of
// the puzzle - the initial state, and the current state. 
// The class has a verification method and safe way to pick successor state.

public class Sudoku {
	// The initial state of the puzzle. This is
	// the start of the puzzle. Zeros represent
	// spaces, otherwise each element in the array
	// should be numbers between 1 - 4.
	private final int[][] initialState = new int[9][9];

	// The current state of the puzzle. This is
	// the user's answer. Zeros represent spaces,
	// otherwise each element in the array should
	// be numbers between 1 - 4.
	private final int[][] currentState = new int[9][9];

	// Constructor with no arguments. This creates
	// an empty board. This is useful in case the
	// user wants to enter in a completed Sudoku
	// to simply verify that his or her answer is
	// correct.
	public Sudoku() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.initialState[i][j] = this.currentState[i][j] = 0;
			}
		}
	}

	// Constructor that takes a two dimensional array
	// as an argument. This constructor takes the array
	// and copies itself into both Sudoku arrays.
	// Note: Needs error checking to verify that state
	// array is a 4x4 array.
	public Sudoku(int[][] state) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.initialState[i][j] = this.currentState[i][j] = state[i][j];
			}
		}
	}

	// This prints the current state to the console.
	// For debugging purposes.
	public void printCurrentState() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(this.currentState[i][j] + " ");
			}
			System.out.println("");
		}
	}

	// This prints the initial state to the console.
	// For debugging purposes.
	public void printInitialState() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(this.initialState[i][j]);
			}
			System.out.println("");
		}
	}

	// This class is necessary to prevent the original
	// state variables to be passed by reference in the
	// getter classes.
	private int[][] copyState(int[][] stateToBeCopied) {
		int[][] tempState = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tempState[i][j] = stateToBeCopied[i][j];
			}
		}

		return tempState;
	}

	// This returns the current state.
	public int[][] getCurrentState() {
		return this.copyState(this.currentState);
	}

	// This returns the initial state.
	public int[][] getInitialState() {
		return this.copyState(this.initialState);
	}

	// This sets the current state to whatever
	// the user wants. Note that the initial
	// state will not get a function like this
	// so that the program can verify that the
	// squares in the current state that are
	// filled in on the initial state are not
	// overwritten.
	public int setCurrentState(int[][] state) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.currentState[i][j] = state[i][j];
			}
		}

		return 0;
	}

	// This function verifies the correctness of
	// the current state. If the current state is
	// a valid answer, verify() will return a zero.
	// Otherwise, it will return the amount of incorrect squares
	// in each of the five tests: comparing currentState against
	// initial state, verifying that currentState has no blanks,
	// verifying that each row in currentState has a unique number
	// ranging from one through four, verifying that each column
	// in currentState has a unique number ranging from one through
	// four, and finally, verifying that each square in currentState
	// has a unique number ranging from one through four.
	public int verify() {
		int incorrect = 0; // Number of incorrect squares.
		int match = 0; // Number of matches in an array

		// Verify that the nonzero values in initialState
		// are the same numbers as in currentState.
		for (int col = 0; col < 9; col++) {
			for (int row = 0; row < 9; row++) {
				if (this.initialState[row][col] != 0) {
					if (this.initialState[row][col] != this.currentState[row][col]) {
						incorrect++;
					}
				}
			}
		}

		// Verify that there are no blank spots in the
		// sudoku. Blank spots, in this program, are
		// represented by zeroes. To do that, we'll
		// simply count the zeroes in the entire sudoku
		// and add them to 'incorrect'.
		for (int col = 0; col < 9; col++) {
			for (int row = 0; row < 9; row++) {
				if (this.currentState[col][row] == 0) {
					incorrect++;
				}
			}
		}

		// Verify that each row only has unique
		// numbers and that each number ranges
		// from one through four. How this is done
		// is that a for loop cycles through
		// the array and counts up the matches. If
		// the number of matches is greater than one,
		// then the number of matches minus one is added
		// to the incorrect variable, and the match variable
		// is zeroed out.
		for (int col = 0; col < 9; col++) {
			for (int row = 0; row < 9; row++) {
				for (int i = 0; i < 9; i++) {
					if (this.currentState[col][row] == this.currentState[col][i]) {
						match++;
					}
				}

				if (match > 1) {
					incorrect += --match;
					match = 0;
				} else {
					match = 0;
				}
			}
		}

		// Verify that each column only has unique
		// numbers and that each number range
		// from one through four. How this is done
		// is that a for loop cycles through
		// the array and counts up the matches. If
		// the number of matches is greater than one,
		// then the number of matches minus one is added
		// to the incorrect variable, and the match variable
		// is zeroed out.
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				for (int i = 0; i < 9; i++) {
					if (this.currentState[col][row] == this.currentState[i][row]) {
						match++;
					}
				}

				if (match > 1) {
					incorrect += --match;
					match = 0;
				} else {
					match = 0;
				}
			}
		}

		// Verify that each square has only unique
		// numbers and that each number range
		// from one through four.
		// First, I made four temporary 2x2 arrays,
		// then I basically put each square of the
		// sudoku into each array, then I checked
		// the validity of each square, incrementing
		// the incorrect variable by one for each
		// duplicate in each square.

		// từng hình vuông nhỏ
		// cho mục đích xác nhận
		int[][] tempOne = new int[3][3];
		int[][] tempTwo = new int[3][3];
		int[][] tempThree = new int[3][3];
		int[][] tempFour = new int[3][3];
		int[][] tempFive = new int[3][3];
		int[][] tempSix = new int[3][3];
		int[][] tempSeven = new int[3][3];
		int[][] tempEight = new int[3][3];
		int[][] tempNine = new int[3][3];

		// chia Sudoku thành 9 mảng nhỏ
		// 1 mảng cho 1 hình vuông
		for (int row = 0; row < 9; row++) {
			// chạy từng ô vuông nhỏ
			switch (row) {
			case 0:
				for (int col = 0; col < 3; col++) {
					tempOne[row][col] = this.currentState[row][col];
				}

				for (int col = 0; col < 3; col++) {
					tempTwo[row][col] = this.currentState[row][col];
				}
				for (int col = 0; col < 3; col++) {
					tempThree[row][col] = this.currentState[row][col];
				}

				break;
			case 1:
				for (int col = 0; col < 3; col++) {
					tempOne[row][col] = this.currentState[row][col];
				}

				for (int col = 0; col < 3; col++) {
					tempTwo[row][col] = this.currentState[row][col];
				}
				for (int col = 0; col < 3; col++) {
					tempThree[row][col] = this.currentState[row][col];
				}

				break;
			case 2:
				for (int col = 0; col < 3; col++) {
					tempOne[row][col] = this.currentState[row][col];
				}

				for (int col = 0; col < 3; col++) {
					tempTwo[row][col] = this.currentState[row][col];
				}
				for (int col = 0; col < 3; col++) {
					tempThree[row][col] = this.currentState[row][col];
				}

				break;
			case 3:
				for (int col = 0; col < 3; col++) {
					tempFour[0][col] = this.currentState[row][col];
				}

				for (int col = 0; col < 3; col++) {
					tempFive[0][col] = this.currentState[row][col];
				}
				for (int col = 0; col < 3; col++) {
					tempSix[0][col] = this.currentState[row][col];
				}

				break;
			case 4:
				for (int col = 0; col < 3; col++) {
					tempFour[1][col] = this.currentState[row][col];
				}

				for (int col = 0; col < 3; col++) {
					tempFive[1][col] = this.currentState[row][col];
				}
				for (int col = 0; col < 3; col++) {
					tempSix[1][col] = this.currentState[row][col];
				}

				break;
			case 5:
				for (int col = 0; col < 3; col++) {
					tempFour[2][col] = this.currentState[row][col];
				}

				for (int col = 0; col < 3; col++) {
					tempFive[2][col] = this.currentState[row][col];
				}
				for (int col = 0; col < 3; col++) {
					tempSix[2][col] = this.currentState[row][col];
				}

				break;
			case 6:
				for (int col = 0; col < 3; col++) {
					tempSeven[0][col] = this.currentState[row][col];
				}

				for (int col = 0; col < 3; col++) {
					tempEight[0][col] = this.currentState[row][col];
				}
				for (int col = 0; col < 3; col++) {
					tempNine[0][col] = this.currentState[row][col];
				}

				break;
			case 7:
				for (int col = 0; col < 3; col++) {
					tempSeven[1][col] = this.currentState[row][col];
				}

				for (int col = 0; col < 3; col++) {
					tempEight[1][col] = this.currentState[row][col];
				}
				for (int col = 0; col < 3; col++) {
					tempNine[1][col] = this.currentState[row][col];
				}

				break;
			case 8:
				for (int col = 0; col < 3; col++) {
					tempSeven[2][col] = this.currentState[row][col];
				}

				for (int col = 0; col < 3; col++) {
					tempEight[2][col] = this.currentState[row][col];
				}
				for (int col = 0; col < 3; col++) {
					tempNine[2][col] = this.currentState[row][col];
				}

				break;
			default:
				System.out.println("You shouldn't be here...");
				break;
			}
		}

		// xác nhận mỗi hình vuông có duy nhất 1 số nguyên từ 1-9
		int matchOne = 0;
		int matchTwo = 0;
		int matchThree = 0;
		int matchFour = 0;
		int matchFive = 0;
		int matchSix = 0;
		int matchSeven = 0;
		int matchEight = 0;
		int matchNine = 0;

		// The first two for loops fix a number to be compared.
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {

				// These two for loops cycles through the square,
				// counting the number of matches along the way.
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (tempOne[row][col] == tempOne[i][j]) {
							if (i != row && col != j) {
								matchOne++;
							}
						}
						if (tempTwo[row][col] == tempTwo[i][j]) {
							if (i != row && col != j) {
								matchTwo++;
							}
						}
						if (tempThree[row][col] == tempThree[i][j]) {
							if (i != row && col != j) {
								matchThree++;
							}
						}
						if (tempFour[row][col] == tempFour[i][j]) {
							if (i != row && col != j) {
								matchFour++;
							}
						}
						if (tempFive[row][col] == tempFive[i][j]) {
							if (i != row && col != j) {
								matchFive++;
							}
						}
						if (tempSix[row][col] == tempSix[i][j]) {
							if (i != row && col != j) {
								matchSix++;
							}
						}
						if (tempSeven[row][col] == tempSeven[i][j]) {
							if (i != row && col != j) {
								matchSeven++;
							}
						}
						if (tempEight[row][col] == tempEight[i][j]) {
							if (i != row && col != j) {
								matchEight++;
							}
						}
						if (tempNine[row][col] == tempNine[i][j]) {
							if (i != row && col != j) {
								matchNine++;
							}
						}
					}
				}

				// If there is more than one match, the match variable
				// is decremented by one (so the original number isn't
				// counted) and added to the number of incorrect
				// squares in the sudoku.
				if (matchOne > 1) {
					incorrect += matchOne;
					matchOne = 0;
				} else {
					matchOne = 0;
				}
				if (matchTwo > 1) {
					incorrect += matchTwo;
					matchTwo = 0;
				} else {
					matchTwo = 0;
				}
				if (matchThree > 1) {
					incorrect += matchThree;
					matchThree = 0;
				} else {
					matchThree = 0;
				}
				if (matchFour > 1) {
					incorrect += matchFour;
					matchFour = 0;
				} else {
					matchFour = 0;
				}
			}
		}

		// Returns the number of incorrect numbers in the array.
		return incorrect;
	}
}