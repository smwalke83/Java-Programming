//
import java.awt.*;
import javax.swing.*;

public class TestFigurePanel extends JFrame {
  public TestFigurePanel() {
    setLayout(new GridLayout(2, 3, 5, 5));
    add(new FigurePanel(FigurePanel.LINE));   
    add(new FigurePanel(FigurePanel.ROUND_RECTANGLE));
    add(new FigurePanel(FigurePanel.OVAL));
    add(new FigurePanel(FigurePanel.RECTANGLE, true));
  }

}