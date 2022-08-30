package feiji.view;
import feiji.model.Bullet;
import feiji.model.Enemy;
import feiji.model.Item;
import feiji.model.Player;
import feiji.thread.DrawableTherad;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JPanel;


public class MyPanel extends JPanel{

    //存放的是背景图片
    public Image bgImage;
    public int timer=0;
    public int top=0;

    public DrawableTherad drawableTherad;

    //创建一个飞机主角对象
    public Player player;

    //存放所有子弹
    public ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    //存放所有的敌机
    public ArrayList<Enemy> enemys = new ArrayList<Enemy>();

    //存放所有的敌机类型
    public ArrayList<Class> enemyType = new ArrayList<Class>();	public MyPanel()
    {
        this.bgImage=Toolkit.getDefaultToolkit().getImage("src/images/background.png");

        //当窗口创建出来后，主角飞机也被创建
        this.player = new Player(this);

        //创建线程 重绘Panel
        this.drawableTherad=new DrawableTherad(this);

        //启动线程
        this.drawableTherad.start();


    }

    //存放所有的奖品
    public ArrayList<Item> items = new ArrayList<>();


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //绘制背景图
        g.drawImage(this.bgImage, 0, top-this.bgImage.getHeight(this), this.bgImage.getWidth(this),this.bgImage.getHeight(this), null);
        g.drawImage(this.bgImage, 0, top, this.bgImage.getWidth(this),this.bgImage.getHeight(this),null);
        timer++;

        if(timer==10000)
            timer=0;

        if(timer%10==0) {
            top++;

            if(top>this.bgImage.getHeight(this))
                top=0;
        }
        //绘制主角飞机
        this.player.drawSelf(g);

        //绘制子弹
        if(timer%100==0) {
            //创建子弹
            Bullet bullet = new Bullet(this);
            //设置坐标
            bullet.x = this.player.x+this.player.width/2 - bullet.width/2;
            bullet.y = this.player.y;

            //存入arrayList中
            this.bullets.add(bullet);
        }

        //画出所有的子弹
        for(int i=0; i<bullets.size(); i++) {
            this.bullets.get(i).drawSelf(g);
        }

        //绘制敌机
        if(timer%800==0) {
            if(this.enemyType.size()>0) {
                //随机产生一种类型的敌机
                int index = (int)(Math.random()*this.enemyType.size());
                Enemy enemy = null;
                try {
                    enemy = (Enemy)(this.enemyType.get(index).getConstructors()[0].newInstance(new Object[] {this}));
                } catch (InstantiationException | IllegalAccessException |
                        IllegalArgumentException | InvocationTargetException | SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                //将创建好的敌机放在数组里
                this.enemys.add(enemy);
            }
        }

        //将所有的敌机画出来
        for(int i=0;i<this.enemys.size();i++) {
            this.enemys.get(i).drawSelf(g);
        }
        //将所有的奖品画出来
        for(int i=0;i<this.items.size();i++) {
            this.items.get(i).drawSelf(g);
        }

    }
}
