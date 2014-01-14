// Team Double A
// Period 8
// STL Viewer and Analyzer

public class Coordinate {

    private double[] coordinate = new double[3];
    
    public Coordinate(double[] cors) {
	for (int i = 0; i < 3; i++){
		coordinate[i] = cors[i];	
	}
    }

    public String toString() {
	String ans= "[";
	for (double i : coordinate) {
	    ans += i + " "; 
	}
	ans += "]";
	return ans;
    }

    public double[] getCor() {
	return coordinate; 
    }

    public double[] getProjectedCoord() {
	double[] ans = new double[2];
	ans[0] = coordinate[0]; //xcor
	ans[1] = coordinate[1]; //ycor
	// projecting math here:
	// ans[2] = ?
	return ans;
    }
}
