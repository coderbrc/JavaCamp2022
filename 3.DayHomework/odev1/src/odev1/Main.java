package odev1;

import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		/*
		 * CreditdManager creditManager = new CreditdManager();
		 * creditManager.Calculate(); creditManager.Save(); Customer customer = new
		 * Customer(); customer.Id = 1; customer.City = "Ankara";
		 * 
		 * CustomerManager customerManager = new CustomerManager(customer);
		 * customerManager.Save(); customerManager.Delete(); Company company = new
		 * Company(); company.CompanyName = "Arçelik"; company.TaxNumber = "100000";
		 * company.Id = 100; CustomerManager customerManager2=new CustomerManager(new
		 * Person()); Person person=new Person(); person.FirstName="Aa";
		 * person.LastName="bb"; person.Nationalidentity="10000";
		 */
		CustomerManager customerManager = new CustomerManager(new Customer(), new TeacherCreditManager());
		customerManager.GiveCredit();
	}
}

class CreditdManager {
	public void Calculate() {
		System.out.println("Hesaplandý.");
	}

	public void Save() {
		System.out.println("Kredi verildi");
	}
}

class Customer {
	public Customer() {
		System.out.println("Müþteri baþlatýldý.");
	}

	public int Id;

	public String City;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

}

class Person extends Customer {
	public String FirstName;
	public String LastName;
	public String Nationalidentity;

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getNationalidentity() {
		return Nationalidentity;
	}

	public void setNationalidentity(String nationalidentity) {
		Nationalidentity = nationalidentity;
	}
}

class Company extends Customer {
	public String CompanyName;
	public String TaxNumber;
}

class CustomerManager {
	private Customer _customer;
	private ICreditManager _creditManager;

	public CustomerManager(Customer customer, ICreditManager creditManager) {
		_customer = customer;
		_creditManager = creditManager;
	}

	public void Calculate() {
		System.out.println("Hesaplandý.");
	}

	public void Save() {
		System.out.println("Müþteri kaydedildi.");
	}

	public void Delete() {
		System.out.println("Müþteri silindi.");
	}

	public void GiveCredit() {
		_creditManager.Calculate();
		System.out.println("Kredi verildi.");
	}
}

interface ICreditManager {
	public void Calculate();

	public void Save();
}

abstract class BaseCreditManager implements ICreditManager {
	public abstract void Calculate();

	public void Save() {
		System.out.println("Kaydedildi");

	}
}

class MilitaryCreditManager extends BaseCreditManager implements ICreditManager {

	@Override
	public void Calculate() {
		System.out.println("Asker kredisi hesaplandý.");
	}
}

class TeacherCreditManager extends BaseCreditManager implements ICreditManager {

	@Override
	public void Calculate() {
		System.out.println("Öðretmen kredisi hesaplandý.");
	}

	public void Save() {
		System.out.println("Öðretmen Kaydedildi");
	}
}

class CarCreditManager extends BaseCreditManager implements ICreditManager {

	@Override
	public void Calculate() {
		System.out.println("Araba kredisi hesaplandý.");
	}
}