// Team Double A
// Period 8
// STL Viewer and Analyzer

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class TriangleObject {

    private ArrayList<Triangle> triangles = new ArrayList<Triangle>(); //HAS TO BE ARRAY OF TRIANGLE OBJECTS
    
    public TriangleObject (double[][][] t) {
	for (double[][] i: t) {
            Triangle in = new Triangle(i);
		triangles.add(in);       //You need to instantiate a new triangle to satsify this ^^
	}
    }

    public String toString() {
	return triangles.toString(); 
    }

    public Triangle getTriangle(int n) {
	return triangles.get(n); 
    }

    public double[][][] getProjected3DObject(double xTheta, double yTheta, double zTheta) {
    	double[][][] projected3DObject = new double[triangles.size()][3][2];
    	for (int i = 0; i < triangles.size(); i++){
	    projected3DObject[i] = triangles.get(i).getProjectedTriangle(xTheta, yTheta, zTheta);
    	}
    	return projected3DObject;
    }
}
