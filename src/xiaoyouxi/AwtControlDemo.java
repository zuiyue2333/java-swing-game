package xiaoyouxi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtControlDemo {

    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;
    public AwtControlDemo(){
        prepareGUI();
    }
    public static void main(String[] args){
        AwtControlDemo  awtControlDemo = new AwtControlDemo();
        awtControlDemo.showButtonDemo();
    }
    private void prepareGUI(){
        //定义窗口，并传入标题
        mainFrame = new Frame("Java AWT Examples");
        //定义窗口大小
        mainFrame.setSize(1000,600);
        //设置布局方式
        mainFrame.setLayout(new GridLayout(3, 1));
        //监听
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        //Control in action: Button
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        //Button clicked
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350,100);
        //Panel，布局方式FlowLayout
        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());
        //将组件添加到mainFrame
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    private void showButtonDemo(){
        headerLabel.setText("Control in action: Button");
        Button okButton = new Button("OK");
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Ok Button clicked.");
            }
        });
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Submit Button clicked.");
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Cancel Button clicked.");
            }
        });
        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);
        //可是化窗口
        mainFrame.setVisible(true);
    }

}
