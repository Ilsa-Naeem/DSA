package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.LinkedList;

public class StudentGUI extends JFrame
{
   // Constants:
private Container c;
private JTextArea studentTextArea;
private Font f1;
private JTextField cityTextField,rollnoTextField,nameTextField,numberTextField,cnicTextField;
private JLabel cityLabel,rollnoLabel,nameLabel,numberLabel,cnicLabel;
private JButton addButton,deleteButton,displayAllButton,exitButton,displayButton,deleteAllButton;
   // Class Instance Data:
private LinkedList<Student> studentLinkedList = new LinkedList<Student> ();

   public StudentGUI ()
   {
   studentTextArea   = new JTextArea ();
   f1=new Font("serif",Font.PLAIN,15);
   
   
   //rollno
   rollnoLabel         = new JLabel     ("ROLLNO: ");
   rollnoLabel.setFont(f1);
   rollnoLabel.setForeground(Color.BLACK);
   rollnoTextField       = new JTextField (10);
   rollnoTextField.setFont(f1);

   //name
   nameLabel         = new JLabel     ("Name: ");
   nameLabel.setFont(f1);
    nameLabel.setForeground(Color.BLACK);
   nameTextField     = new JTextField (10);
   nameTextField.setFont(f1);
   
   //number
   numberLabel         = new JLabel     ("Number: ");
   numberLabel.setFont(f1);
    numberLabel.setForeground(Color.BLACK);
   numberTextField     = new JTextField (10);
   numberTextField.setFont(f1);
   
   //cnic
   cnicLabel         = new JLabel     ("Cnic: ");
   cnicLabel.setFont(f1);
   cnicLabel.setForeground(Color.BLACK);
   cnicTextField     = new JTextField (10);
   cnicTextField.setFont(f1);
   
   //city
   cityLabel         = new JLabel     ("City: ");
   cityLabel.setFont(f1);
   cityLabel.setForeground(Color.BLACK);
   cityTextField     = new JTextField (10);
   cityTextField.setFont(f1);
     
    //buttons
   addButton         = new JButton ("Add");
   deleteButton      = new JButton ("Delete");
   displayAllButton  = new JButton ("Display All");
   exitButton        = new JButton ("Exit");
   displayButton     =new JButton("Display");
   deleteAllButton   =new JButton("delete All");
   
   
    c = this.getContentPane();
      JPanel bot = new JPanel();
      bot.setLayout(new FlowLayout(FlowLayout.CENTER)); 
      bot.setBackground(Color.gray);
      JPanel midPane = new JPanel();
      midPane.setBackground(Color.white);
      midPane.setLayout(new GridLayout(5,5,5,5));
      midPane.add(rollnoLabel);
      midPane.add(rollnoTextField);
      midPane.add(nameLabel);
      midPane.add(nameTextField);
      midPane.add(numberLabel);
      midPane.add(numberTextField);
      midPane.add(cnicLabel);
      midPane.add(cnicTextField);
      midPane.add(cityLabel);
      midPane.add(cityTextField);
      bot.add(addButton);
      bot.add(deleteButton);
      bot.add(deleteAllButton);
      bot.add(displayAllButton);
      bot.add(displayButton);
      bot.add(exitButton);
   
      
      c.add(midPane,BorderLayout.CENTER);
      c.add(bot,BorderLayout.PAGE_END);
      
      
      
      addButton.addActionListener        (event -> addStudent ());
      displayAllButton.addActionListener (event -> displayAll ());
      exitButton.addActionListener       (event -> exitApplication ());
      deleteButton.addActionListener     (event -> deleteStudent ());
      deleteAllButton.addActionListener     (event -> deleteAllStudent ());
      displayButton.addActionListener (event -> display());
      
      
      
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.pack();
   }

   private boolean isStudentIdInLinkedList (String rollno)
   {
      boolean inList = false;

      for (Student stud : studentLinkedList)
      {
         if (stud.getrollno ().compareToIgnoreCase (rollno) == 0)
         {
            inList = true;
         }
      }

      return inList;
   }

