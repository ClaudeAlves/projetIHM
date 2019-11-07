import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainFrame extends JFrame{
    private JPanel mainPanel = new JPanel();
    private JPanel imagePanel = new JPanel();
    private JScrollPane annotationPanel = new JScrollPane();
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem importMenuItem = new JMenuItem();
    private JMenuItem exportMenuItem = new JMenuItem();
    private JMenuItem saveMenuItem = new JMenuItem();
    private JMenuItem saveAsMenuItem = new JMenuItem();
    private JMenuItem exitMenuItem = new JMenuItem();
    private JMenu menu = new JMenu();
    private JButton newAnnotation = new JButton();
    final JLabel label = new JLabel();

    public MainFrame(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        importMenuItem.setText("Import File");
        importMenuItem.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                label.setText("File Saved as: " + file.getName());
            }else{
                label.setText("Save command canceled");
            }

        });
        exportMenuItem.setText("Export File");
        exportMenuItem.addActionListener(actionEvent -> JOptionPane.showMessageDialog(null,"You selected: Export File."));
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(actionEvent -> {
            JOptionPane.showMessageDialog(null,"You selected: Save.");
        });
        saveAsMenuItem.setText("Save As");
        saveAsMenuItem.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                label.setText("File Saved as: " + file.getName());
            }else{
                label.setText("Save command canceled");
            }
        });
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(actionEvent -> {
            System.exit(0);
        });
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


        menu.add(importMenuItem);
        menu.add(exportMenuItem);
        menu.add(saveMenuItem);
        menu.add(saveAsMenuItem);
        menu.add(exitMenuItem);
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
