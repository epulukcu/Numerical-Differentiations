
public class Polynomial2D extends Polynomial{
	
	private double a, b, c;

	Polynomial2D (double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double evaluate (double x) {
		
		//	2nd degree polynomial: y = a + bx + cx2
		double val = a + (b * x) + (c * (x*x));
		return val;
	}
	
@Override
	public String toString () {
		
		String text;
		text = "Function: (" + c + ")x^2 + (" + b + ")x^1 + (" + a + ")";
		return text;
		
	}
}
