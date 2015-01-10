package hacksuite;

import view.HackLogin;

/**
 *
 * @author Vikas
 */
public class LexisApplicationMain {
static  BrowserPanel browserPanelObj;

    public static void main(String[] args) {
         browserPanelObj = new BrowserPanel();
         browserPanelObj.initBrowser("");
        HackLogin loginWin = new HackLogin(browserPanelObj);
        loginWin.initComponents();
    }
}
