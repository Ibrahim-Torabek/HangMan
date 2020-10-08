import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class HangPane extends Pane {
    private ArrayList<Shape> hangAMan = new ArrayList<>();

    public HangPane() {
        ArrayList<Line> lines = new ArrayList<>();

        lines.add(new Line(50,650,350,650));
        lines.add(new Line(80,650,80,150));
        lines.add(new Line(80,150,250,150));
        lines.add(new Line(250,150,250,250));

        for(Line line: lines){
            line.setStrokeWidth(3);
            this.getChildren().add(line);
        }

        hangAMan.add(new Circle(250,300,50));
        hangAMan.add(new Line(250,350,250,500));
        hangAMan.add(new Line(250,400,200,480));
        hangAMan.add(new Line(250,400,300,480));
        hangAMan.add(new Line(250,500,200,620));
        hangAMan.add(new Line(250,500,300,620));

        for(Shape hang: hangAMan){
            hang.setStrokeWidth(3);
            hang.setFill(null);
            hang.setStroke(Color.BLACK);
            //this.getChildren().add(hang);
        }


    }

    public void addHead(){
        Circle head = new Circle(250,300,50);
        head.setFill(null);
        head.setStrokeWidth(3);
        head.setStroke(Color.BLACK);
        //this.getChildren().add(head);
    }

    public void hang(int missed){
        this.getChildren().add(hangAMan.get(missed));
    }
}
