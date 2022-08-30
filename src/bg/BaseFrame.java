package bg;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {
    //窗口的宽度和高度（具体值由背景图片大小决定）
    public static int frameWidth=480;
    public static int frameHeight=700;

    public MyPanel myPanel;

    public BaseFrame(){
        //setTitle("Java 第一个 GUI 程序");    //设置显示窗口标题
        //设置显示窗口标题
        super("飞机大战");


        //设置窗口显示尺寸
       /* setSize(400,200);

        //设置窗口居中(一定放在setSize后面)
        setLocationRelativeTo(null);*/

        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)((dimension.getWidth()-200)/2),300,frameWidth,frameHeight);

        this.myPanel = new MyPanel();
        //设置MyPanel对象的位置和大小
        this.myPanel.setBounds(0,0,frameWidth,frameHeight);
        //将组件添加到窗口中
        this.add(this.myPanel);

        //设置窗口关闭，关闭窗口后，程序停止
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置窗口是否可见
        setVisible(true);
    }
}
