package feiji.model;

import feiji.view.BaseFrame;
import feiji.view.MyPanel;

import java.awt.*;

public class Enemy {
    //使用MyPanel的原因是，要调用MyPanel中的timer
    public MyPanel myPanel;

    //width，height是敌机宽度与高度
    public int width;
    public int height;

    //x，y是敌机的坐标
    public int x;
    public int y;

    public Image image;
    public int hp; //敌机的生命值
    protected Item[] items;
    public Image[] dieImages = new Image[] {
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down1.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down2.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down3.png"),
            Toolkit.getDefaultToolkit().getImage("src/images/enemy1_down4.png"),
    };


    public Enemy(MyPanel myPanel) {
        this.myPanel = myPanel;
    }

    public int imageIndex = 0;

    public void drawSelf(Graphics g) {
        if (hp > 0) {
            g.drawImage(this.image, x, y, width, height, null);
        } else {
            //被打中
            g.drawImage(this.dieImages[imageIndex], x, y, width, height, null);

            //每隔50毫秒切换一张图片
            if (this.myPanel.timer % 50 == 0) {
                imageIndex++;
                if (imageIndex >= this.dieImages.length) {
                    //敌机死了
                    killed();
                }

            }
        }

        //敌机向下移动,如果敌机出界就销毁
        if (this.myPanel.timer % 35 == 0) {
            y = y + 10;
            if (y >= BaseFrame.frameHeight) {
                killed();
            }
        }
    }
    

    //移除死掉或者飞出界面的敌机
    public void killed() {
        if(items!=null && items.length>0) {
            //敌机死后，释放奖品
            for(int i=0;i<items.length;i++) {
                Item item=items[i];

                //奖品出现的位置就是敌机死掉的位置
                //25*i目的是将奖品隔开
                item.x=this.x+25*i;
                item.y=this.y;

                this.myPanel.items.add(item);

            }
        }

        this.myPanel.enemys.remove(this);
    }

    //敌机处在被攻击状态，其生命值减少
    public void underAttack() {
        if(hp>0) {
            hp--;
        }
    }



}
