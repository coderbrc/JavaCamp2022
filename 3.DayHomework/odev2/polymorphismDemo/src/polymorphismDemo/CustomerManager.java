package polymorphismDemo;

public class CustomerManager {
	public CustomerManager(BaseLogger baseLogger) {
		this.baseLogger = baseLogger;
	}

	private BaseLogger baseLogger;

	public void add() {
		System.out.println("Müþteri eklendi.");
		/*
		 * DatabaseLogger logger = new DatabaseLogger(); logger.log("Log mesajý");
		 */
		this.baseLogger.log("log mesajý");
	}
}
