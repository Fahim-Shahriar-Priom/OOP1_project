import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateFood {

   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel id,name,prize,quantity;
   private static int count = 0;
   GridLayout experimentLayout = new GridLayout(0,2);
    ResultSet rs;

    UpdateFood(){


      prepareGUI();
   }

   public static void main(String[] args){
      UpdateFood  swingControlDemo = new UpdateFood();
      swingControlDemo.showButtonDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Update!");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            mainFrame.setVisible(false);
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);

      statusLabel.setSize(350,400);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }


   public void showButtonDemo(){

      headerLabel.setText("KhanaPina Restaurant");
  
        name = new JLabel("Enter Name");
        JTextField tf2=new JTextField();
        tf2.setSize(100,30);
        
        prize = new JLabel("Enter Prize");
        JTextField tf3=new JTextField();
        tf3.setSize(100,30);

        quantity = new JLabel("Enter Quantity");
        JTextField tf4=new JTextField();
        tf4.setSize(100,30);

        JButton okButton = new JButton("UPDATE");


      //idButton.setHorizontalTextPosition(SwingConstants.RIGHT);

      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            PreparedStatement pst;
            DBConnection con = new DBConnection();
            try{
                pst = con.mkDataBase().prepareStatement("UPDATE restaurantmanagement.food SET f_quantity= ?, f_prize=? where f_name = ?");
                pst.setString(3, tf2.getText());
                pst.setDouble(2, Double.parseDouble(tf3.getText()));
                pst.setInt(1, Integer.parseInt(tf4.getText()));
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Done Updating " + tf2.getText());
                mainFrame.setVisible(false);
                
            }catch(Exception ex){
                System.out.println(ex);
                System.out.println("EEEE");
                JOptionPane.showMessageDialog(null, "Inserting Error : " + tf2.getText());
            }finally{
                
            }
         }
      });


      
      JPanel jp = new JPanel();
      jp.add(name);
      jp.add(tf2);
      jp.add(prize);
      jp.add(tf3);
      jp.add(quantity);
      jp.add(tf4);
      
      jp.setSize(200,200);
      jp.setLayout(experimentLayout);
      controlPanel.add(jp);
      jp.add(okButton);


      
      mainFrame.setVisible(true);
   }
}

