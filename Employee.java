import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
	private String name, id;
	private double salary;
	private String address;
	private Date dateOfBirth;
	private Date dateOfJoin;
	
	public Employee(String name, String id, double salary, String address, Date dateOfBirth, Date dateOfJoin) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoin = dateOfJoin;
	}
	
	public String toString() {
		return "\nName: "+name+"\nId: "+id+"\nSalary: "+salary+"Address: "+address+"\nDate Of Birth: "+dateOfBirth+
				"\nDate Of Join: "+dateOfJoin+"\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	
	public String getEmployeeId() {
		return id;
	}
}
