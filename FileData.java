import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileData{

    String File;
    double[][][] Data;

    public FileData(String filePath){
	File = readFile(filePath);
  
	/* FILE CONTENT IN THE FORM OF:
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
	//The numbers after the "e" don't matter either
    }

    public String readFile(String filename)
    {
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

    public double[][][] getFileData(){
	if (Data.equals(null)) {
    
	    //turn String File into 3D array that looks like:
	    //[  [  [x y z] [x y z] [x y z] ]   [ [x y z] [x y z] [x y z] ]   [ [x y z] [x y z] [x y z] ] ... ]
    
	    String[] a = File.split("outer loop");
	    String [] b = new String[a.length -1];
	    for (int i = 1; i < a.length; i ++){
		b[i] = a[i].split("endloop")[0];
	    }
    
	    // at this point, all elements of b look like:
	    /* 
	       vertex 0.000000e+000 1.000000e+002 1.000000e+002
	       vertex 0.000000e+000 1.000000e+002 0.000000e+000
	       vertex 0.000000e+000 0.000000e+000 1.000000e+002
	    */
	    String[][] c = new String[b.length][12];
	    for (int i = 0; i < b.length; i ++){
		c[i] = b[i].split("\\s+"); //Splits on any witespace
	    }  
  
	    for (int i = 0; i < c.length; i ++){
		String[] newElementOfC = new String[9];
		newElementOfC[0] = c[i][1];
		newElementOfC[1] = c[i][2];
		newElementOfC[2] = c[i][3];
		newElementOfC[3] = c[i][5];
		newElementOfC[4] = c[i][6];
		newElementOfC[5] = c[i][7];
		newElementOfC[6] = c[i][9];
		newElementOfC[7] = c[i][10];
		newElementOfC[8] = c[i][11];
		c[i] = newElementOfC;
	    }  // this for loop removes all instances of the word "vertex"
    
	    for (int i = 0; i < c.length; i ++){
		for (int j = 0; j < c[i].length; j++){
		    c[i][j] = c[i][j].split("e")[0];
		}
	    }
    
	    Data = new double[c.length][3][3];
	    for (int i = 0; i < Data.length; i++){
		for (int j = 0; j < 3; j++){
		    for (int k = 0; k < 3; k++){
			//Data[i][j][k] = Double.parseDouble(c[i][j][k]);
		    
		    }

		}
	    }
	    return Data;
  
	}
  
	else {return Data;}
    }
    public static void main (String[] args){
	FileData file = new FileData("samplecube.stl");
	System.out.print(file.getFileData());
    }   
}
