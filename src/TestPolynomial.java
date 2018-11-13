
public class TestPolynomial {

	public static void main(String[] args) {

		MyPolynomial pol = new MyPolynomial(1, 3, 2);
			
		System.out.println(pol);
		
		MyPolynomial pol2 = new MyPolynomial("coeff.txt");
		
		System.out.println(pol2);
		System.out.println();
		System.out.println(pol.multiply(pol2));
		
	}

}
