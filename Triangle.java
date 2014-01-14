// Team Double A
// Period 8
// STL Viewer and Analyzer 

public class Triangle {

    private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
    
    public Triangle (double[][] cors) {
    	for (int i = 0; i < 3; i++}
	coordinates.add(cors[1]); //adds a double[] = Coordinate
	coordinates.add(cors[2]);
	coordinates.add(cors[3]);
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
