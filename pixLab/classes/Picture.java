import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////
  
    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
	/* not needed but use it to show students the implicit call to super()
	 * child constructors always call a parent constructor 
	 */
	super();  
    }
  
    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
	// let the parent class handle this fileName
	super(fileName);
    }
  
    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
	// let the parent class handle this width and height
	super(width,height);
    }
  
    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
	// let the parent class do the copy
	super(copyPicture);
    }
  
    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
	super(image);
    }
  
    ////////////////////// methods ///////////////////////////////////////
  
    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
	String output = "Picture, filename " + getFileName() + 
	    " height " + getHeight() 
	    + " width " + getWidth();
	return output;
    
    }
  
    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
	Pixel[][] pixels = this.getPixels2D();
	for (Pixel[] rowArray : pixels)
	    {
		for (Pixel pixelObj : rowArray)
		    {
			pixelObj.setBlue(0);
		    }
	    }
    }
  
    public void keepOnlyBlue() 
    {
	Pixel[][] p = this.getPixels2D();
	for (Pixel[] i : p){
	    for (Pixel j : i) {
		j.setRed(0);
		j.setGreen(0);
	    }
	}
    }

    public void negate() {
	Pixel[][] p = this.getPixels2D();
	for (Pixel[] i : p) {
	    for (Pixel j : i) {
		j.setRed(j.getRed() - 255);
		j.setGreen(j.getGreen() - 255);
		j.setBlue(j.getBlue() - 255);
	    }
	}
    }

    public void grayscale() {
	Pixel[][] p = this.getPixels2D();
	for (Pixel[] i : p) {
	    for (Pixel j : i) {
		int avg = (int) ( (j.getRed() + j.getGreen() + j.getBlue()) / 3);
		j.setRed(avg);
		j.setBlue(avg);
		j.setGreen(avg);
	    }}}
  
  
    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVerticalRightToLeft()
    {
	Pixel[][] pixels = this.getPixels2D();
	Pixel leftPixel = null;
	Pixel rightPixel = null;
	int width = pixels[0].length;
	for (int row = 0; row < pixels.length; row++)
	    {
		for (int col = 0; col < width / 2; col++)
		    {
			leftPixel = pixels[row][col];
			rightPixel = pixels[row][width - 1 - col];
			leftPixel.setColor(rightPixel.getColor());
		    }
	    }
    }
  
    public void mirrorVertical()
    {
	Pixel[][] pixels = this.getPixels2D();
	Pixel leftPixel = null;
	Pixel rightPixel = null;
	int width = pixels[0].length;
	for (int row = 0; row < pixels.length; row++)
	    {
		for (int col = 0; col < width / 2; col++)
		    {
			leftPixel = pixels[row][col];
			rightPixel = pixels[row][width - 1 - col];
			rightPixel.setColor(leftPixel.getColor());
		    }
	    } 
    }
  
    public void mirrorHorizontal()
    {
	Pixel[][] pixels = this.getPixels2D();
	Pixel topPixel = null;
	Pixel bottomPixel = null;
	int height = pixels.length;
	for (int row = 0; row < height; row++)
	    {
		for (int col = 0; col < pixels[0].length; col++)
		    {
			topPixel = pixels[row][col];
			bottomPixel = pixels[height - 1 - row][col];
			bottomPixel.setColor(topPixel.getColor());
		    }
	    }
    }
  
    public void mirrorHorizontalBottomToTop()
    {
	Pixel[][] pixels = this.getPixels2D();
	Pixel topPixel = null;
	Pixel bottomPixel = null;
	int height = pixels.length;
	for (int row = 0; row < height; row++)
	    {
		for (int col = 0; col < pixels[0].length; col++)
		    {
			topPixel = pixels[row][col];
			bottomPixel = pixels[height - 1 - row][col];
			topPixel.setColor(bottomPixel.getColor());
		    }
	    }
    }
  
    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
 
	int mirrorPoint = 276;
	Pixel leftPixel = null;
	Pixel rightPixel = null;
	int count = 0;
	Pixel[][] pixels = this.getPixels2D();
    
	// loop through the rows
	for (int row = 27; row < 97; row++)
	    {
		// loop from 13 to just before the mirror point
		for (int col = 13; col < mirrorPoint; col++)
		    {
        
			leftPixel = pixels[row][col];      
			rightPixel = pixels[row]                       
			    [mirrorPoint - col + mirrorPoint];
			rightPixel.setColor(leftPixel.getColor());
			count+=1;
		    }
		System.out.println(count);
	    }
    }

    public void mirrorArms() {
	int mirrorPoint = 193;
	Pixel topPixel = null;
	Pixel bottomPixel = null;
	Pixel[][] pixel = this.getPixels2D();

	for (int i = 158; i<mirrorPoint; i++) {
	    for (int j = 103; j<170; j++){
		topPixel = pixel[i][j];
		int x = mirrorPoint - i + mirrorPoint;
		bottomPixel = pixel[x][j];
		bottomPixel.setColor(topPixel.getColor());
	    }}
	int mirrorPoint2 = 198;
	Pixel topPixel2 = null;
	Pixel bottomPixel2 = null;

	for (int k=171; k<mirrorPoint2; k++){
	    for (int l= 239; l<294; l++){
		topPixel2=pixel[k][l];
		int x2 = mirrorPoint2 - k + mirrorPoint2;
		bottomPixel2 = pixel[x2][l];
		bottomPixel2.setColor(topPixel2.getColor());}}}

    public void mirrorGull(){
	int mirrorPoint = 345;
	Pixel right = null;
	Pixel left = null;
	Pixel[][] pixels = this.getPixel2D();

	for (int i = 235; i < 323; i++){
	    for (int j = 238; j < mirrorPoint; j++) {
		right = pixels[i][j];
		left = pixels[i][mirrorPoint - j + mirrorPoint];
		left.setColor(right.getColor());}}}

    
		

    
  
    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
		     int startRow, int startCol)
    {
	Pixel fromPixel = null;
	Pixel toPixel = null;
	Pixel[][] toPixels = this.getPixels2D();
	Pixel[][] fromPixels = fromPic.getPixels2D();
	for (int fromRow = 0, toRow = startRow; 
	     fromRow < fromPixels.length &&
		 toRow < toPixels.length; 
	     fromRow++, toRow++)
	    {
		for (int fromCol = 0, toCol = startCol; 
		     fromCol < fromPixels[0].length &&
			 toCol < toPixels[0].length;  
		     fromCol++, toCol++)
		    {
			fromPixel = fromPixels[fromRow][fromCol];
			toPixel = toPixels[toRow][toCol];
			toPixel.setColor(fromPixel.getColor());
		    }
	    }   
    }

    public void copy2(Picture fromPic, int startRow, int endRow, int startCol, int endCol)
    {
	Pixel fromPixel = null;
	Pixel toPixel = null;
	Pixel[][] toPixels = this.getPixels2D();
	Pixel[][] fromPixels = fromPic.getPixels2D();
	for (int fromRow = startRow, toRow = endRow; 
	     fromRow < fromPixels.length &&
		 toRow < toPixels.length; 
	     fromRow++, toRow++)
	    {
		for (int fromCol = startCol, toCol = endCol; 
		     fromCol < fromPixels[0].length &&
			 toCol < toPixels[0].length;  
		     fromCol++, toCol++)
		    {
			fromPixel = fromPixels[fromRow][fromCol];
			toPixel = toPixels[toRow][toCol];
			toPixel.setColor(fromPixel.getColor());
		    }
	    }
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
	Picture flower1 = new Picture("flower1.jpg");
	Picture flower2 = new Picture("flower2.jpg");
	this.copy(flower1,0,0);
	this.copy(flower2,100,0);
	this.copy(flower1,200,0);
	Picture flowerNoBlue = new Picture(flower2);
	flowerNoBlue.zeroBlue();
	this.copy(flowerNoBlue,300,0);
	this.copy(flower1,400,0);
	this.copy(flower2,500,0);
	this.mirrorVertical();
	this.write("collage.jpg");
    }
  
  
    public void createCollage2(){
	Picture flower1 = new Picture("flower1.jpg");
	Picture flower2 = new Picture("flower2.jpg");
	this.copy2(flower1,20,40,20,40);
	this.copy2(flower2,20,40,20,40);
	this.copy2(flower1,30,50,40,80);
	Picture flowerNoBlue = new Picture(flower2);
	flowerNoBlue.zeroBlue();
	this.copy2(flowerNoBlue,30,300,20,100);
	this.copy2(flower1,300,400,300,400);
	this.copy2(flower2,40,500,30,500);
	this.mirrorVertical();
	this.write("collage1.jpg");
	
    }


    public void createMyCollage(){
	Picture koala1 = new Picture("koala.jpg");
	Picture koala2 = new Picture("koala.jpg");
	Picture koala3 = new Picture("koala.jpg");
	this.copy2(koala1,400,480,400,480);
	this.copy(koala2,420,420);
	this.copy2(koala3,20,100,20,100);
	Picture k1= new Picture(koala1);
	Picture k2= new Picture(koala2);
	Picture k3= new Picture(koala3);
	k1.mirrorVertical();
	k2.zeroBlue();
	k3.negate();
	this.write("collage2.jpg");
    }
    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
	Pixel leftPixel = null;
	Pixel rightPixel = null;
	Pixel[][] pixels = this.getPixels2D();
	Color rightColor = null;
	Pixel lowerPixel=null;
	Pixel upperPixel=null;
	Color lowerColor = null;
	/*
	for (int row = 0; row < pixels.length; row++)
	    {
		for (int col = 0; 
		     col < pixels[0].length-1; col++)
		    {
			leftPixel = pixels[row][col];
			rightPixel = pixels[row][col+1];
			rightColor = rightPixel.getColor();
			if (leftPixel.colorDistance(rightColor) > 
			    edgeDist)
			    leftPixel.setColor(Color.BLACK);
			else
			    leftPixel.setColor(Color.WHITE);
		    }
	    }
*/
	for (int row = 0; row < pixels[0].length-1; row++)
	    {
		for (int col = 0; 
		     col < pixels[0].length-1; col++)
		    {
			upperPixel = pixels[row][col];
			lowerPixel = pixels[row+1][col];
			lowerColor = lowerPixel.getColor();
			if (upperPixel.colorDistance(lowerColor) > 
			    edgeDist)
			    upperPixel.setColor(Color.BLACK);
			else
			    upperPixel.setColor(Color.WHITE);
		    }
	    }
    }
  
  
    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
	Picture beach = new Picture("beach.jpg");
	beach.explore();
	beach.zeroBlue();
	beach.explore();
    }
  
} // this } is the end of class Picture, put all new methods before this
