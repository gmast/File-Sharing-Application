/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacksuite;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserFactory;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BrowserPanel {

    public Browser browser;
    public JTextField addressBar;
    public JPanel panel_Browser;

//    public static void main(String[] args) {
//        String text = "GET /?code=4/dEOcy80kLXQ0mWtCE0kRmgZ3RbRKOdFW8ejtBTexX2c.gvcuV6iB6FUUgtL038sCVnspvGmAkgI HTTP/1.1";
//        System.out.println(" " + text.substring(text.indexOf("=") + 3, text.lastIndexOf(" ")));
//    }
    public BrowserPanel() {
    }

    public JPanel initBrowser(String url) {
        panel_Browser = new JPanel(new BorderLayout(5, 5));
        browser = BrowserFactory.create();
        addressBar = new JTextField("http://google.com");
        addressBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action_addressBarChanged();
            }
        });

        JPanel addressPane = new JPanel(new BorderLayout());
        addressPane.add(new JLabel(" URL: "), BorderLayout.WEST);
        addressPane.add(addressBar, BorderLayout.CENTER);
        panel_Browser.add(addressPane, BorderLayout.NORTH);
        panel_Browser.add(browser.getView().getComponent(), BorderLayout.CENTER);
        return panel_Browser;
    }

    public  void refreshBrowserPanel(String url) {
        System.out.println(" *** " + url + " *** ");
        System.out.println(" " + addressBar.getText());
        addressBar.setText(url);
    }

    private void action_addressBarChanged() {
        browser.loadURL(addressBar.getText());
    }

}
