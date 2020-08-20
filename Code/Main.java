import java.io.*;
import java.util.*;

/**
 * @author Elif Pulukçu
 * @since April 23, 2019
 * Program Explanation: In this program, I tried to take information about several functions from text files with try and catch.
 * If the file is not found, the user will see an error message. Files contain polynomial coefficients. According to this, I have classified these functions.
 * I kept all the data I could access on an array list. Also, I set the canvas of 700*700 with x range [-10, 10] to show how the functions look like.
 */

public class Test {

	public Test() { //default constructor
	}
	/**
	 * @param args
	 */
	@SuppressWarnings("resource") 
	public static void main(String[] args) {

		String file = "functions1.txt";
		try {
			File dataFile = new File(file);
			Scanner input = null;
			String line;
			ArrayList<Polynomial> polinoms = new ArrayList<>();
			ArrayList<Double> values = null;
			String[] polinomValue;

			StdDraw.setCanvasSize(700, 700); //set canvas
			StdDraw.setXscale(-10, 10); //set the range of x and y axis
			StdDraw.setYscale(-10, 10);
			StdDraw.setPenRadius(0.002);
			StdDraw.line(0, -10, 0, 10);
			StdDraw.line(-10, 0, 10, 0);

			for (int i = 0; i < 20; i++) {
				StdDraw.line(0 - 0.1, i - 10, 0 + 0.1, i - 10);
				StdDraw.line(i - 10, 0 - 0.1, i - 10, 0 + 0.1);
			}

			input = new Scanner(dataFile);
			int size = 0;

			while (input.hasNext()) {

				line = input.next();
				values = new ArrayList<>();
				polinomValue = line.split(",");

				for (String t : polinomValue) {
					values.add(Double.parseDouble(t));
				}
				
				size = values.size();
				
				if (size == 2) {
					Polynomial1D oneDimension = new Polynomial1D(values.get(0), values.get(1));
					polinoms.add(oneDimension);
				}

				if (size == 3) {
					Polynomial2D secondDimension = new Polynomial2D(values.get(0), values.get(1), values.get(2));
					polinoms.add(secondDimension);
				}

				if (size == 4) {
					Polynomial3D thirdDimension = new Polynomial3D(values.get(0), values.get(1), values.get(2),
							values.get(3));
					polinoms.add(thirdDimension);
				}
			}

			for (Polynomial p : polinoms) {

				for (double i = -10; i < 10.0; i += 0.01) {
					
					double y = p.evaluate(i);
					p.setX(i);
					p.setY(y);
				}
				p.draw();
				System.out.println(p.toString());
				p.derivative(-10, 10);
			}
		}

		// Block of code to handle errors
		catch (FileNotFoundException e) {
			System.out.println("File : " + file + " doesn`t exist.");
		} catch (Exception e) {
			System.out.println("There are no points with zero derivative in the range.");
		}
                StdDraw.save("output_figure.png");
	}
}
