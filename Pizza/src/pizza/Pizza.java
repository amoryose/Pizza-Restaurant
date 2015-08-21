// Avraham Moryosef
// 7/31/14
// CSC 156

package pizza;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
//import java.util.*;
import java.applet.*;

   public class Pizza extends JApplet implements ItemListener, ActionListener
   {     
    // cost variables for the pizza
    // T is for ingredients
    private double T = 0, SIZE = 0, CRUST = 0;
    
    // what is in the applet
    private JCheckBox olivesCB, mushroomsCB, anchovyCB, spinachCB, echeeseCB;
    private JRadioButton smallRB, mediumRB, largeRB;
    private JRadioButton thinRB, medium_crustRB, panRB;
      
    private JTextArea display;
    
    private JButton total, reset;
    
    private ButtonGroup sizeGroup, crustGroup;
    
    // pizza strings
    private String olivesS = "", mushroomsS = "", anchovyS = "", spinachS = "", echeeseS = "", outputStr = "";
    private String smallS = "", mediumS = "", largeS = "";
    private String thinS = "", medium_crustS = "", panS = "";
    
    Image poster;
    AudioClip clears, cash;
    
    public void init()
    {
        poster = getImage(getDocumentBase(), "pizza.png"); 
        
        cash = getAudioClip(getDocumentBase(), "cash_register.wav");
        clears = getAudioClip(getDocumentBase(), "clear.wav");
           
        reset = new JButton ("Reset");
           
        total = new JButton ("Process Order");
        
        Container c = getContentPane();
        c.setLayout(null);
        
        // Pizza ingridients
        olivesCB = new JCheckBox("Olives");
        mushroomsCB = new JCheckBox("Mushrooms");
        anchovyCB = new JCheckBox("Anchovy");
        spinachCB = new JCheckBox("Spinach");
        echeeseCB = new JCheckBox("Extra Cheese");
        
        // Pizza size
        smallRB = new JRadioButton("Small:     $9.98");
        mediumRB = new JRadioButton("Medium: $13.36");
        largeRB = new JRadioButton("Large:     $19.52");
        
        sizeGroup = new ButtonGroup();
        sizeGroup.add(smallRB);
        sizeGroup.add(mediumRB);
        sizeGroup.add(largeRB);
        
        // Pizza crust
        thinRB = new JRadioButton("Thin:                $1.18");
        medium_crustRB = new JRadioButton("Medium Crust: $2.36");
        panRB = new JRadioButton("Pan:                  $3.52");
        
        crustGroup = new ButtonGroup();
        crustGroup.add(thinRB);
        crustGroup.add(medium_crustRB);
        crustGroup.add(panRB);
        
        display = new JTextArea(20, 10);
        
        // Sizes 
        olivesCB.setSize(80, 30);
        mushroomsCB.setSize(120, 30);
        anchovyCB.setSize(120, 30);
        spinachCB.setSize(120, 30);
        echeeseCB.setSize(120, 30);
        
        smallRB.setSize(136, 30);
        mediumRB.setSize(150, 30);
        largeRB.setSize(136, 30);
        
        thinRB.setSize(172, 30);
        medium_crustRB.setSize(172, 30);
        panRB.setSize(172, 30);
        
        display.setSize(220, 180);
        
        total.setSize(115, 75);
        reset.setSize(115, 75);
        
        // Location
        olivesCB.setLocation(25, 90);
        mushroomsCB.setLocation(25, 110);
        anchovyCB.setLocation(25, 130);
        spinachCB.setLocation(25, 150);
        echeeseCB.setLocation(25, 170);
        
        smallRB.setLocation(160, 90);
        mediumRB.setLocation(160, 110);
        largeRB.setLocation(160, 130);
        
        thinRB.setLocation(310, 90);
        medium_crustRB.setLocation(310, 110);
        panRB.setLocation(310, 130);
       
        display.setLocation(30, 225);
        
        total.setLocation(25, 425);
        reset.setLocation(140, 425);
        
        // Listener
        olivesCB.addItemListener(this);
        mushroomsCB.addItemListener(this);
        anchovyCB.addItemListener(this);
        spinachCB.addItemListener(this);
        echeeseCB.addItemListener(this);
        
        smallRB.addItemListener(this);
        mediumRB.addItemListener(this);
        largeRB.addItemListener(this);
        
        thinRB.addItemListener(this);
        medium_crustRB.addItemListener(this);
        panRB.addItemListener(this);
        
        total.addActionListener(this);
        reset.addActionListener(this);
        
        // Add to applet
        c.add(olivesCB);
        c.add(mushroomsCB);
        c.add(anchovyCB);
        c.add(spinachCB);
        c.add(echeeseCB);
        
        c.add(smallRB);
        c.add(mediumRB);
        c.add(largeRB);
        
        c.add(thinRB);
        c.add(medium_crustRB);
        c.add(panRB);
        
        c.add(display);
        
        c.add(total);               
        c.add(reset);            
        
        display.setEditable(false);        
    }
        
    public void paint( Graphics g)
    {
        super.paint (g);
        
        // Main title
        g.setColor(Color.red);
        g.setFont(new Font("Courier", Font.BOLD, 48));
        g.drawString("LUCKY MAN PIZZA", 33, 50);
        
        // Borders
        g.setColor(Color.orange);
        g.drawRoundRect(20, 60, 120, 140, 10, 10);  
        g.drawRoundRect(152, 60, 145, 140, 10, 10);
        g.drawRoundRect(310, 60, 175, 140, 10, 10);
        
        // Secondary titles
        g.setColor(Color.blue);
        g.setFont(new Font("Courier", Font.BOLD, 16));
        g.drawString("INGRIDIENTS", 23, 80);
        
        g.setColor(Color.blue);
        g.setFont(new Font("Courier", Font.BOLD, 16));
        g.drawString("SIZE", 200, 80);
        
        g.setColor(Color.blue);
        g.setFont(new Font("Courier", Font.BOLD, 16));
        g.drawString("LAYER", 377, 80);       
        
        // Address
        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.BOLD, 18));
        g.drawString("613 Las Vegas Blvd", 275, 445);
        g.drawString("Las Vegas, NV", 275, 465);
        g.drawString("702-611-2626", 275, 485);
        
        // Pizza man image
        g.drawImage(poster, 260, 215, this);
        
        display.setText("Your Order Is:");
    }
         
    public void itemStateChanged(ItemEvent e)
    {
        // Pizza ingredients events
        if (e.getSource() == olivesCB) 
        {
            if (e.getStateChange() == ItemEvent.SELECTED){
                T = T + .49;
                olivesS = "Olives: $.49 ";
            }
                
            if(e.getStateChange() == ItemEvent.DESELECTED){
                T = T - .49;
                olivesS = "";
                
            }
        }
            
        if (e.getSource() == mushroomsCB)
        {
            if (e.getStateChange() == ItemEvent.SELECTED){
                T = T + .49;
                mushroomsS = "Mushrooms: $.49 ";
            }
            
            if (e.getStateChange() == ItemEvent.DESELECTED){
                T = T - .49;
                mushroomsS = "";
            }
        }
            
        if (e.getSource() == anchovyCB)
        {            
            if (e.getStateChange() == ItemEvent.SELECTED){
                T = T + .49;
                anchovyS = "Anchovy: $.49 ";
            }
            
            if (e.getStateChange() == ItemEvent.DESELECTED){
                T = T - .49;
                anchovyS = "";
            }
        }
            
        if (e.getSource() == spinachCB)
        {
            if (e.getStateChange() == ItemEvent.SELECTED){
                T = T + .49;
                spinachS = "Spinach: $.49 ";
            }
            
            if (e.getStateChange() == ItemEvent.DESELECTED){
                T = T - .49;
                spinachS = "";
            }
        }
            
        if (e.getSource() == echeeseCB)
        {
            if (e.getStateChange() == ItemEvent.SELECTED){
                T = T + .49;
                echeeseS = "Extra Cheese: $.49";
            }
            
            if (e.getStateChange() == ItemEvent.DESELECTED){
                T = T - .49;
                echeeseS = "";
            }
        }
        
        // Pizza size events
        if (e.getSource() == smallRB) 
        {
            largeS = "";
            SIZE = 9.98;
            smallS = "Small: $9.98";
            mediumS = "";
        }
        
        if(e.getSource() == mediumRB)   
        {
            smallS = "";                
            SIZE =  13.36;
            mediumS = "Medium: $13.36";
            largeS = "";
        }  
        
        if (e.getSource() == largeRB)
        {
            mediumS = "";
            SIZE = 19.52;
            largeS = "Large: $19.52";
            smallS = "";
        }
        
        // Pizza crust events
        if (e.getSource() == thinRB)
        {
            panS = "";
            CRUST = 1.18;
            thinS = "Thin: $1.18";
            medium_crustS = "";
        }
            
        if (e.getSource() == medium_crustRB)
        {
            thinS = "";
            CRUST = 2.36;
            medium_crustS = "Medium Crust: $2.36";
            panS = "";
        }
                   
        if (e.getSource() == panRB)
        {
            medium_crustS = "";
            CRUST = 3.52;
            panS = "Pan: $3.52";
            thinS = "";
        }
      
       // What is displayed on the screen 
       display.setText("Toppings: \n\n" + olivesS + "\n" + mushroomsS + "\n" + anchovyS + "\n" + spinachS + "\n" + echeeseS + "\n" + 
       "\n" + smallS + mediumS + largeS + "\n" + "\n" + thinS + medium_crustS + panS);
    }
          
    public void actionPerformed(ActionEvent e)
    {
        // Reset button action
        if(e.getActionCommand().equals("Reset"))
        {
           sizeGroup.clearSelection();
           crustGroup.clearSelection();
           
           olivesCB.setSelected(false);
           mushroomsCB.setSelected(false);
           anchovyCB.setSelected(false);
           spinachCB.setSelected(false);
           echeeseCB.setSelected(false);

           SIZE = 0;
           CRUST = 0;
           T = 0;
           
           display.setText("Your Order Is:");
           
           clears.play();       
        }   
     
        // Process order button action
        if(e.getActionCommand().equals("Process Order"))
        {
          cash.play();  
            
          String TStr = String.format("%.2f", (T+SIZE+CRUST));
          JOptionPane.showMessageDialog(null, "Your Total Is: $"+ TStr, "TOTAL", JOptionPane.INFORMATION_MESSAGE);
          JOptionPane.showMessageDialog(null, "Your Order Is On Its Way!", "IN ROUTE", JOptionPane.INFORMATION_MESSAGE);  
        }        
    }    
}
