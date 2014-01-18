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

    public double[] getMax(){
        double[] max = new double[3];
        for (Triangle i : triangles) {
                double[] tempmax = i.maxCor();
                max[0] = Math.max( max[0], tempmax[0]);
                max[1] = Math.max( max[1], tempmax[1]);
                max[2] = Math.max( max[2], tempmax[2]);
        }
        return max;
    }

    //getMin returns a 1D array in the form [x,y,z] of the min cors 
    public double[] getMin(){
        double[] min = new double[3];
        for (Triangle i : triangles) {
                double[] tempmin = i.minCor();
                min[0] = Math.min( min[0], tempmin[0]);
                min[1] = Math.min( min[1], tempmin[1]);
                min[2] = Math.min( min[2], tempmin[2]);
        }
        return min;
    }

    public double[][][] getProjected3DObject(double xTheta, double yTheta, double zTheta, double zoom) {
    	double[][][] projected3DObject = new double[triangles.size()][3][2];
    	for (int i = 0; i < triangles.size(); i++){
	    projected3DObject[i] = triangles.get(i).getProjectedTriangle(xTheta, yTheta, zTheta, zoom, getMax(), getMin());
    	}
    	return projected3DObject;
    }
}
