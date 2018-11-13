import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyPolynomial {

	private double[] coeffs;
	
	public MyPolynomial(double...coeffs) {
		
		this.coeffs = coeffs;
	}
	
	public MyPolynomial(String filename) { 
		Scanner in = null; 
		  try { 
		      in = new Scanner(new File(filename));
		   } catch (FileNotFoundException e) { 
		      e.printStackTrace(); 
		   } 
		   int degree = in.nextInt();  
		   coeffs = new double[degree+1];  
		   for (int i=0; i<coeffs.length; ++i) { 
		      coeffs[i] = in.nextDouble(); 
		   } 
	}
	
	public int getDegree() {
		
		return coeffs.length-1;
	}
	@Override
	public String toString() {
		
		String stringFinal = "";
		
		for (int i = coeffs.length - 1; i >= 2; i--) {
			
			if (coeffs[i] != 0) {		
			stringFinal = stringFinal + coeffs[i] + "x^" + i + " + ";
			}
		}
		
		if (coeffs[1] != 0) {
			
		stringFinal = stringFinal + coeffs[1] + "x + ";
		}
		
		if (coeffs[0] != 0) {
		
		stringFinal = stringFinal + coeffs[0];
		}
		
		return stringFinal;
	}
	
	public double[] getCoeffs() {
		
		return coeffs;
	}
	
	public double evaluate(double x) {
		
		double acc = 0;
		
		for (int i = 0; i < coeffs.length; i++) {
			
			double y = i;
			
			acc = acc + coeffs[i] * Math.pow(x, y);
		}
		return acc;
	}
	public MyPolynomial add(MyPolynomial newPol) {
		
		MyPolynomial newPolynomial;
		
		double[] coeffsResults = coeffs;
		
		if (coeffs.length > newPol.coeffs.length) {
		
		
		for (int i = 0; i < newPol.coeffs.length; i++) {
		
			coeffsResults[i] += newPol.coeffs[i];
			
		}
		
		newPolynomial = new MyPolynomial(coeffsResults);
		
		} else { 
			
			for (int i = 0; i < coeffs.length; i++) {
				
				newPol.coeffs[i] += coeffs[i];
				
			}
			
			newPolynomial = new MyPolynomial(newPol.coeffs);
		}
		return newPolynomial;
	}
	public MyPolynomial multiply(MyPolynomial newPol) {
		
		MyPolynomial newPolynomial;
		
		double [] acc = new double[getDegree() + newPol.getDegree()+1];
		
		for (int i = 0; i < acc.length; i++)  {
				
				acc[i]= 0;
		}
		
		for (int i = 0; i < coeffs.length; i++) {

			for (int j = 0; j < newPol.coeffs.length; j++) {
				
				acc[j+i] += coeffs[i] * newPol.coeffs[j];
			}
		}
		
		newPolynomial = new MyPolynomial(acc);
		
		return newPolynomial;
	}
}
