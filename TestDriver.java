// Team Double A
// Period 8
// STL Viewer and Analyzer

public class TestDriver {

    public static void main ( String[] args ) {
    
	/*
	//Testing Coordinate Class
	System.out.println("TESTING COORDINATE CLASS \n");
	double[] x = { 0.0, 1.0, 2.0 };
	Coordinate c1 = new Coordinate( x );
	System.out.println("Coordinates of c1: \n" + c1); //test toString
	double [] get = c1.getCor(); //test getCor
	Coordinate getc1 = new Coordinate( get );
	System.out.println("Getting the coordinates of c1: \n" + getc1);
	double[] p = c1.getProjectedCoord(); //test getProjectedCoord
	System.out.println("Projected xcor of c1: " + p[0] );
	System.out.println("Projected ycor of c1: " + p[1] );

	//Testing Triangle Class
	System.out.println("\nTESTING TRIANGLE CLASS \n");
	double[][] x2 = {{0.0, 1.0, 2.0} , {1.0, 2.0, 3.0} , {2.0, 3.0, 4.0} };
	Triangle t1 = new Triangle(x2);
	System.out.println("Printing Coordinates of t1: \n" + t1); 
	//test toString

	//testing getCor (1,2,3)
	System.out.println("first coordinate of t1: \n" + t1.getCor(0));
	System.out.println("second coordinate of t1: \n" + t1.getCor(1));
	System.out.println("third coordinate of t1: \n" + t1.getCor(2));
	//testing getProjectedTriangle
	double[][] pt =  t1.getProjectedTriangle(0.0, 0.0, 0.0);
	Triangle projectedt = new Triangle(pt);
	System.out.println("projected t1: " + projectedt );
	
	// Testing TriangleObject Class
	System.out.println("\nTESTING TRIANGLEOBJECT CLASS \n");
	double[][][] x3 = { { {1.0, 1.0, 1.0} , {1.0, 1.0, 1.0} , {1.0, 1.0, 1.0} },
			    { {2.0, 2.0, 2.0} , {2.0, 2.0, 2.0} , {2.0, 2.0, 2.0} },
			    { {3.0, 3.0, 3.0} , {3.0, 3.0, 3.0} , {3.0, 3.0, 3.0} } };	
	TriangleObject o1 = new TriangleObject(x3);//testing toString
	System.out.println("Printing 3DObject of o1: \n" + o1); //testing toString
	//testing getTriangle
	System.out.println("Triangles in This Object:");
	for (int i = 0; i < 3; i++) {
	    System.out.println("Triangle " + i + ": " + o1.getTriangle(i));
	}
	//testing getProjected3DObject 
	double[][][] pdo = o1.getProjected3DObject(0.0,0.0,0.0);
	TriangleObject projectedo = new TriangleObject(pdo);
	System.out.println("Projected o1: " + projectedo );
	*/
	//Testing FileData class
	System.out.println("\nTESTING FILEDATA CLASS \n");
	FileData f1 = new FileData("samplecube.stl");
	f1.getFileData();
	/*
	String meow = "1.000000e+002";
	String one = meow.split("e")[0];
	String two = meow.split("e")[1];
	System.out.println(one);
	System.out.println(two);
	*/
    }// end main method
 
}// end TestDriver
