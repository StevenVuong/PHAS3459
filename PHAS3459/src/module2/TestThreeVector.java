package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		// Creating & Printing vectors, v1,v2 and v3
		ThreeVector v1 = new ThreeVector(3, 5, 2);
		ThreeVector v2 = new ThreeVector(2, 4, 1);
		ThreeVector v3 = new ThreeVector(0, 0, 0);
		System.out.println("v1: " + v1);
		System.out.println("v2: " + v2);
		System.out.println("v3: " + v3);

		System.out.println("");
		
		// Calculating static scalar & vector product and assigning these to variables
		double scalarStaticv1v2 = ThreeVector.scalarProduct(v1, v2);
		double scalarStaticv1v3 = ThreeVector.scalarProduct(v1, v3);
		ThreeVector vectorStaticv1v2 = ThreeVector.vectorProduct(v1, v2);
		ThreeVector vectorStaticv1v3 = ThreeVector.vectorProduct(v1, v3);

		// Calculating non-static scalar & vector product & assigning these to variables
		double scalarNonStaticv1v2 = v1.scalarProduct(v2);
		double scalarNonStaticv1v3 = v1.scalarProduct(v3);
		ThreeVector vectorNonStaticv1v2 = v1.vectorProduct(v2);
		ThreeVector vectorNonStaticv1v3 = v1.vectorProduct(v3);

		System.out.println("");
		
		// Printing both static & non-static scalar/vector products
		System.out.println("Static scalar product of v1 & v2 is: " + scalarStaticv1v2
				+ " and the non-static equivalent is: " + scalarNonStaticv1v2);
		System.out.println("Static scalar product of v1 & v3 is: " + scalarStaticv1v3
				+ " and the non-static equivalent is: " + scalarNonStaticv1v3);
		System.out.println("Static vector product of v1 & v2 is: " + vectorStaticv1v2
				+ " and the non-static equivalent is: " + vectorNonStaticv1v2);
		System.out.println("Static vector product of v1& & v3 is: " + vectorStaticv1v3
				+ " and the non-static equivalent is: " + vectorNonStaticv1v3);

		// static angle
		double angleStaticv1v2 = ThreeVector.angle(v1, v2);
		double angleStaticv1v3 = ThreeVector.angle(v1, v3);

		// non-static angle
		double angleNonStaticv1v2 = v1.angle(v2);
		double angleNonStaticv1v3 = v1.angle(v3);

		System.out.println("");
		// Printing both static & non-static angles
		System.out.println("Static angle between v1 & v2 is: " + angleStaticv1v2 + " and the non-static equivalent is: "
				+ angleNonStaticv1v2+" radians"); 
		System.out.println("Static angle between v1 & v3 is: " + angleStaticv1v3 + " and the non-static equivalent is: "
				+ angleNonStaticv1v3+" radians, this answer is NaN as one of the vectors is (0,0,0)"); 
		System.out.println("Both the static and non-static return the same value for all calculations");

		System.out.println("");
		// System.out.println(v);
		System.out.println(
				"When I try to run 'System.out.println(v)' without a toString(), it states v cannot be resolved to a variable.");
		System.out.println(
				"This implies that the code does not acknowledge v as a string until defined so with tostring().");
		System.out.println("This is because v is not defined as a vector. This would be solved if I were to set it to v1 instead of v");

	}

}
