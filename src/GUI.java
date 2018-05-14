import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame {
     public static   int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
     public static int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
     private MyPanel myPanel = new MyPanel();
     private JButton btnStart, btnPause, btnQuit;
     private JPanel panelTop, panelBottom;
     public GUI(){
         setSize(width,height);
//         setLayout(new BorderLayout());
         setResizable(false);
         setLayout(new BorderLayout());
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         panelTop = new JPanel();
         panelTop.setSize(width,200);
         panelBottom = new JPanel();
         panelTop.setBackground(Color.cyan);
         panelBottom.setBackground(Color.gray);
         btnStart = new JButton("Start");
         btnStart.setBounds(width-280,height-80,80,30);
         btnPause = new JButton("Pause");
         btnPause.setBounds(width-190,height-80,80,30);
         btnQuit = new JButton("Quit");
         btnQuit.setBounds(width-100,height-80,80,30);
         add(panelTop, BorderLayout.NORTH);
         add(panelBottom,BorderLayout.SOUTH);
         add(myPanel);
         setVisible(true);
         addKeyListener(keyAdapter);

     }

    KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                MyPanel.basket.moveLeft(MyPanel.basket.speed);
            }

            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                MyPanel.basket.moveRight(MyPanel.basket.speed);
            }
        }
    };


    public static void main(String[] args) {
        GUI obj = new GUI();
    }

}
