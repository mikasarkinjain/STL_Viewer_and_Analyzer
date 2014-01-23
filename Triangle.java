// Team Double A
// Period 8
// STL Viewer and Analyzer 

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class Triangle {

    // instance of class ArrayList, holding objects of type Coordinate
    // ArrayList coordinates: { {Coordinate1}, {Coordinate2}, {Coordinate3} }
    // 			      { {x1,y1,z1}, {x2, y2, z2},  {x3, y3, z3} }  
    private ArrayList<Coordinate> coordinates; 
    
    /*==================================================
      constructor -- initializes a Triangle object
      pre:
      post: adds Coordinate objects to the ArrayList coordinates
      ==================================================*/
    public Triangle (double[][] cors) {
	coordinates = new ArrayList <Coordinate>();

	Coordinate in;
    	for (double[] i: cors){
	    in = new Coordinate(i);
	    coordinates.add(in);//adds a double[] = Coordinate 
	    // You have to instantiate a coordinate to satisfy this ^^
    	}
    }


   /*==================================================
     String toString() -- iterates through the ArrayList coordinates
     post: to print out the coordinate like this: [[xcor1, ycor1, zcor1],[xcor2, ycor2, zcor2],[xcor3, ycor3, zcor3]]
     ==================================================*/ 
    public String toString() {
	return coordinates.toString();
    }
   
   
    /*==================================================
      Accessor method: Coordinate getCor(int n) 
      post: returns the nth Coordinate in ArrayList coordinates
      ==================================================*/
    public Coordinate getCor(int n) {
	return coordinates.get(n); 
    }
    

   /*==================================================
     double[] maxCor() -- iterates through the ArrayList Coordinates 
     to find the maximum xcor, ycor, and zcor of all Coordinates
     pre:
     post: returns double[] containing the max xcor, ycor and zcor
     ==================================================*/
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
    
    
   /*==================================================
     double[] minCor() -- iterates through the ArrayList Coordinates 
     to find the miniumum xcor, ycor, and zcor of all Coordinates
     pre:
     post: returns double[] containing the min xcor, ycor and zcor
     ==================================================*/
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
    
    
  /*==================================================
    double[] getProjectedTriangle(double, double, double, double, double[], double[])
    pre:
    post: returns double[][] of projected Triangle 
    ==================================================*/
    public double[][] getProjectedTriangle(double xTheta, double yTheta, double zTheta, double zoom, double[] max, double[] min) {
    	double[][] projectedCoords = new double[3][2];

            projectedCoords[0] = coordinates.get(0).getProjectedCoord(xTheta, yTheta, zTheta, zoom, max, min);
            projectedCoords[1] = coordinates.get(1).getProjectedCoord(xTheta, yTheta, zTheta, zoom, max, min);
            projectedCoords[2] = coordinates.get(2).getProjectedCoord(xTheta, yTheta, zTheta, zoom, max, min);
            
	return projectedCoords;
    } // end getProjectTriangle method
    
} // end Triangle class
