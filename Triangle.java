// Team Double A
// Period 8
// STL Viewer and Analyzer 

public class Triangle {

    private ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
    
    public Triangle (Coordinate cor1, Coordinate cor2, Coordinate cor3 ) {
	coordinates.add(cor1);
	coordinates.add(cor2);
	coordinates.add(cor3);
    }

    public String toString() {
	return coordinates;
    }

    public Coordinate getCor(int n) {
	return coordinates.get(n-1); 
    }

    public double[] projectCor(int n) {
	return (coordinates.get(n-1)).projectedCor();
    }
}
