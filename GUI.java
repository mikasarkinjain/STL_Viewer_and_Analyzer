// Team Double A
// Period 8 
// STL Viewer and Analyzer

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

class GUI extends JFrame{

    private double xTheta = 0;
    private double yTheta = 0;
    private double zTheta = 0;

    private double zoom = 1;

    private String path;
    private FileData file; 
    private double[][][] fileCoords;
    //fileCoords in form: [[x1, y1, z1, x2, y2, z2, x3, y3, z3], [x1, y1, z1, x2, y2, z2, x3, y3, z3] ... ]
    private TriangleObject TriangleObj;

    public GUI(){
        /*
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showDialog(GUI.this, "Choose an ASCII STL");
        path = fc.getSelectedFile().getAbsolutePath();
        file = new FileData(path); 
        fileCoords = file.getFileData();
        TriangleObj = new TriangleObject(fileCoords);
        */

        setTitle("STL VIEWER & ANALYZER"); 
        setLocation(200,75); 
        setSize(600,500); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 

        JPanel panel = new JPanel();
        getContentPane().add(panel);


        JButton button1 = new JButton("^");
        JButton button2 = new JButton("v");
        JButton button3 = new JButton("<");
        JButton button4 = new JButton(">");

        JButton button5 = new JButton("+");
        JButton button6 = new JButton("-");

        JButton button7 = new JButton("IMPORT STL");
        JButton button8 = new JButton("ANALYZE STL");

        button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {
            yTheta -= 0.25;
            refresh();
            }
        });   

        button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {
            yTheta += 0.25;
            refresh();
            }
        }); 

        button3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {
            zTheta -= 0.25;
            refresh();
            }
        }); 

        button4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {
            zTheta += 0.25;
            refresh();
            }
        }); 

        button5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {
            zoom *= 7.0/6;
            refresh();
            }
        }); 

        button6.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {
            zoom *= 6.0/7;
            refresh();
            }
        }); 

        button7.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showDialog(GUI.this, "Choose an ASCII STL");
            path = fc.getSelectedFile().getAbsolutePath();
            file = new FileData(path); 
            fileCoords = file.getFileData();
            TriangleObj = new TriangleObject(fileCoords);
            refresh();
            }
        });  

        button8.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {
            JOptionPane.showMessageDialog(null, "Width: " + (TriangleObj.getMax()[0] - TriangleObj.getMin()[0]) + " units"
                                              + "\nLength: " + (TriangleObj.getMax()[1] - TriangleObj.getMin()[1]) + " units" 
                                              + "\nHeight: " + (TriangleObj.getMax()[2] - TriangleObj.getMin()[2]) + " units" 
                                              + "\nNumber of Facets: " + file.getFileData().length, "STL ANALYSIS", JOptionPane.INFORMATION_MESSAGE);
            }
        });   

        button1.setPreferredSize(new Dimension(50, 25));
        button2.setPreferredSize(new Dimension(50, 25));
        button3.setPreferredSize(new Dimension(50, 25));
        button4.setPreferredSize(new Dimension(50, 25));
        button5.setPreferredSize(new Dimension(50, 25));
        button6.setPreferredSize(new Dimension(50, 25));    

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
    }

    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2 = (Graphics2D) g;

        this.project3DObject(g, g2);

    }

    public void project3DObject(Graphics g, Graphics2D g2){ //this method exists to reduce refresh time of display
        super.paint(g); 
        double[][][] projectedCoords = TriangleObj.getProjected3DObject(xTheta, yTheta, zTheta, zoom);
        //projectedCoords in form: [ [ [x1, y1] , [x2, y2] , [x3, y3] ] , [ [x1, y1] , [x2, y2] , [x3, y3] ],  ... ]

        for (int i = 0; i < projectedCoords.length; i++){
            Line2D line1 = new Line2D.Float((float)(projectedCoords[i][0][0]+3)*100,(float)(projectedCoords[i][0][1]+3)*100, (float)(projectedCoords[i][1][0]+3)*100, (float)(projectedCoords[i][1][1]+3)*100);
            Line2D line2 = new Line2D.Float((float)(projectedCoords[i][1][0]+3)*100, (float)(projectedCoords[i][1][1]+3)*100, (float)(projectedCoords[i][2][0]+3)*100, (float)(projectedCoords[i][2][1]+3)*100);
            Line2D line3 = new Line2D.Float((float)(projectedCoords[i][2][0]+3)*100, (float)(projectedCoords[i][2][1]+3)*100, (float)(projectedCoords[i][0][0]+3)*100, (float)(projectedCoords[i][0][1]+3)*100);
            g2.draw(line1);
            g2.draw(line2);
            g2.draw(line3);

            /*
            System.out.println((float)projectedCoords[i][0][0] + "," + (float)projectedCoords[i][0][1]  + "," + (float)projectedCoords[i][1][0]  + "," + (float)projectedCoords[i][1][1]);
            System.out.println((float)projectedCoords[i][0][0] + "," + (float)projectedCoords[i][0][1]  + "," + (float)projectedCoords[i][2][0]  + "," + (float)projectedCoords[i][2][1]);
            System.out.println((float)projectedCoords[i][1][0] + "," + (float)projectedCoords[i][1][1]  + "," + (float)projectedCoords[i][2][0]  + "," + (float)projectedCoords[i][2][1]);
            System.out.println("-");
            System.out.println(xTheta);
            System.out.println(yTheta);
            System.out.println(zTheta);
            System.out.println("-");
            */
        }

        /*Line2D lin = new Line2D.Float((int)xTheta%500, 100, 250, 260);
        Line2D lin2 = new Line2D.Float(200, 100, 250, 260);

        g2.draw(lin);
        g2.draw(lin2);*/

/*        try {
            Thread.sleep(400);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
            }*/

        //UNCOMMENT LINE BELOW TO ENABLE RECURSIVE UPDATING
        //this.project3DObject(g, g2);

    }

    public void refresh() {
        this.paint(this.getGraphics());
    }

    public static void main(String []args){
        GUI gui = new GUI();
        gui.setVisible(true);
    }
}

