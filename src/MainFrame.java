import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private JPanel mainPanel = new JPanel();
    private JPanel imagePanel = new JPanel();
    private JPanel annotationPanel = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem m1 = new JMenuItem();
    private JMenuItem m2 = new JMenuItem();
    private JMenu menu = new JMenu();

    public MainFrame(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BoxLayout());

        mainPanel.setPreferredSize(new Dimension(1920, 1080));
        mainPanel.setMinimumSize(new Dimension(800,600));
        mainPanel.setBackground(new Color(62,72,79));
        this.setContentPane(mainPanel);

        menu.add(m1);
        menu.add(m2);
        menuBar.add(menu);
        mainPanel.add(menuBar);

        imagePanel.setPreferredSize(new Dimension(800,600));
        imagePanel.setBackground(new Color(255, 0, 0));
        mainPanel.add(imagePanel);
        this.setVisible(true);
    }

    public static void main(String[] args){
        MainFrame mf  = new MainFrame();

    }


}
