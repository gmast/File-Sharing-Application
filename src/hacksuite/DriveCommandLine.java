package hacksuite;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.util.Arrays;

public class DriveCommandLine {
    private static String CLIENT_ID = "486121912434-0ojb4iuarhlv43elpm9bcio8pi65621p.apps.googleusercontent.com";
    private static String CLIENT_SECRET = "Vf795mxRyna85oWhwMf8hEXd";
//  private static String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
    private static String REDIRECT_URI = "http://localhost:8080";
    
//    public static void main(String[] args) throws IOException {
//         doMethod();
//    }
    
    BrowserPanel browserPanelObj;

    public DriveCommandLine(BrowserPanel bObj) {
        this.browserPanelObj = bObj;
    }

    public void refreshBrowser(String url) {
        browserPanelObj.refreshBrowserPanel(url);
    }

    public  void doAuthorizeMethod(String srcFilePath) throws IOException {
        HttpTransport httpTransport = new NetHttpTransport();
        JsonFactory jsonFactory = new JacksonFactory();

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, jsonFactory, CLIENT_ID, CLIENT_SECRET, Arrays.asList(DriveScopes.DRIVE))
                .setAccessType("online")
                .setApprovalPrompt("auto").build();

        String url = flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URI).build();
        System.out.println("Please open the following URL in your browser then type the authorization code:");

        System.out.println("  " + url);
      Desktop.getDesktop().browse(URI.create(url));

//      java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));

//       refreshBrowser(url);
        
        ServerSocket listener = new ServerSocket(8080);
        Socket socket = listener.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String inputLine;
        System.out.println("Request is :");
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            break;
        }
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Authorization Successful");
        socket.close();
        listener.close();
  
        String authKey = inputLine.substring(inputLine.indexOf("=")+1,inputLine.lastIndexOf(" "));
        System.out.println(""+authKey);
        
        GoogleTokenResponse response = flow.newTokenRequest(authKey).setRedirectUri(REDIRECT_URI).execute();
        GoogleCredential credential = new GoogleCredential().setFromTokenResponse(response);

        //Create a new authorized API client
        Drive service = new Drive.Builder(httpTransport, jsonFactory, credential).build();

        //Insert a file  
        File body = new File();

        String title = srcFilePath.substring(srcFilePath.lastIndexOf("\\"),srcFilePath.length());
        body.setTitle(title);
        body.setDescription("A test document");
//        body.setMimeType("text/plain");

        java.io.File fileContent = new java.io.File(srcFilePath);
//        FileContent mediaContent = new FileContent("text/plain", fileContent);

        File file = service.files().insert(body).execute();
        System.out.println("File ID: " + file.getId());
    }
}
