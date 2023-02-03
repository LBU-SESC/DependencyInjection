import uk.ac.leedsbeckett.mullier.sesc.*;

public class ShapeProgram {
	
	public static void main(String[] args) {
		//create all the objects (dependencies)
		Rectangle head = new Rectangle();
		Circle lefteye = new Circle();
		Circle righteye = new Circle();
		Ellipse mouth = new Ellipse();
		//inject them into the class that needs them
		TheApplication app = new TheApplication(head, lefteye, righteye, mouth);
	}
}
