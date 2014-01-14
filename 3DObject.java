// Team Double A
// Period 8
// STL Viewer and Analyzer

public class 3DObject{

    private ArrayList<Triangle> triangles = new ArrayList<Triangle>(); //HAS TO BE ARRAY OF TRIANGLE OBJECTS
    
    public 3DObject (double[][][] t) {
	for (double[][] i: t) {
            Triangle in = new Triangle(i)
	    triangles.add(in);       //You need to instantiate a new triangle to satsify this ^^
	}
    }

     public String toString() {
	 return triangles; 
     }

    public Triangle getTriangle(int n) {
	return triangles.get(n); 
    }

    public double[][][] getProjected3DObject(double xTheta, double yTheta, double zTheta) {
    	double[][][] projected3DObject = new double[triangles.size()][3][2];
    	for (int i = 0; i < triangles.size(); i++){
    		projected3DObject[i] = triangles.get(i).getProjectedTriangle(double xTheta, double yTheta, double zTheta);
    	}
    	return projected3DObject;
    }
}
