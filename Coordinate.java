// Team Double A
// Period 8
// STL Viewer and Analyzer

public class Coordinate {

    // instance of an array containing three doubles, represents [xcor, ycor, zcor]
    private double[] coordinate = new double[3];
    
     /*==================================================
      constructor -- initializes a Coordinate object 
      pre:
      post: adds coordinate values to the coordinate array
      ==================================================*/
    public Coordinate(double[] cors) {
	// make sure the input array contains three doubles
	if (cor.length == 3) {
	    for (int i = 0; i < cors.length; i++){
                coordinate[i] = cors[i];        
	    }
	}
    }

    /*==================================================
      Accessor method: double[] getCor()
      post: returns the coordinate array
      ==================================================*/
    public double[] getCor() {
        return coordinate; 
    }
    
    /*==================================================
      Accessor method: double[] getCor(int n) where 0 <= n <= 3
      post: returns the nth double of the coordinate array 
      ==================================================*/
    public double getCor(int n) {
        return coordinate[n];
    }

    /*==================================================
      String toString() -- iterates through the coordinate array 
      post: to print out the coordinate like this: [xcor, ycor, zcor]
      ==================================================*/ 
    public String toString() {
        String ans= "[";
        for (double i : coordinate) {
            ans += i + ", "; 
        }
        ans = ans.substring(0, ans.length() - 2);
        ans += "]";
        return ans;
    }


    /*==================================================
      double[] getProjectedCoord(double, double, double, double, double[], double[])
      pre: 
      post: returns double[] of projected coordinates
      ==================================================*/
    public double[] getProjectedCoord(double xTheta, double yTheta, double zTheta, double zoom, double[] max, double[] min) {
        double[] coordinate2 = new double[3]; 
        coordinate2[2] = coordinate[0] - (min[0]);// - min[0]) / 2;
        coordinate2[1] = coordinate[1] - (min[1]);// - min[1]) / 2;
        coordinate2[0] = coordinate[2] - (min[2]);// - min[2]) / 2;

        double x = Math.pow(Math.abs(Math.pow(coordinate2[0],2)+Math.pow(coordinate2[1],2)), 0.5) * Math.sin(zTheta + Math.atan((coordinate2[1]+0.000000000000000314)/coordinate2[0]+0.000000000000000314)); 
        double y = Math.pow(Math.abs(Math.pow(coordinate2[0],2)+Math.pow(coordinate2[1],2)), 0.5) * Math.cos(zTheta + Math.atan((coordinate2[1]+0.000000000000000314)/coordinate2[0]+0.000000000000000314));
        
        x = x;
        y = y;
        double z = coordinate2[2];

        y = Math.pow(Math.abs(Math.pow(y,2)+Math.pow(z,2)), 0.5) * Math.sin(yTheta + Math.atan((y+0.000000000000000314)/z+0.000000000000000314)); 
        z = Math.pow(Math.abs(Math.pow(y,2)+Math.pow(z,2)), 0.5) * Math.cos(yTheta + Math.atan((y+0.000000000000000314)/z+0.000000000000000314));
      
        /*
        double y4 = Math.pow(Math.abs(Math.pow(y2,2)+Math.pow(z3,2)), 0.5) * Math.sin(xTheta + Math.atan((z3+0.000000000000000314)/y2+0.000000000000000314)); 
        double z4 = Math.pow(Math.abs(Math.pow(y2,2)+Math.pow(z3,2)), 0.5) * Math.cos(xTheta + Math.atan((z3+0.000000000000000314)/y2+0.000000000000000314));
        */

        double[] ans = new double[2];
        ans[0] = x * 0.5 * zoom; //xcor
        ans[1] = y * 0.5 * zoom * -1; //ycor
        
        return ans;
    }// end getProjectedCoords

} //end Coordinate class


