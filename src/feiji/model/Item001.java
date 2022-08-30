package feiji.model;

import java.awt.Image;
import java.awt.Toolkit;

import feiji.view.MyPanel;

public class Item001 extends Item{

    public Item001(MyPanel myPanel) {
        super(myPanel);
        // TODO Auto-generated constructor stub
        this.width=30;
        this.height=30;
        this.images=new Image[] {
                Toolkit.getDefaultToolkit().getImage("src/images/star01.png"),
                Toolkit.getDefaultToolkit().getImage("src/images/star02.png"),
                Toolkit.getDefaultToolkit().getImage("src/images/star03.png"),
                Toolkit.getDefaultToolkit().getImage("src/images/star04.png"),
                Toolkit.getDefaultToolkit().getImage("src/images/star05.png"),
                Toolkit.getDefaultToolkit().getImage("src/images/star06.png"),
                Toolkit.getDefaultToolkit().getImage("src/images/star07.png"),
                Toolkit.getDefaultToolkit().getImage("src/images/star08.png"),
                Toolkit.getDefaultToolkit().getImage("src/images/star09.png"),
        };
        this.imageSpeed=(int)(Math.random()*20+5);
        this.speed=3;
    }

}
