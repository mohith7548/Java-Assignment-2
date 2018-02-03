import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeExample implements Serializable {
	public static Scanner in = new Scanner(System.in);
	public static FileOutputStream fos = null;
	public static ObjectOutputStream out = null;
	public static FileInputStream fis = null;
	public static ObjectInputStream oin = null;
	public static List<Employee> emp = new ArrayList<Employee>();
	public static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] kune) {
		int n = 0;
		while(true) {
			System.out.println("Have an Option\n0>Load Employee database\n1>Add an Employee\n2>Modify the details of an existing Employee" +  
								"\n3>Display details of an existing Employee\n4>Display Top n number of Employees based on Expirence" 
								+ "\n5>Display Top n number of Employees based on Salary\n6>Save and Exit\n7.Diaplay all Employees");
			
			int choice = in.nextInt();
			switch(choice) {
			case 0:
				loadDatabase();
				break;
			case 1:
				AddEmployee();
				break;
				
			case 2:
				ModifyEmployee();
				break;
				
			case 3:
				DisplayEmpDetails();
				break;
				
			case 4:
				//sort on basis of experience
				Collections.sort(emp, new Comparator<Employee>() {
			        @Override
			        public int compare(Employee o1, Employee o2) {
			        	if (o1.getDateOfJoin().before(o2.getDateOfJoin()) ) {
			                return -1;
			            } else if (o1.getDateOfJoin().after(o2.getDateOfJoin()) ) {
			                return 1;
			            } else {
			                return 0;
			            }        
			        }
			    });
				n = (emp.size() > 5)? 5 : emp.size(); 
				for(int i=0; i<n; ++i) {
					Employee e = emp.get(i);
					System.out.println(e.toString());
				}
				break;
				
			case 5:
				//Sorting Based on Salary
				Collections.sort(emp, new Comparator<Employee>() {
			        @Override
			        public int compare(Employee o1, Employee o2) {
			            return Double.compare(o1.getSalary(), o2.getSalary());
			        }
			    });
				n = (emp.size() > 5)? 5 : emp.size();
				for(int i=0; i<n; ++i) {
					Employee e = emp.get(i);
					System.out.println(e.toString());
				}
				break;
				
			case 6:
				saveAndExit();
				System.exit(0);
				
			case 7:
				displayAllEmployees();
				break;
			}
		}
	}
	
	public static long dateDifference(Date date1, Date date2) {
		long diff = date2.getTime() - date1.getTime();
		//return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return (diff/(1000 * 60 * 60 * 24));
	}
	
	private static void saveAndExit() {
		try {
			fos = new FileOutputStream("employee_database");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(emp);
			out.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void loadDatabase() {
		File file = new File("employee_database");
		if(file.exists()) {
			try {
				fis = new FileInputStream("employee_database");
				oin = new ObjectInputStream(fis);
				emp = (List<Employee>) oin.readObject();
				oin.close();
				fis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("Database Loaded Successfully!!");
		} else {
			System.out.println("File doesn't exist!!!!");
		}
	}

	private static void displayAllEmployees() {
		Iterator<Employee> it = emp.iterator();
		while(it.hasNext()) {
			Employee m = (Employee) it.next();
			System.out.println(m.toString());
		}
	}
	
	private static void DisplayEmpDetails() {
		System.out.println("Enter the Employee Id :");
		String employeeId = in.nextLine();
		employeeId = in.nextLine();
		System.out.println("the Employee Id :" + employeeId);
		Iterator<Employee> it = emp.iterator();
		while(it.hasNext()) {
			Employee e = (Employee) it.next();
			if(e.getEmployeeId().equals(employeeId)) {
				System.out.println(e.toString());
				return;
			}else {
				System.out.println("Id is incorrect!!");
			}
		}
	}

	private static void ModifyEmployee() {
		System.out.println("Enter the Employee Id :");
		String employeeId = in.nextLine();
		employeeId = in.nextLine();
		Iterator<Employee> it = emp.iterator();
		String buf;
		while(it.hasNext()) {
			Employee e = (Employee)it.next();
			if(e.getEmployeeId().equals(employeeId)) {
				System.out.println("Enter the choice to Modify: \n1.Name\n2.salary\n3.address\n4.dateOfBirth\n5.dateOfJoin");
				int choice = in.nextInt();
				switch(choice) {
				case 1:
					System.out.print("Enter new Name: ");
					buf = in.nextLine();
					e.setName(in.nextLine());
					break;
					
				case 2:
					System.out.print("Enter new salary: ");
					buf = in.nextLine();
					e.setSalary(in.nextDouble());
					break;
					
				case 4:
					System.out.print("Enter new dataOfBirth: ");
					buf = in.nextLine();
					String str = in.nextLine();
					try {
						e.setDateOfBirth(formatter.parse(str));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					break;
				
				case 5:
					System.out.print("Enter new dataOfJoin: ");
					buf = in.nextLine();
					String str1 = in.nextLine();
					try {
						e.setDateOfJoin(formatter.parse(str1));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					break;
					
				case 3:
					System.out.println("Enter new Address: ");
					buf = in.nextLine();
					e.setAddress(in.nextLine());
					break;
				}
				break;
			}
		}
	}

	private static void AddEmployee() {
		String name, id;
		double salary;
		String address;
		Date dateOfBirth = null, dateOfJoin = null;
		
		System.out.print("Enter Name: ");
		name = in.nextLine();
		name = in.nextLine();
		System.out.print("Enter id: ");
		id = in.nextLine();
		System.out.print("Enter salary: ");
		salary = in.nextDouble();
		System.out.print("Enter address :");
		address = in.nextLine();
		address = in.nextLine();
		System.out.println("Enter date in format dd/MM/yyyy");
		
		System.out.println("Enter Date of Birth: ");
		String buf = in.nextLine();
		try {
			dateOfBirth = formatter.parse(buf);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		System.out.println("Enter Date of Join: ");
		buf = in.nextLine();
		try {
			dateOfJoin = formatter.parse(buf);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		Employee e = new Employee(name, id, salary, address, dateOfBirth, dateOfJoin);
		emp.add(e);
	}
}