   private void addStudent ()
   {
      if (isStudentIdInLinkedList (rollnoTextField.getText()) == true)
      {
         JOptionPane.showMessageDialog (null, "Error: student ROLLNO is already in the database.");
      }
      else
      {
         try
         {
            Student stud = new Student (nameTextField.getText(),
            		                              rollnoTextField.getText(),
                                                  numberTextField.getText(),
                                                  cnicTextField.getText(),
                                                  cityTextField.getText());

            studentLinkedList.add (stud);

            displayAll ();

            nameTextField.setText("");
            rollnoTextField.setText("");
             numberTextField.setText("");
              cnicTextField.setText("");
              cityTextField.setText("");
         }
         catch (StudentException error)
         {
            JOptionPane.showMessageDialog (null, error.toString ());
            // myLabel.setText (error.toString ());


         }
      }
   }

   private void deleteStudent ()
   {
      if (studentLinkedList.size() == 0)
      {
         JOptionPane.showMessageDialog (null, "Error: Database is empty.");
      }
      else if (isStudentIdInLinkedList (rollnoTextField.getText()) == false)
      {
         JOptionPane.showMessageDialog (null, "Error: student ROLLNO is not in the database.");
      }
      else
      {
         for (int s = 0; s <studentLinkedList.size(); s++)
         {
            String currId = studentLinkedList.get (s).getrollno();

            if (currId.compareToIgnoreCase (rollnoTextField.getText()) == 0)
            {
               studentLinkedList.remove (s);
            }
         }

         displayAll ();

         nameTextField.setText("");
         rollnoTextField.setText("");
         numberTextField.setText("");
         cnicTextField.setText("");
         cityTextField.setText("");
      }
   }
   private void deleteAllStudent (){
	   if (studentLinkedList.size() == 0)
	      {
	         JOptionPane.showMessageDialog (null, "Error: Database is empty.");
	      }
	   else {
		   studentLinkedList.clear();
		  
	   }
	  displayAll();
       nameTextField.setText("");
       rollnoTextField.setText("");
       numberTextField.setText("");
       cnicTextField.setText("");
       cityTextField.setText("");
	   
	   
   }
   private void displayAll ()
   {   
	   if (studentLinkedList.size() == 0)
	      {
	         JOptionPane.showMessageDialog (null, "Error: Database is empty.");
	      }
	   else {
		   JFrame f = new JFrame("Data");
		   Container cont = f.getContentPane();
		   f.setSize(800,500);
		   f.setVisible(true);
		  
		   //f.pack();
		   cont.add(studentTextArea);

		      studentTextArea.setText ("");

		      for (Student stud : studentLinkedList)
		      {
		         studentTextArea.append (stud+"\n");
		      }
		      
		      nameTextField.setText("");
		      rollnoTextField.setText("");
		      numberTextField.setText("");
		      cnicTextField.setText("");
		      cityTextField.setText("");
	   }
   }
   
   
   private void display() {
	 
	   if (studentLinkedList.size() == 0)
	      {
	         JOptionPane.showMessageDialog (null, "Error: Database is empty.");
	      }
	      else if (isStudentIdInLinkedList (rollnoTextField.getText()) == false)
	      {
	         JOptionPane.showMessageDialog (null, "Error: student ROLLNO is not in the database.");
	      }
	      else {
	    	  JFrame f1 = new JFrame("Data");
	   	   Container cont = f1.getContentPane();
	   	   f1.setSize(800,500);
	   	   f1.setVisible(true);
	   	   //f.pack();
	   	   cont.add(studentTextArea);

	   	      studentTextArea.setText ("");
	   	      
	   	     
	   	      for (int s = 0; s <studentLinkedList.size(); s++)
	   	         {
	   	            String currId = studentLinkedList.get (s).getrollno();

	   	            if (currId.compareToIgnoreCase (rollnoTextField.getText()) == 0)
	   	            {
	   	            	 studentTextArea.append (studentLinkedList.get (s) + "\n");
	   	            }
	   	         }
	   	      nameTextField.setText("");
	   	         rollnoTextField.setText("");
	   	         numberTextField.setText("");
	   	         cnicTextField.setText("");
	   	         cityTextField.setText("");
	      }
   }
   private void exitApplication ()
   {
      System.exit (0); // All is OK.
   }

   public static void main (String[] args)
   {
      StudentGUI app = new StudentGUI ();

      app.setVisible  (true);
      app.setSize     (500, 310);
      app.setLocation (200, 100);
      

      
     
    

   }
} 