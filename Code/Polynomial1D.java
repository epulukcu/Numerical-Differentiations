public class Polynomial1D extends Polynomial{
	
	private double a,b;

	Polynomial1D (double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public double evaluate (double x) {
		
		//1st degree polynomial: y = a + bx
		double val = a + (b * x);
		return val;
	}
	
@Override
	public String toString () {
		String text;
		text = "Function: (" + b + ")x^1 + (" + a + ")";
		return text;
	}
}
