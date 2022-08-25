package Lambda4;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Person {
	public enum Sex {
        MALE, FEMALE
    }

	
	
    public Person() {
		
	}



	public Person(String name, LocalDate birthday, Person.Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}



	String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

    public int getAge() {
    	LocalDate currentdate = LocalDate.now();
    	 if ((birthday != null) && (LocalDate.now() != null)) {
             return Period.between(birthday, currentdate).getYears();
         } else {
             return 0;
         }
    }

    public void printPerson() {
        System.out.println(this.getName()+" "+this.getAge()+" "+this.getGender()+" "+this.getEmailAddress());;
    }
    
    public Person.Sex getGender() {
    	return this.gender;
    }
    
    public String getEmailAddress() {
    	return this.emailAddress;
    }
    
    
    
    public static List<Person> createRoster() {
    	List<Person> list=new ArrayList<Person>();
    	/*int cant = 0;
    	cant = Integer.parseInt(JOptionPane.showInputDialog("type amount of person"));
    	for (int i = 0; i < cant; i++) {
    		Person p = new Person();
    		String nombre = JOptionPane.showInputDialog("type name");
        	p.setName(nombre);
        	int year = Integer.parseInt(JOptionPane.showInputDialog("type year of birthday"));
        	int month = Integer.parseInt(JOptionPane.showInputDialog("type month of birthday"));
        	int day = Integer.parseInt(JOptionPane.showInputDialog("type day of birthday"));
        	p.setBirthday(LocalDate.of(year, month, day));
        	String[] Sexo = new String[] {"MALE", "FEMALE"};
        	int sex = JOptionPane.showOptionDialog(null, "Select sex","Click a button",
                    	 JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Sexo, Sexo[0]);
        	if (sex == 0) {
        		p.setGender(Sex.MALE);
			}
        	else {
        		p.setGender(Sex.FEMALE);
			}
        	String correo = JOptionPane.showInputDialog("type email");
        	p.setEmailAddress(correo);
        	list.add(p);

		}*/
    	//Person p = new Person("Luis", LocalDate.of(2000, 5, 5), Sex.MALE, "luiguister@gmail.com");
    	Person p;
    	p = new Person("nombre-5", LocalDate.of(1991, 5, 5), Sex.FEMALE, "mail-5@gmail.com");
    	list.add(p);
    	p = new Person("nombre-4", LocalDate.of(1992, 5, 5), Sex.MALE, "mail-4@gmail.com");
    	list.add(p);
    	p = new Person("nombre-3", LocalDate.of(1993, 5, 5), Sex.FEMALE, "mail-3@gmail.com");
    	list.add(p);
    	p = new Person("nombre-2", LocalDate.of(1994, 5, 5), Sex.MALE, "mail-2@gmail.com");
    	list.add(p);
    	p = new Person("nombre-1", LocalDate.of(1995, 5, 5), Sex.FEMALE, "mail-1@gmail.com");
    	list.add(p);
    	p = new Person("nombre", LocalDate.of(1996, 5, 5), Sex.MALE, "mail@gmail.com");
    	list.add(p);//26
    	p = new Person("nombre2", LocalDate.of(1997, 5, 5), Sex.FEMALE, "mail2@gmail.com");
    	list.add(p);
    	p = new Person("nombre3", LocalDate.of(1998, 5, 5), Sex.MALE, "mail3@gmail.com");
    	list.add(p);
    	p = new Person("nombre4", LocalDate.of(1999, 5, 5), Sex.FEMALE, "mail4@gmail.com");
    	list.add(p);
    	p = new Person("nombre5", LocalDate.of(2000, 5, 5), Sex.MALE, "mail5@gmail.com");
    	list.add(p);
    	p = new Person("nombre6", LocalDate.of(2001, 5, 5), Sex.FEMALE, "mail6@gmail.com");
    	list.add(p);
    	p = new Person("nombre7", LocalDate.of(2002, 5, 5), Sex.MALE, "mail7@gmail.com");
    	list.add(p);
    	p = new Person("nombre8", LocalDate.of(2003, 5, 5), Sex.FEMALE, "mail8@gmail.com");
    	list.add(p);
    	p = new Person("nombre9", LocalDate.of(2004, 5, 5), Sex.MALE, "mail9@gmail.com");
    	list.add(p);
    	p = new Person("nombre10", LocalDate.of(2005, 5, 5), Sex.FEMALE, "mail10@gmail.com");
    	list.add(p); //17
    	p = new Person("nombre11", LocalDate.of(2006, 5, 5), Sex.MALE, "mail12@gmail.com");
    	list.add(p);
    	p = new Person("nombre12", LocalDate.of(2007, 5, 5), Sex.FEMALE, "mail13@gmail.com");
    	list.add(p);
    	p = new Person("nombre13", LocalDate.of(2008, 5, 5), Sex.MALE, "mail14@gmail.com");
    	list.add(p);
    	p = new Person("nombre14", LocalDate.of(2009, 5, 5), Sex.FEMALE, "mail15@gmail.com");
    	list.add(p);
    	return list;
    }

}
