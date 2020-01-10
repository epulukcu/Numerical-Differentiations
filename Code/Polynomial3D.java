
public class Polynomial3D extends Polynomial{
	
	private double a,b,c,d;
	
	Polynomial3D (double a, double b, double c, double d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public double evaluate (double x) { 
		//		3rd degree polynomial: y = a + bx + cx2 + dx3
		double val = a + (b * x) + (c * (x*x)) + (d * (x*x*x));
		return val;
	}
	
@Override
	public String toString () {
		
		String text;
		text = "Function: (" + d + ")x^3 + (" + c + ")x^2 + (" + b +")x^1 + (" + a + ")";
		return text;
		 
	}
}
