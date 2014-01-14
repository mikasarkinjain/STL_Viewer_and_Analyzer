// Team Double A
// Period 8
// STL Viewer and Analyzer 

public class Triangle {

    private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>(); //HAS TO BE ARRAY OF THE OBJECT COORDINATE
    
    public Triangle (double[][] cors) {
    	for (double[] i: cors){
    		Coordinate in = new Coordinate(i);
		coordinates.add(in);//adds a double[] = Coordinate // You have to instantiate a coordinate to satisfy this ^^
    	}
    }

    public String toString() {
	return coordinates;
    }

    public Coordinate getCor(int n) {
	return coordinates.get(n); 
    }

    public double[][] getProjectedTriangle(double xTheta, double yTheta, double zTheta) {
    	double[][] projectedCoords = new double[3][2];
    	projectedCoords[0] = coordinates.get(0).getProjectedCoord(xTheta, yTheta, zTheta);
    	projectedCoords[1] = coordinates.get(1).getProjectedCoord(xTheta, yTheta, zTheta);
    	projectedCoords[2] = coordinates.get(2).getProjectedCoord(xTheta, yTheta, zTheta);
	return projectedCoords;
    }
}
