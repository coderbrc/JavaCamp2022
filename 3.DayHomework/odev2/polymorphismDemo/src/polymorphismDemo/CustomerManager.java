package polymorphismDemo;

public class CustomerManager {
	public CustomerManager(BaseLogger baseLogger) {
		this.baseLogger = baseLogger;
	}

	private BaseLogger baseLogger;

	public void add() {
		System.out.println("M��teri eklendi.");
		/*
		 * DatabaseLogger logger = new DatabaseLogger(); logger.log("Log mesaj�");
		 */
		this.baseLogger.log("log mesaj�");
	}
}
