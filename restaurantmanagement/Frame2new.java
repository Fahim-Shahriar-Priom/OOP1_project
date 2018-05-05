import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Frame2new {

   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public Frame2new(){


      prepareGUI();
      
   }

   public static void main(String[] args){
      Frame2new  swingControlDemo = new Frame2new();
      swingControlDemo.showButtonDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Restaurant Management System ");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);

      statusLabel.setSize(350,300);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }


   public void showButtonDemo(){

      headerLabel.setText("Welcome to KhanaPina Restaurant");


JButton fkButton = new JButton("Food Info");
JButton billButton = new JButton("Billing Info");
JButton afButton = new JButton("Insert Item");
JButton ufButton = new JButton("Update Item");




      //cancelButton.setHorizontalTextPosition(SwingConstants.LEFT);
        fkButton.addActionListener(new ActionListener()
{
         public void actionPerformed(ActionEvent e) {
            
           ItemInfo ii=new ItemInfo();
             try {
                 ii.showButtonDemo();
             } catch (SQLException ex) {
                 Logger.getLogger(Frame2new.class.getName()).log(Level.SEVERE, null, ex);
             }

         }
});

        billButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
{
            

            GenerateBill gb=new GenerateBill();}

});

      afButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
{
            

            EnterFood ef=new EnterFood();
            ef.showButtonDemo();
         }
});



      ufButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
           
            UpdateFood uf=new UpdateFood();
            uf.showButtonDemo();

         }
});

      controlPanel.add(ufButton);
      controlPanel.add(afButton);
      controlPanel.add(billButton);
      controlPanel.add(fkButton);

      mainFrame.setVisible(true);
   }
}
