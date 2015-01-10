/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacksuite.experiments;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld {

    static JTextField addressBar;
    static Browser browser;

    public static void main(String[] args) {
        browser = BrowserFactory.create();

        final JButton btn_ChangeUrl = new JButton();
        btn_ChangeUrl.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                action_btnChangeUrl();
            }

        });

        addressBar = new JTextField("http://www.teamdev.com/jxbrowser");
        addressBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browser.loadURL(addressBar.getText());
            }
        });

        JPanel addressPane = new JPanel(new BorderLayout());

        JPanel panel_West = new JPanel();
        panel_West.add(btn_ChangeUrl);
        addressPane.add(btn_ChangeUrl, BorderLayout.EAST);
        addressPane.add(new JLabel(" URL: "), BorderLayout.WEST);
        addressPane.add(addressBar, BorderLayout.CENTER);

        JFrame frame = new JFrame("JxBrowser - Hello World");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(addressPane, BorderLayout.NORTH);
        frame.add(browser.getView().getComponent(), BorderLayout.CENTER);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        browser.loadURL(addressBar.getText());
    }

    private static void action_btnChangeUrl() {
        addressBar.setText("http://xvikas.com");
        browser.loadURL(addressBar.getText());
    }

}
