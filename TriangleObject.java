// Team Double A
// Period 8
// STL Viewer and Analyzer

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class TriangleObject {

    // instance of class ArrayList, holding objects of type Triangle
    // ArrayList triangles: { { Triangle1 } , { Triangle2 }, ... ,{ TriangleN } } 
    // 			    { { { x1,y1,z1 } , { x2, y2, z2 }, { x3, y3, z3 } }, ...
    //	  		     { { x1,y1,z1 } , { x2, y2, z2 }, { x3, y3, z3 } } } 
    private ArrayList<Triangle> triangles = new ArrayList<Triangle>(); //HAS TO BE ARRAY OF TRIANGLE OBJECTS
    
   /*==================================================
     constructor -- initializes a TriangleObject object
     pre:
     post: adds Triangles objects to ArrayList triangles
     ==================================================*/
    public TriangleObject (double[][][] t) {
	for (double[][] i: t) {
            Triangle in = new Triangle(i);
		triangles.add(in);       //You need to instantiate a new triangle to satsify this ^^
	}
    }


   /*==================================================
     String toString() -- iterates through the ArrayList coordinates
     post: to print out the coordinate like this: [ [[xcor1, ycor1, zcor1],[xcor2, ycor2, zcor2],[xcor3, ycor3,zcor3]],
     						    [[xcor1, ycor1, zcor1],[xcor2, ycor2, zcor2],[xcor3, ycor3,zcor3]],
     						    ....]
     ==================================================*/ 
    public String toString() {
	return triangles.toString(); 
    }


   /*==================================================
     Accessor method: Triangle getTriangle(int n)
     post: returns the nth Triangle in ArrayList triangles
     ==================================================*/
    public Triangle getTriangle(int n) {
	return triangles.get(n); 
    }


  /*==================================================
    double[] getMax() -- iterates through the ArrayList triangles
    to find the maximum xcor, ycor, and zcor of all Triangles
    pre:
    post: returns double[] containing the max xcor, ycor and zcor
    ==================================================*/
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
    
    
  /*==================================================
    double[] getMin() -- iterates through the ArrayList triangles
    to find the minimum xcor, ycor, and zcor of all Triangles
    pre:
    post: returns double[] containing the min xcor, ycor and zcor
    ==================================================*/
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

 /*==================================================
   double[] getProjectedTriangle(double, double, double, double)
   pre:
   post: returns double[][][] of projected TriangleObject
   ==================================================*/
    public double[][][] getProjected3DObject(double xTheta, double yTheta, double zTheta, double zoom) {
    	double[][][] projected3DObject = new double[triangles.size()][3][2];
    	for (int i = 0; i < triangles.size(); i++){
	    projected3DObject[i] = triangles.get(i).getProjectedTriangle(xTheta, yTheta, zTheta, zoom, getMax(), getMin());
    	}
    	return projected3DObject;
    }// end getProjected3DObject method

} // end TriangleObject class
