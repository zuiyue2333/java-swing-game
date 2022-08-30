package bg;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public Image bgImage;
    public MyPanel(){
        this.bgImage = Toolkit.getDefaultToolkit().getImage("src/images/background.png");
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //绘制背景图
        g.drawImage(this.bgImage, 0, 0-this.bgImage.getHeight(this), this.bgImage.getWidth(this),this.bgImage.getHeight(this), null);
        g.drawImage(this.bgImage, 0, 0, this.bgImage.getWidth(this),this.bgImage.getHeight(this),null);
    }

}
