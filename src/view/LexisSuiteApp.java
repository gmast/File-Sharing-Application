package view;

import hacksuite.BrowserPanel;
import hacksuite.DriveCommandLine;
import hacksuite.LexisApplicationMain;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.painter.MattePainter;

public class LexisSuiteApp {

    BrowserPanel browserPanelObj;
    JFileChooser fileChooser;
    
    
    LexisSuiteApp(BrowserPanel browserPanelObj) {
       this.browserPanelObj=browserPanelObj;
    }
    
    public JPanel initComponents() {
        panel_Container = new JPanel();
        panel_North = new JPanel();
        panel_Center = new JPanel();
        splitPane_Center = new JSplitPane();
        panel_Left = new JPanel();
        panel_RightBrowser = new JPanel();
        panel_South = new JPanel();

        //======== panel_Container ========
        {
            panel_Container.setLayout(new BorderLayout(5, 5));

            //======== panel_North ========
            {

                panel_North.add(linkBar());

                panel_North.setLayout(new BorderLayout(5, 5));
            }
            panel_Container.add(panel_North, BorderLayout.NORTH);

            //======== panel_Center ========
            {
                panel_Center.setLayout(new BorderLayout(5, 5));

                //======== splitPane_Center ========
                {
                    splitPane_Center.setDividerLocation(250);

                    //======== panel_Left ========
                    {
//                        panel_Left.setLayout(new GridBagLayout());
//                        ((GridBagLayout) panel_Left.getLayout()).columnWidths = new int[]{0, 0, 0};
//                        ((GridBagLayout) panel_Left.getLayout()).rowHeights = new int[]{0, 0, 0, 0};
//                        ((GridBagLayout) panel_Left.getLayout()).columnWeights = new double[]{0.0, 0.0, 1.0E-4};
//                        ((GridBagLayout) panel_Left.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 1.0E-4};
                    }

                    setLeftPanel();
                    splitPane_Center.setLeftComponent(panel_Left);

                    //======== panel_RightBrowser ========
                    {
                        panel_RightBrowser.setLayout(new BorderLayout(5, 5));
                    }
                    setRightPanel();
                    splitPane_Center.setRightComponent(panel_RightBrowser);
                    splitPane_Center.setDividerLocation(300);
                }
                panel_Center.add(splitPane_Center, BorderLayout.CENTER);
            }
            panel_Container.add(panel_Center, BorderLayout.CENTER);

            //======== panel_South ========
            {
                panel_South.setLayout(new BorderLayout(5, 5));
            }
            panel_Container.add(panel_South, BorderLayout.SOUTH);
        }
        return panel_Container;
    }

    private void setLeftPanel() {
        
        
      JLabel lbl_FilePath = new JLabel("Select File :");
      JTextField txt_ChooseFileFromPC = new JTextField(15);
        
          txt_ChooseFileFromPC.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            txt_ChooseFileFromPC.setText("");
                            JFileChooser inputFileChooser = new JFileChooser();
                            System.out.println(" " + e.getX() + ", " + e.getY());
                            inputFileChooser.setLocation(e.getLocationOnScreen());
                            inputFileChooser.setCurrentDirectory(new File("C:\\"));
                            inputFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//                            FileNameExtensionFilter filter_Extension = new FileNameExtensionFilter("CSV Extension", "csv");
//                            inputFileChooser.addChoosableFileFilter(filter_Extension);
                            inputFileChooser.setDialogTitle("Choose Input Data File");
                            int var_FileChooser = inputFileChooser.showDialog(panel_North, "Select");
                            if (var_FileChooser == JFileChooser.APPROVE_OPTION) {
                                String inputFilePath = inputFileChooser.getSelectedFile().getParent() + "\\" + inputFileChooser.getSelectedFile().getName();
                                txt_ChooseFileFromPC.setText(inputFilePath);
                            }
                        }

                    }
                });
        JPanel panel_tempNorth = new JPanel();
        panel_tempNorth.add(lbl_FilePath);
        panel_tempNorth.add(txt_ChooseFileFromPC);
        
        JButton btn_ShareFile = new JButton("Share File");
        btn_ShareFile.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                action_ShareFileAuthentication(txt_ChooseFileFromPC.getText());
            }

        });
        
        panel_Left.add(panel_tempNorth,BorderLayout.NORTH);
        panel_Left.add(btn_ShareFile,BorderLayout.CENTER);
    }

    private void shareFileAction(String srcFilePath) {
        DriveCommandLine dclObj = new DriveCommandLine(browserPanelObj);
        try {
            dclObj.doAuthorizeMethod(srcFilePath);
        } catch (IOException ex) {
            Logger.getLogger(LexisApplicationMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setRightPanel() {
        String url = "http://www.google.com";
        panel_RightBrowser = browserPanelObj.initBrowser(url);
    }

    private void action_ShareFileAuthentication(String filePath) {
        shareFileAction(filePath);
    }

    private void setLexisSuiteTitleLabel(JXPanel labelPanel) {
        JLabel lbl_GradienceTitle = new JLabel("LexisSuite Application");
        lbl_GradienceTitle.setFont(new Font("Serif", Font.ITALIC, 23));
        lbl_GradienceTitle.setForeground(new Color(0, 125, 155));
        labelPanel.add(lbl_GradienceTitle);
    }

    public static MattePainter getPainter() {
        int width = 300;
        int height = 100;
        Color color1 = Colors.White.color(0.6f);
        Color color2 = Colors.LightBlue.color(1.0f);
        LinearGradientPaint gradientPaint
                = new LinearGradientPaint(0.0f, 0.0f, width, height,
                        new float[]{0.0f, 1.0f},
                        new Color[]{color1, color2});
        RadialGradientPaint gradientPaint1
                = new RadialGradientPaint(new Point(200, 200), 400,
                        new float[]{0.0f, 1.0f},
                        new Color[]{color2, color1});
        MattePainter mattePainter = new MattePainter(gradientPaint1);
        return mattePainter;
    }

    private Box linkBar() {
        Box statusBox = Box.createHorizontalBox();
        JXPanel labelPanel = new JXPanel();
        labelPanel.setBackgroundPainter(getPainter());
        labelPanel.setPreferredSize(new Dimension(600, 32));
        statusBox.add(labelPanel);
        JXPanel linkPannel = new JXPanel();
        linkPannel.setBackgroundPainter(new MattePainter(new LinearGradientPaint(0.0f, 0.0f, 300, 400,
                new float[]{0.0f, 1.0f},
                new Color[]{Colors.White.color(0.6f), Colors.LightBlue.color(1.0f)})));
        statusBox.add(linkPannel);
        setLexisSuiteTitleLabel(labelPanel);

        JButton btn_Logout = new JButton("Logout");
        linkPannel.add(btn_Logout);

        statusBox.setMinimumSize(new Dimension(500, 400));
        statusBox.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        return statusBox;
    }
    
    private JPanel panel_Container;
    private JPanel panel_North;
    private JPanel panel_Center;
    private JSplitPane splitPane_Center;
    private JPanel panel_Left;
    private JPanel panel_RightBrowser;
    private JPanel panel_South;
}
