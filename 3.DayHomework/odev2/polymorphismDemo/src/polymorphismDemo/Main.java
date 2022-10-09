package polymorphismDemo;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		/*
		 * EmailLogger logger = new EmailLogger(); logger.log("Log mesaj�");
		 * 
		 * BaseLogger[] loggers = new BaseLogger[] { new FileLogger(), new
		 * DatabaseLogger(), new EmailLogger(), new ConsoleLogger() }; for (BaseLogger
		 * logger : loggers) { logger.log("Log mesaj�"); }
		 */
		CustomerManager customerManager = new CustomerManager(new DatabaseLogger());
		customerManager.add();

	}
}
