// Team Double A
// Period 8
// STL Viewer and Analyzer

public class 3DObject{

    private ArrayList<Triangle> triangles = new ArrayList<Triangle>();
    
    public 3DObject (double[][][] t) {
	for (double[][] i: t) {
	    triangles.add(i);
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
