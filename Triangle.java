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

    public double[] maxCor() {
        double[] max = new double[3];
        for (int i = 0; i < 3; i++) {
            double a = (getCor(0)).getCor(i);
            double b = (getCor(1)).getCor(i);
            double c = (getCor(2)).getCor(i);
            max[i] = Math.max(c, Math.max(a,b));  
        }
        return max;
    }

    //Returns the min x, y, z coordinate of each triangle
    public double[] minCor() {
        double[] min = new double[3];
        for (int i = 0; i < 3; i++) {
            double a = (getCor(0)).getCor(i);
            double b = (getCor(1)).getCor(i);
            double c = (getCor(2)).getCor(i);
            min[i] = Math.min(c, Math.min(a,b));  
        }
        return min;
    }

    public double[][] getProjectedTriangle(double xTheta, double yTheta, double zTheta, double zoom, double[] max, double[] min) {
    	double[][] projectedCoords = new double[3][2];
  	//projectedCoords[0] = coordinates.get(0).getProjectedCoord( xTheta, yTheta, zTheta);
	//code above doesn't work because the getProjectedCoord takes no params
            projectedCoords[0] = coordinates.get(0).getProjectedCoord(xTheta, yTheta, zTheta, zoom, max, min);
            projectedCoords[1] = coordinates.get(1).getProjectedCoord(xTheta, yTheta, zTheta, zoom, max, min);
            projectedCoords[2] = coordinates.get(2).getProjectedCoord(xTheta, yTheta, zTheta, zoom, max, min);
	return projectedCoords;
    }
}
