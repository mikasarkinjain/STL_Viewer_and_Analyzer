// Team Double A
// Period 8
// STL Viewer and Analyzer

public class 3DObject{

    private ArrayList<Triangle> triangles = new ArrayList<Triangle>();
    
    public 3DObject (ArrayList<Triangle> t) {
	for (Triangle i: t) {
	    triangles.add(i);
	}
    }

     public String toString() {
	 return triangles; 
     }

    public Triangle getTriangles(int n) {
	return triangles.get(n); 
    }

    public Triangle getProjectedTriangles(int n, double xTheta, double yTheta, double zTheta) {
	Triangle projected = new Triangle((triangle.get(n-1)).projectedCor(1), (triangle.get(n-1)).projectedCor(2),(triangle.get(n-1)).projectedCor(3));
	return projected;
    }
}
