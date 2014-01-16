// Team Double A
// Period 8 
// STL Viewer and Analyzer

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class GUI extends JFrame{

    private double xTheta = 0.0;
    private double yTheta = 0.0;
    private double zTheta = 0.0;

    private String path = "samplecube.stl";
    private FileData file = new FileData(path); 
    private double[][][] fileCoords = file.getFileData();
    //fileCoords in form: [[x1, y1, z1, x2, y2, z2, x3, y3, z3], [x1, y1, z1, x2, y2, z2, x3, y3, z3] ... ]
    private TriangleObject TriangleObj = new TriangleObject(fileCoords);


    public GUI(){
        setTitle("STL VIEWER & ANALYZER"); 
        setLocation(100,100); 
        setSize(600,400); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JButton button = new JButton("UPLOAD STL");
        JButton button2 = new JButton("STL DATA");

        panel.add(button);
        panel.add(button2);
    }

    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2 = (Graphics2D) g;

        this.project3DObject(g, g2);

    }

    public void project3DObject(Graphics g, Graphics2D g2){ //this method exists to reduce refresh time of display
        super.paint(g); 
        double[][][] projectedCoords = TriangleObj.getProjected3DObject(xTheta, yTheta, zTheta);
        //projectedCoords in form: [ [ [x1, y1] , [x2, y2] , [x3, y3] ] , [ [x1, y1] , [x2, y2] , [x3, y3] ],  ... ]

        for (int i = 0; i < projectedCoords.length; i++){
            Line2D line1 = new Line2D.Float((float)projectedCoords[i][0][0],(float)projectedCoords[i][0][1], (float)projectedCoords[i][1][0], (float)projectedCoords[i][1][1]);
            Line2D line2 = new Line2D.Float((float)projectedCoords[i][1][0], (float)projectedCoords[i][1][1], (float)projectedCoords[i][2][0], (float)projectedCoords[i][2][1]);
            Line2D line3 = new Line2D.Float((float)projectedCoords[i][2][0], (float)projectedCoords[i][2][1], (float)projectedCoords[i][0][0], (float)projectedCoords[i][0][1]);
            g2.draw(line1);
            g2.draw(line2);
            g2.draw(line3);

        }
        

        xTheta += 10;
        yTheta += 10;
        zTheta += 10;
        
        /*Line2D lin = new Line2D.Float((int)xTheta%500, 100, 250, 260);
        Line2D lin2 = new Line2D.Float(200, 100, 250, 260);

        g2.draw(lin);
        g2.draw(lin2);*/

        try {
            Thread.sleep(400);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
            }

        this.project3DObject(g, g2);

    }

    public static void main(String []args){
        GUI gui = new GUI();
        gui.setVisible(true);
    }
}
