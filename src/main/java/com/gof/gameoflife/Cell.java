package com.gof.gameoflife;

import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;

import static com.gof.gameoflife.Main.basedTable;
import static com.gof.gameoflife.Main.swtch;
import static javafx.scene.paint.Color.*;

public class Cell extends Parent {

    private int axeX;
    private int axeY;
    private boolean isCellAlive;
    Rectangle rectangle;
    public Cell(int axeY, int axeX) {
        this.axeX = axeX;
        this.axeY = axeY;
        this.isCellAlive = false;

        this.rectangle  = new Rectangle(0,0,9,9);
        rectangle.setFill(DARKCYAN);
        this.getChildren().add(rectangle);
        this.setOnMousePressed(e -> {
            if(this.isCellAlive && !swtch){
                this.dead();
                basedTable[this.axeY][this.axeX]=0;
            }else if(!this.isCellAlive && !swtch){
                this.alive();
                basedTable[this.axeY][this.axeX]=1;

            }
        });
    }

    public void dead(){
        this.isCellAlive = false;
        rectangle.setFill(DARKCYAN);

    };
    public void alive(){
        this.isCellAlive = true;
        rectangle.setFill(YELLOW);
    };
    public boolean isAlive(){return isCellAlive;};
    public int getAxeX() {
        return axeX;
    }

    public int getAxeY() {
        return axeY;
    }
}
