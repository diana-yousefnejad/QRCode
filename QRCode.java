
/*Program 1
 * creates a class QRCode that fills a grid with values that looks like a QR code
 * CS160-3
 * February 9th, 2022
 * @author Diana Yousefnejad
 */





import java.util.Random;
      
public class QRCode {
	public static void main(String[] args) {
		//giving default values for dimension and seed 
	
		final int DEFAULT_DIMENSION = 30;
		final int DEFAULT_SEED = 160;
		int dim = DEFAULT_DIMENSION;
		int seed =  DEFAULT_SEED;
		//command line argument for dim and seed 
		
		if (args.length == 2) {
		dim = Integer.parseInt(args[0]);
		seed = Integer.parseInt(args[1]);
		}
		//instantiating object QRCode
		 
		QRCode qrc = new QRCode();
		//calling all methods
		
		int[] pattern = qrc.createPattern(dim, seed);
		
        qrc.setGrid(dim, pattern);
        
        qrc.setFinder(0, 0);
        
        qrc.setFinder((dim - 15), 0);
        
        qrc.setFinder(0, (dim -15));
        
        qrc.print(qrc.getGrid());
		
	}
	private int[][] grid;
	
	public int[] createPattern(int dim, int seed) {
	
		//initializing and declaring pattern array (one dimensional);
		
		int[] pattern = new int[dim * dim];
		//fills one dimensional array pattern with random 0's and 1's using java.util.Random object
	
		Random randGen = new Random(seed);
		for (int i = 0; i < pattern.length; i++) {
		
				pattern[i] = randGen.nextInt(2);
			
		}
		return pattern;
	}
	
	public void setGrid(int dim, int[] pattern) {
		//making two dimensional array grid with array size of dim by dim
	
		grid = new int[dim][dim];
		//takes in pattern array and fills the grid row by row
 
	
		for (int i = 0; i < pattern.length; i++) {
			int row = i /dim;
			int column = i % dim;
			grid[row][column] = pattern[i];
		}
	}
	
	public int[][] getGrid() {
		//returns grid	

		return grid;
	}
	
	public void setFinder (int xPos, int yPos) {
		// makes the rectangles on the three corners of the qr code(top left, top right, and bottom left)

        for (int i = xPos; i < xPos + 15; ++i) {
            for (int j = yPos; j < yPos + 15; ++j) {
                grid[i][j] = 1;
            }
        }
        
        for (int i = xPos + 2; i < xPos + 13; ++i) {
            for (int j = yPos + 2; j < yPos + 13; ++j) {
                grid[i][j] = 0;
            }
        }
        
        for (int i = xPos + 4; i < xPos + 11; ++i) {
            for (int j = yPos + 4; j < yPos + 11; ++j) {
                grid[i][j] = 2;
            }
        }
        
        for (int i = xPos + 6; i < xPos + 9; ++i) {
            for (int j = yPos + 6; j < yPos + 9; ++j) {
                grid[i][j] = 3;
            }
        }
    }
	
	public void print() {
		// prints grid

		print(grid);
	}
	
	public void print(int[] pattern) {
		// outputs the one dimensional pattern as the parameter as the two-dimensional grid
	
		int dim = pattern.length;
	for (int i = 0; i < dim ; i++) {
		for (int j = 0; j < dim; j++) {
			System.out.print(pattern[j]);
		}
		//creates a new line for each row
		 
		System.out.println();
		}
	}
	
	public void print(int[][] matrix) {
		//outputs the two dimensional matrix with no spaces in between values in each of the row
		
		int dim = matrix.length;
		for (int i = 0; i < dim ; i++) {
			for (int j = 0; j < dim; j++) {
				System.out.print(matrix[i][j]);
			}
		//creates a new line for each row
		 
			System.out.println();
			}
		}
		
	}




