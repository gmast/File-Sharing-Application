package view;

import hacksuite.BrowserPanel;
import hacksuite.DriveCommandLine;
import hacksuite.LexisApplicationMain;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import org.jdesktop.swingx.JXTitledPanel;
import view.HackBorder;
import view.LexisSuiteApp;
/*
 * Created by JFormDesigner on Thu Sep 18 19:18:36 EDT 2014
 */

/**
 * @author Vikas Piddempally
 */
public class HackLogin extends JFrame {
    BrowserPanel browserPanelObj;
    
    public HackLogin() {
    }

    public HackLogin(BrowserPanel browserPanelObj) {
        this.browserPanelObj = browserPanelObj;
    }

    public void initComponents() {
        // Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        frame = new JFrame();
        borderObj = new HackBorder();
        panel_Container = new JXTitledPanel();
        panel_Login = new JPanel();
        lbl_UserName = new JLabel();
        txt_UserName = new JTextField();
        txt_Password = new JTextField();
        lbl_Password = new JLabel();
        panel_SouthButtons = new JPanel();
        btn_Login = new JButton();
        btn_Cancel = new JButton();
        btn_SignUp = new JButton();

        //======== panel_Container ========
        {
            panel_Container.setLayout(new BorderLayout(8, 8));
            //======== panel_Login ========
            {
                panel_Login.setLayout(new GridBagLayout());
                ((GridBagLayout) panel_Login.getLayout()).columnWidths = new int[]{0, 90, 0};
                ((GridBagLayout) panel_Login.getLayout()).rowHeights = new int[]{0, 0, 0};
                ((GridBagLayout) panel_Login.getLayout()).columnWeights = new double[]{0.0, 0.0, 1.0E-4};
                ((GridBagLayout) panel_Login.getLayout()).rowWeights = new double[]{0.0, 0.0, 1.0E-4};

                //---- lbl_UserName ----
                lbl_UserName.setText("User Name");
                panel_Login.add(lbl_UserName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                panel_Login.add(txt_UserName, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));
                panel_Login.add(txt_Password, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));

                //---- lbl_Password ----
                lbl_Password.setText("Password");
                panel_Login.add(lbl_Password, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
            }
            panel_Container.add(panel_Login, BorderLayout.CENTER);
        }

        //======== panel_SouthButtons ========
        {
            panel_SouthButtons.setLayout(new FlowLayout());

            //---- btn_Login ----
            btn_Login.setText("Login");
            btn_Login.addActionListener(new AbstractAction() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    action_btnLogin(); //To change body of generated methods, choose Tools | Templates.
                }
            });
            panel_SouthButtons.add(btn_Login);

            //---- btn_Cancel ----
            btn_Cancel.setText("Cancel");
            panel_SouthButtons.add(btn_Cancel);
            borderObj.setBorder(panel_SouthButtons, "", 12, 0);
            

            //---- btn_SignUp ----
            btn_SignUp.setText("Sign Up");
            panel_SouthButtons.add(btn_SignUp);
            panel_Container.add(panel_SouthButtons, BorderLayout.SOUTH);
        }
        borderObj.setBorder(panel_Container, "Login", TitledBorder.CENTER, "Serief", Font.BOLD, 16, 10);
        // End of component initialization  //GEN-END:initComponents
        frame.add(panel_Container);
        frame.setType(Window.Type.UTILITY);
        frame.setVisible(true);
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        Toolkit t = frame.getToolkit();
        frame.setLocation(t.getScreenSize().width / 2 - frame.getWidth() / 2,
                t.getScreenSize().height / 2 - frame.getHeight() / 2);
        
        
    }

    private void action_btnLogin() {
        if(txt_UserName.getText().trim().equalsIgnoreCase("admin")){
            initAppGUI();
        }
    }
    
    private void initAppGUI() {
        JFrame frame = new JFrame();
        JPanel mainPanel = new LexisSuiteApp(browserPanelObj).initComponents();
        new HackBorder().setBorder(mainPanel, "Authorization", 14 , 3);
        frame.add(mainPanel);
        frame.setTitle("LexisNexis HackSuite Application");
        frame.setVisible(true);
        frame.setSize(800, 800);
    }

    private JFrame frame;
    private JXTitledPanel panel_Container;
    private JPanel panel_Login;
    private JLabel lbl_UserName;
    private JTextField txt_UserName;
    private JTextField txt_Password;
    private JLabel lbl_Password;
    private JPanel panel_SouthButtons;
    private JButton btn_Login;
    private JButton btn_Cancel;
    private JButton btn_SignUp;
    private HackBorder borderObj;
}
