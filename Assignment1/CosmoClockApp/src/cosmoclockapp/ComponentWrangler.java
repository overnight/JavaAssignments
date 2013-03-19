package cosmoclockapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ComponentWrangler extends MouseInputAdapter {

    Component selectedComponent;
    Point offset;
    boolean dragging;

    public ComponentWrangler()
    {
        dragging = false;
    }

    public void mousePressed(MouseEvent e)
    {
        selectedComponent = (Component) e.getSource();
        offset = e.getPoint();
        dragging = true;
    }

    public void mouseReleased(MouseEvent e)
    {
        dragging = false;
    }

    public void mouseDragged(MouseEvent e)
    {
        if (dragging)
        {
            Rectangle r = selectedComponent.getBounds();
            r.x += e.getX() - offset.x;
            r.y += e.getY() - offset.y;
            selectedComponent.setBounds(r);
        }
    }
}
