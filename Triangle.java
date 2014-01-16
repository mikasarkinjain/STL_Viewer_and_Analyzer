// Team Double A
// Period 8
// STL Viewer and Analyzer 

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class Triangle {

    // instance of class ArrayList, holding objects of type Coordinate
    private ArrayList<Coordinate> coordinates; 
    
    //default constructor initializes instance variables coordinate
    public Triangle (double[][] cors) {
	coordinates = new ArrayList <Coordinate>();

	Coordinate in;
    	for (double[] i: cors){
	    in = new Coordinate(i);
	    coordinates.add(in);//adds a double[] = Coordinate 
	    // You have to instantiate a coordinate to satisfy this ^^
    	}
    }

    public String toString() {
	return coordinates.toString();
    }

    public Coordinate getCor(int n) {
	return coordinates.get(n); 
    }

    public double[][] getProjectedTriangle(double xTheta, double yTheta, double zTheta) {
    	double[][] projectedCoords = new double[3][2];
  	//projectedCoords[0] = coordinates.get(0).getProjectedCoord( xTheta, yTheta, zTheta);
	//code above doesn't work because the getProjectedCoord takes no params
    	projectedCoords[0] = coordinates.get(0).getProjectedCoord();
    	projectedCoords[1] = coordinates.get(1).getProjectedCoord();
    	projectedCoords[2] = coordinates.get(2).getProjectedCoord();
	return projectedCoords;
    }
}
