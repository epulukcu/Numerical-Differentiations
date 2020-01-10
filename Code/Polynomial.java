import java.text.DecimalFormat;
import java.util.ArrayList;

public class Polynomial {

	private ArrayList<Double> x = new ArrayList<>();
	private ArrayList<Double> y = new ArrayList<>();
	private double h = 0.0001;

	public double evaluate(double x) { 

		return 0.00;

	}

	public void draw() {

		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);

		for (int i = 0; i < x.size(); i++) {
			StdDraw.filledCircle(x.get(i), y.get(i), h * 200);
		}
	}

	public ArrayList<Double> derivative(double xMin, double xMax) { //Calculate the derivative with the simplest numerical differentiation technique 

		ArrayList<Double> turevDeg = new ArrayList<>();
		ArrayList<Double> coefs = new ArrayList<>();
		
		for (double i = xMin; i < xMax; i += 0.001) {

			if ( Math.abs( (evaluate(i + h) - evaluate(i) ) / h) < 0.001) {

				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledCircle(i, evaluate(i), 0.2);
				turevDeg.add((evaluate(i + h) - evaluate(i)) / h);
				coefs.add(i);
			}
		}
		
		int c = 1;
		double count = coefs.size();
		System.out.println("Points with zero derivatives:");

		if (count == 0) {
			System.out.println("There are no points with zero derivative in the range.");
		}

		if (count > 0 && count <= 1) {
			System.out.println(
					c + ". " + "x:  " + Double.parseDouble(new DecimalFormat("##.##").format(coefs.get(0) )) 
					+ ", " + " y:  " + Double.parseDouble(new DecimalFormat("##.##").format(evaluate(coefs.get(0))) ));
			c++;
		}

		if ((count > 1 && count == 2) && ((coefs.get(coefs.size() - 2)) != (coefs.get(coefs.size() - 1)))) {
			System.out.println(
					c + ". " + "x:  " + Double.parseDouble(new DecimalFormat("##.##").format(coefs.get(0) )) + ", " + " y:  " 
			+ Double.parseDouble(new DecimalFormat("##.##").format(evaluate(coefs.get(0))) ));
					c++;
			if (Math.round(coefs.get(0)) != Math.round(coefs.get(1))) {
				System.out.println(
						c + ". " + "x:  " + Double.parseDouble(new DecimalFormat("##.##").format(coefs.get(1) ))+ ", " 
				+ " y:  " + Double.parseDouble(new DecimalFormat("##.##").format(evaluate(coefs.get(1))) ));
				c++;
			}
		}

		if ((count > 1 && count == 2) && ((coefs.get(coefs.size() - 2)) == (coefs.get(coefs.size() - 1)))) {
			System.out.println(
					c + ". " + "x:  " + Double.parseDouble(new DecimalFormat("##.##").format(coefs.get(0) )) + ", " 
			+ " y:  " + Double.parseDouble(new DecimalFormat("##.##").format(evaluate(coefs.get(0)))));
			c++;
		}

		if ((count > 1 && count != 2) && (coefs.get(0)) != (coefs.get(coefs.size() - 1))) {
			System.out.println(
					c + ". " + "x:  " + Double.parseDouble(new DecimalFormat("##.##").format(coefs.get(0) ))+ ", " + " y:  " 
			+ Double.parseDouble(new DecimalFormat("##.##").format(evaluate(coefs.get(0)))));
			c++;
			if (Math.round(coefs.get(coefs.size() - 1)) != 0.00 && coefs.get(0) != coefs.get(1)) {
				System.out.println(c + ". " + "x:  " + Double.parseDouble(new DecimalFormat("##.##").format(coefs.get(coefs.size() - 1)))  
				+ ", " + " y:  "
						+ Double.parseDouble(new DecimalFormat("##.##").format(evaluate(coefs.get(coefs.size() - 1)))) );
				c++;
			}
		}

		if ((count > 1 && count != 2) && (coefs.get(0)) == (coefs.get(coefs.size() - 1))) {
			System.out.println(
					c + ". " + "x:  " + Double.parseDouble(new DecimalFormat("##.##").format(coefs.get(0))) + ", " + " y:  " + 
							Double.parseDouble(new DecimalFormat("##.##").format(evaluate(coefs.get(0)))));
			c++;
		}

		System.out.println();

		return turevDeg;

	}
        //Setter and getter methods if needed
	public ArrayList<Double> getX() {

		return x;

	}

	public void setX(double x) {

		this.x.add(x);

	}

	public ArrayList<Double> getY() {

		return y;

	}

	public void setY(double y) {

		this.y.add(y);

	}

}