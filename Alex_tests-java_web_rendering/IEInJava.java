import org.jdesktop.jdic.browser.*;
import java.awt.*;
import javax.swing.*;
import java.net.*;
public class IEInJava {
public static void main(String[] args) {
WebBrowser webBrowser = new WebBrowser();
webBrowser.setSize(700,500);
JFrame frame = new JFrame("IE in Java"); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Container contentPane = frame.getContentPane(); 
contentPane.add(webBrowser, BorderLayout.CENTER);
frame.pack();
frame.setVisible(true);
URL url = null;
try { 
url = new URL("http://www.pcquest.com"); 
}
catch (MalformedURLException e) {
System.out.println(e);
} 
webBrowser.setURL(url);
}
}