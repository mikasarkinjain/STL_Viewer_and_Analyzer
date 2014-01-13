public class FileContent{

String File;
double[][][] Data;

public FileContent(String filePath){
  //Should get contents of file at filePath
  //Instead:
  File = "KJHKJHKJHJ";
}

public double[][][] getFileData(){
  if (Data.equals(null)) {
    //turn String File into 3D array that looks like:
    //[  [  [x y z] [x y z] [x y z] ]   [ [x y z] [x y z] [x y z] ]   [ [x y z] [x y z] [x y z] ] ... ]
  }
  else {return Data;}
}


}
