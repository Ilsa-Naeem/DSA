package project;
import java.util.Random;
public class Student {
	  public static final String EMAIL_STUB = "@my.email";
	  Random rand = new Random();
	  int upperbound=255;
	   private String name;
	   private String rollno;
	   private String number;
	   private String cnic;
	   private String city;
	   private StringBuffer email;
	   
	   public Student()
	   {
	      name = "";
	      rollno   = "";
	      number ="";
	      cnic="";
	      city="";
	     
	   }

	   public Student (String name, String rollno,String number,String cnic,String city)
	   
	                        throws StudentException
	   {
	      // Remove elading and trailing spaces, tabs.
	      name = name.trim ();
	      rollno   = rollno.trim ();
	      number = number.trim ();
	      cnic = cnic.trim ();
	      city = city.trim ();
	      
	      if (name.length () == 0)
	      {
	         //JOptionPane.showMessageDialog (null, "Error: name cannot be blank.");
	         throw new StudentException ("Error: name cannot be blank.");
	      }

	      else if (rollno.length () == 0)
	      {
	         //JOptionPane.showMessageDialog (null, "Error: Id cannot be blank.");
	         throw new StudentException ("Error: Id cannot be blank.");
	      }

	      else if (number.length () == 0)
	      {
	         //JOptionPane.showMessageDialog (null, "Error: number cannot be blank.");
	         throw new StudentException ("Error: number cannot be blank.");
	      }
	      else if(number.length()>11 || number.length()<11){
	    	//JOptionPane.showMessageDialog (null, "number must be of length 11.");
		         throw new StudentException ("Error: number must be of length 11.");
	      }
	       else if (cnic.length () == 0)
	      {
	         //JOptionPane.showMessageDialog (null, "Error: cnic cannot be blank.");
	         throw new StudentException ("Error: cnic cannot be blank.");
	      }
	      else if (cnic.length () >13 || cnic.length ()< 13 )
		      {
		         //JOptionPane.showMessageDialog (null, "Error: cnic must be of length 11.");
		         throw new StudentException ("Error: cnic must be of length 13.");
		      }
	       else if (city.length () == 0)
	      {
	         //JOptionPane.showMessageDialog (null, "Error: city cannot be blank.");
	         throw new StudentException ("Error: city cannot be blank.");
	      }



	      else
	      {
	         // All is OK, set class data to the values passed in.
	         this.name = name;
	         this.rollno   = rollno;
	         this.number = number;
	         this.cnic = cnic;
	         this.city = city;
	      }
	      email=new StringBuffer(this.rollno+"_");
	      email.append(rand.nextInt(upperbound));
	   }

	   public String getName ()
	   {
	      return name;
	   }

	   public String getrollno()
	   {
	      return rollno;
	   }
	    public String getNumber ()
	   {
	      return number;
	   }
	   public String getCnic ()
	   {
	      return cnic;
	   }
	    public String getCity ()
	   {
	      return city;
	   }

	   public void setName (String name)
	   {
	      this.name = name;
	   }

	   public void setrollno (String rollno)
	   {
	      this.rollno = rollno;
	   }
	    public void setNumber (String Number)
	   {
	      this.number = number;
	   }
	   public void setCnic (String Number)
	   {
	      this.cnic = cnic;
	   }
	   public void setCity (String Number)
	   {
	      this.city = city;
	   }
	   
//Math.floor(Math.random()*(255-0+1)+0)

	   @Override
	   public String toString ()
	   {
	      return rollno + "\t" + name + "\t" + number + "\t " + cnic + "\t "+ city + "\t "+email+ EMAIL_STUB;
	   }
}
