import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.Serial;
import java.util.ArrayList;
import javax.swing.JFrame;
import uk.ac.leedsbeckett.mullier.sesc.*;
public class TheApplication extends JFrame{
	
	/**
	 * example of Dependency Injection
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	final int XSIZE = 640, YSIZE = 480;
	int headX = 10, headY = 50, headXsize = 150, headYsize = 130;
	int eyeX = headX+(headXsize/4), eyeY, eyeSize = headXsize /10, eyeGap = headXsize/3;
	int mouthX = eyeX,  mouthY = eyeY + headY, mouthXsize = eyeSize*3, mouthYsize = eyeSize;
	 ArrayList<Object> Shapes;
	
	
	public TheApplication(Shape head, Shape lefteye, Shape righteye, Shape mouth)
	{
		setPreferredSize(new Dimension(XSIZE, YSIZE));
		pack();
		setVisible(true);
		
		Color col;
		//head		
		col = new Color(255, 0, 0);
        head.set(col, headX, headY, headXsize, headYsize);
        Shapes = new ArrayList<>();
        Shapes.add(head);
			
        //left eye white          
        col = new Color(255, 255, 255);
        eyeY = headY+(headYsize/5);
        lefteye.set(col, eyeX, eyeY, eyeSize);
        Shapes.add(lefteye);
			
        //right eye white      
        col = new Color(255, 255, 255);
        righteye.set(col, eyeX+eyeGap, eyeY, eyeSize);
        Shapes.add(righteye);
			
        //mouth       
        col = new Color(0,0,0);
        mouth.set(col, mouthX, mouthY, mouthXsize, mouthYsize);
        Shapes.add(mouth);	
	}
	
	public void paint(Graphics g)
	{
        for (Object shape : Shapes) {
            Shape s;
            s = (Shape) shape;
            if (s != null) {
                s.draw(g);
                System.out.println(s);
            } else
                System.out.println("invalid Shape in array"); //shouldn't happen as factory does not produce rubbish

        }
		g.setColor(Color.BLACK);
		g.drawString("Shape Example with  DI", 100, 100);
		
	}
}

