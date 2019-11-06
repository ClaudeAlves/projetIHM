import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainFrame extends JFrame{
    private JPanel mainPanel = new JPanel();
    private JPanel imagePanel = new JPanel();
    private JScrollPane annotationPanel = new JScrollPane();
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem m1 = new JMenuItem();
    private JMenuItem m2 = new JMenuItem();
    private JMenuItem m3 = new JMenuItem();
    private JMenuItem m4 = new JMenuItem();
    private JMenuItem m5 = new JMenuItem();
    private JMenu menu = new JMenu();
    private JButton newAnnotation = new JButton();
    final JLabel label = new JLabel();

    public MainFrame(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        m1.setText("Open File");
        m1.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                label.setText("File Saved as: " + file.getName());
            }else{
                label.setText("Save command canceled");
            }

        });
        m2.setText("Export File");
        m2.addActionListener(actionEvent -> JOptionPane.showMessageDialog(null,"You selected: Export File."));
        m3.setText("Save");
        m3.addActionListener(actionEvent -> {
            JOptionPane.showMessageDialog(null,"You selected: Save.");
        });
        m4.setText("Save As");
        m4.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                label.setText("File Saved as: " + file.getName());
            }else{
                label.setText("Save command canceled");
            }
        });
        m5.setText("Exit");
        m5.addActionListener(actionEvent -> JOptionPane.showMessageDialog(null,"You selected: Exit."));
        menu.setText("Menu");
        JTextArea textArea = new JTextArea(5,40);
        textArea.add(new JLabel());
        annotationPanel.setBackground(new Color(52,62,69));
        annotationPanel.add(textArea);

        newAnnotation.setText("New Annotation");
        mainPanel.setPreferredSize(new Dimension(1920, 1080));
        this.setMaximumSize(new Dimension(800,600));
        mainPanel.setMinimumSize(new Dimension(800,600));
        mainPanel.setBackground(new Color(62,72,79));
        mainPanel.setLayout(new BorderLayout());
        this.setContentPane(mainPanel);


        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        menu.add(m4);
        menu.add(m5);
        menuBar.add(menu);
        menuBar.add(newAnnotation);
        mainPanel.add(annotationPanel, BorderLayout.EAST);
        menuBar.setBackground(new Color(70,80,87));
        mainPanel.add(menuBar, BorderLayout.NORTH);

        imagePanel.setPreferredSize(new Dimension(800,600));
        imagePanel.setBackground(new Color(62,72,70));
        mainPanel.add(imagePanel);
        this.setVisible(true);
    }

    public static void main(String[] args){
        MainFrame mf  = new MainFrame();

    }


}
