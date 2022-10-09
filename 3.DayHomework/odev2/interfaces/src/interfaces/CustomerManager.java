package interfaces;

public class CustomerManager {
	/*
	 * ICustomerDal customerDal;
	 * 
	 * public void add() { customerDal.Add(); }
	 */
	ICustomerDal _customerDal;

	public CustomerManager(ICustomerDal customerDal) {
		_customerDal = customerDal;
	}

	public void add() {
		_customerDal.Add();
	}
}