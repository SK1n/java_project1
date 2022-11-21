import java.awt.*;

import javax.swing.JPanel;

public class GraphPanel extends JPanel {
    private int ww;
    private int hh;

    public GraphPanel() {
        setBackground(Color.gray);
        setPreferredSize(new Dimension(400, 600));
        ww = this.getPreferredSize().width;
        hh = this.getPreferredSize().height;

    }

    public void paint(Graphics g) {
        super.paint(g);
        // System.out.println(hh);
        g.drawRect(0, 0, 400, 600);
        g.drawLine(0, 600 / 2, 400, 600 / 2);
        g.drawLine(400 / 2, 0, 400/2, 600);
    }

}
