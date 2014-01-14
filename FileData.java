public class FileContent{

String File;
double[][][] Data;

public FileContent(String filePath){
  File = readFile(filePath, StandardCharsets.UTF_8);
  
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

public double[][][] getFileData(){
  if (Data.equals(null)) {
    
    //turn String File into 3D array that looks like:
    //[  [  [x y z] [x y z] [x y z] ]   [ [x y z] [x y z] [x y z] ]   [ [x y z] [x y z] [x y z] ] ... ]
    
    String[] a = File.split("outer loop");
    String [a.length -1] b = new String[];
    for (int i = 1; i < a.length; i ++){
      b[i] = a[i].split("endloop")[0];
    }
    
    // at this point, all elements of b look like:
    /* 
         vertex 0.000000e+000 1.000000e+002 1.000000e+002
         vertex 0.000000e+000 1.000000e+002 0.000000e+000
         vertex 0.000000e+000 0.000000e+000 1.000000e+002
    */
    String [][] c = new String[][];
    for (int i = 0; i < b.length; i ++){
      c[i] = c[i].split("\\s+"); //Splits on any witespace
    }  
    
    for (int i = 0; i < c.length; i ++){
      String[] newElementOfC = new String[9];
      newElementOfC = c[i][1];
      newElementOfC = c[i][2];
      newElementOfC = c[i][3];
      newElementOfC = c[i][5];
      newElementOfC = c[i][6];
      newElementOfC = c[i][7];
      newElementOfC = c[i][9];
      newElementOfC = c[i][10];
      newElementOfC = c[i][11];
      c[i] = newElementOfC;
    }  // this for loop removes all instances of the word "vertex"
    
    for (int i = 0; i < c.length; i ++){
      for (int j = 0; j < c[i].length; j++){
        c[i] = c[i].split("e")[0];
      }
    }
    
    Data = new double[c.length][3][3];
    for (int i = 0; i < Data.length; i++){
      for (int j = 0; j < 3; j++){
        for (int k = 0; k < 3; k++){
          Data[i][j][k] = Double.parseDouble(c[i][j][k]);
        }
      }
    }
  
  }
  
  else {return Data;}
}


}
