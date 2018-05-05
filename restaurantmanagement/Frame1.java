import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;


public class Frame1 extends JFrame{

    JLabel lbl1;
    JLabel lbl2;


    JTextField id;
    JPasswordField pass;

    JButton submit;


   public Frame1(){
       setSize(600,300);


    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.getContentPane().setBackground(Color.GRAY);
    this.init();
    this.addCom();
    this.visible();

    }



    public void init(){
        lbl1=new JLabel("ID");
        lbl2=new JLabel("Password");
        id=new JTextField();
        id.setSize(500,50);
        pass=new JPasswordField();
        pass.setSize(100,40);

       submit=new JButton("Submit");

       submit.addActionListener(this::submitActionPerformed);


    }

    public void addCom()
    {
        JPanel controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      this.add(controlPanel);


      JPanel jp = new JPanel();
      jp.setSize(600,300);
    jp.add(lbl1);
    jp.add(id);
    jp.add(lbl2);
    jp.add(pass);
    jp.add(submit);
    jp.setLayout(new GridLayout(0,2));
    controlPanel.add(jp);
    this.add(controlPanel);
     }


    public void visible(){


    this.pack();


    this.setVisible(true);
    }


   public void submitActionPerformed(java.awt.event.ActionEvent evt){

   if(id.getText().equals("admin") && pass.getText().equals("admin")){


     this.hide();
     Frame2new fn=new Frame2new();
     fn.showButtonDemo();

   }

   else{

    JOptionPane.showMessageDialog(null, "Invalid pass");

   }

   }



}
