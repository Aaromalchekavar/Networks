import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;


public class SingleChat extends javax.swing.JFrame {

  ServerSocket serversocket;
  Socket socket;
  JTextField textfield = new JTextField();
  JButton sendbutton = new JButton();
  JTextArea textareaormessages = new JTextArea();
  PrintWriter printwriter;
  BufferedReader bufferedreader;
  ActionListener actionlistener;
  String inputstring;
  boolean ready2send = false;
  SingleChat pt;
  boolean HostorClient;
  String cliOrServ;

  public SingleChat(boolean hostOrConnect, String ip) {
    inputstring = ip;
    setLayout(null);
    setSize(500, 500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    add(textfield);
    textfield.setLocation(5, 5);
    textfield.setSize(getWidth() - 40 - 60, 30);
    textfield.setEnabled(false);
    add(sendbutton);
    sendbutton.setLocation(10 + textfield.getWidth(), textfield.getY());
    sendbutton.setText("Send");
    sendbutton.setSize(60, 30);
    add(textareaormessages);
    textareaormessages.setEditable(false);
    textareaormessages.setLocation(5, textfield.getHeight() + textfield.getY() + 5);
    textareaormessages.setSize(
      getWidth() - 30,
      getHeight() - textfield.getY() - textfield.getHeight() - 50
    );

    actionlistener =
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          ready2send = true;
        }
      };

    sendbutton.addActionListener(actionlistener);
    pt = this;
    HostorClient = hostOrConnect;
    if (HostorClient) cliOrServ = "\nServer: "; else cliOrServ = "\nClient: ";
    Messenger.start();
  }

  public static void main(String args[]) {
    int inp = JOptionPane.showConfirmDialog(
      null,
      "Do you want to host the chat?\nYes - Act as server\nNo - Act as client",
      "Want to host a chat?",
      JOptionPane.YES_NO_OPTION
    );
    if (inp == 0) {
      new SingleChat(true, null).setVisible(true);
    } else {
      String inputstring = JOptionPane.showInputDialog(
        "Please enter the ip address"
      );
      try {
        InetAddress.getByName(inputstring);
        new SingleChat(false, inputstring).setVisible(true);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Invalid or Unreachable IP");
      }
    }
  }

  Thread Messenger = new Thread() {
    public void run() {
      try {
        if (HostorClient) {
          textareaormessages.setText(
            "Waiting for an incoming connection.\nEnter my ip at client side.\nMy ip: " +
            InetAddress.getLocalHost().getHostAddress()
          );
          serversocket = new ServerSocket(4444);
          socket = serversocket.accept();
          socket.setKeepAlive(true);
        } else {
          textareaormessages.setText("Connecting to:" + inputstring + ":9999");
          socket = new Socket(InetAddress.getByName(inputstring), 4444);
        }
        textfield.setEnabled(true);
        printwriter = new PrintWriter(socket.getOutputStream(), true);
        bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        textareaormessages.setText(
          textareaormessages.getText() +
          "\nConnected to:" +
          socket.getInetAddress().getHostAddress() +
          ":" +
          socket.getPort()
        );
        while (true) {
          if (ready2send == true) {
            printwriter.println(textfield.getText());
            textareaormessages.setText(textareaormessages.getText() + "\nMe: " + textfield.getText());
            textfield.setText("");
            ready2send = false;
          }
          if (bufferedreader.ready()) {
            textareaormessages.setText(textareaormessages.getText() + cliOrServ + bufferedreader.readLine());
          }
          Thread.sleep(80);
        }
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(pt, ex.getMessage());
        textareaormessages.setText("Cannot connect!");
        try {
          wait(3000);
        } catch (InterruptedException ex1) {}
      }
    }
  };
}
