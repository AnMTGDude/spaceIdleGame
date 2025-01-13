package Populate;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Does a series of actions to "Populate a planet"
 */
public class ShowVisibleVerify implements EventHandler
{
    private GridPane gridPane;
    boolean bool;
    AtomicBoolean occupiedSpace;

    public ShowVisibleVerify(GridPane gridPane, boolean bool,
                             AtomicBoolean occupiedSpace)
    {
        this.gridPane = gridPane;
        this.bool = bool;
        this.occupiedSpace = occupiedSpace;
    }

    @Override
    public void handle(Event event)
    {
        if(bool)
        {
            if(!occupiedSpace.get())
            {
                gridPane.setVisible(true);
                occupiedSpace.set(true);
            }
        }
        else
        {
            gridPane.setVisible(false);
            occupiedSpace.set(false);
        }
    }
}