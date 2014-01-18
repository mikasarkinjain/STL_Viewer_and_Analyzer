// Team Double A
// Period 8
// STL Viewer and Analyzer

public class Coordinate {

    private double[] coordinate = new double[3];
    
    //constructor initializes instance variables in coordinate
    public Coordinate(double[] cors) {
	for (int i = 0; i < cors.length; i++){
	    coordinate[i] = cors[i];	
	}
    }

    // toString method to print the array of coordinates
    public String toString() {
	String ans= "[";
	for (double i : coordinate) {
	    ans += i + ", "; 
	}
	ans = ans.substring(0, ans.length() - 2);
	ans += "]";
	return ans;
    }

    //Method to get all coordinates (x, y, and z)
    public double[] getCor() {
	return coordinate; 
    }


    //Method to get a certain coordinate(x, y, or z)
    public double getCor(int n) {
	return coordinate[n];
    }

	public double[] getProjectedCoord(double xTheta, double yTheta, double zTheta) {
	
	double x2 = Math.pow(Math.pow(coordinate[0],2)+Math.pow(coordinate[1],2), 0.5) * Math.sin(zTheta + Math.atan(coordinate[1]/coordinate[0])); 
	double y2 = Math.pow(Math.pow(coordinate[0],2)+Math.pow(coordinate[1],2), 0.5) * Math.cos(zTheta + Math.atan(coordinate[1]/coordinate[0]));
	
	double x3 = Math.pow(Math.pow(x2,2)+Math.pow(coordinate[2],2), 0.5) * Math.sin(yTheta + Math.atan(coordinate[2]/x2)); 
	double z3 = Math.pow(Math.pow(x2,2)+Math.pow(coordinate[2],2), 0.5) * Math.cos(yTheta + Math.atan(coordinate[2]/x2));
	
	double y4 = Math.pow(Math.pow(y2,2)+Math.pow(z3,2), 0.5) * Math.sin(xTheta + Math.atan(z3/y2)); 
	double z4 = Math.pow(Math.pow(y2,2)+Math.pow(z3,2), 0.5) * Math.cos(xTheta + Math.atan(z3/y2));

	double[] ans = new double[2];
	ans[0] = x3; //xcor
	ans[1] = y4; //ycor
	
	return ans;
    }
}
