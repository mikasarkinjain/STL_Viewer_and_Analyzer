// Team Double A
// Period 8
// STL Viewer and Analyzer

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileData{
    
    //instance vars of class FileData
    String File;
    double[][][] Data;

   /*==================================================
     constructor -- initializes a FileData object, uses readFile method to assign a string to String File
     pre:
     post: Variable String File contains contents of the stl file with the input name
     ==================================================*/
    public FileData(String filePath){
	File = readFile(filePath);
  
	/* HERE IS A SAMPLE OF THE FILE CONTENT IN THE FORM OF:
	   solid block100
	   facet normal -1.000000e+000 0.000000e+000 0.000000e+000 //THIS DOES NOT MATTER FOR ANYTHING
	   outer loop
	   vertex 0.000000e+000 1.000000e+002 1.000000e+002
	   vertex 0.000000e+000 1.000000e+002 0.000000e+000
	   vertex 0.000000e+000 0.000000e+000 1.000000e+002
	   endloop
	   endfacet
	   facet normal -1.000000e+000 0.000000e+000 0.000000e+000 //THIS DOES NOT MATTER FOR ANYTHING
	   outer loop
	   vertex 0.000000e+000 0.000000e+000 1.000000e+002
	   vertex 0.000000e+000 1.000000e+002 0.000000e+000
	   vertex 0.000000e+000 0.000000e+000 0.000000e+000
	   endloop
	   endfacet
	   endsolid
	*/
	//NOTE: Only the numbers with vertex at the front matter, the numbers after the "e" don't matter.
    }
    
    /*==================================================
      String readFile( String ) -- accesses information in a file
      pre:
      post: returns a String with information from files
      ==================================================*/
    	public String readFile(String filename) {
	String content = null;
	File file = new File(filename); //for ex foo.txt
	try {
	    FileReader reader = new FileReader(file);
	    char[] chars = new char[(int) file.length()];
	    reader.read(chars);
	    content = new String(chars);
	    reader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return content;
    }
    
   /*==================================================
     double[][][] getFileData() -- removes unnecessary information in String file and turns the String file into a 3D array
     that looks like: [  [  [x y z] [x y z] [x y z] ]   [ [x y z] [x y z] [x y z] ]   [ [x y z] [x y z] [x y z] ] ... ]
     pre:
     post: returns a 3D array with coordinates for all vertexes of the model
     ==================================================*/
    public double[][][] getFileData() {
	
	//STEP1    
	String[] a = File.split("outer loop");
	String [] b = new String[a.length -1];
	for (int i = 1; i < a.length; i ++){
	    //System.out.println(a[i]); //WORKING
	    b[i-1] = a[i].split("endloop")[0];
    	    //System.out.println(b[i-1]); //WORKING
	}
    
	// at this point, all elements of b look like:
	/* 
	   vertex 0.000000e+000 1.000000e+002 1.000000e+002
	   vertex 0.000000e+000 1.000000e+002 0.000000e+000
	   vertex 0.000000e+000 0.000000e+000 1.000000e+002
	*/
	//b.length = 12 
	
	
	//STEP 2 -- removing witespace from b and storing each string as an element of double[][] c
	String[][] c = new String[b.length][12];
	for (int i = 0; i < b.length; i ++){
	    c[i] = b[i].split("\\s+");//Splits on any witespace
	    //System.out.println(c[i][i]);
	}
	/* 
	for (int i = 0; i < 13; i++){
	    System.out.println(i + " : " + c[1][i]);	
	}
	//c looks correct
	*/


	//STEP 3 -- removing "vertex" element in c so we only have the numbers
	for (int i = 0; i < c.length; i ++){
	    //c[i][1], c[i][5], c[i][9] contains vertex
	    String[] newElementOfC = new String[9];
	    newElementOfC[0] = c[i][2];
	    newElementOfC[1] = c[i][3];
	    newElementOfC[2] = c[i][4];
	    newElementOfC[3] = c[i][6];
	    newElementOfC[4] = c[i][7];
	    newElementOfC[5] = c[i][8];
	    newElementOfC[6] = c[i][10];
	    newElementOfC[7] = c[i][11];
	    newElementOfC[8] = c[i][12];
	    // for (int p = 0; p < 9; p++){
	    //System.out.println(newElementOfC[p]);
	    //}
	    c[i] = newElementOfC;
	    //WORKING
	    //for (int k = 0; k < 9; k++) {
	    //	System.out.println(k + " : " + c[i][k]);	
	    //}
	}  // this for loop removes all instances of the word "vertex"
	
	// ERROR AFTER EXITING THE FOR LOOP
	/* WORKING
	for (int i = 0; i < c.length; i++) {
		for (int m = 0; m < 9; m++){

		System.out.println(m + " : " + c[i][m]);	

		}
	}
	*/
	
	
	//STEP 4 -- removes all characters after the "e" in each element
	for (int i = 0; i < c.length; i ++){
	    for (int j = 0; j < c[i].length; j++){
		c[i][j] = c[i][j].split("e")[0];
	    }
	}
    	/* WORKING
	for (int l = 0 ; l < c.length; l++){
	    for (int i = 0; i < 9; i++){

		System.out.println(i + " : " + c[l][i]);	

	    }
	}
	*/


	//STEP 5 - separate the elements into double[][][] Data
	Data = new double[c.length][3][3];
	for (int i = 0; i < c.length; i++){
	    for (int j = 0; j < 3; j++){
		for (int k = 0; k < 3; k++){
		    Data[i][j][k] = Double.parseDouble(c[i][j*3+k]);
		    //System.out.println(Data[i][j][k]); //WORKING CORRECTLY
		    //Double.parseDouble(String s) returns a new double initialized to the value represented by the specified String
		    
		}
	    }
	}
	// WORKING
	/*
	for (int i = 0; i < Data.length; i++){
	    for (int j = 0; j < 3; j++) {
		for (int k = 0; k < 3; k++){
		    System.out.println(Data[i][j][k]);
		}
	    }
	}
	*/
	return Data;
    } // end getFileData method

}// end FileData class
