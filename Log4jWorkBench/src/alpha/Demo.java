package alpha;

import org.apache.logging.log4j.*;

public class Demo {

	private static Logger log = LogManager.getLogger(Demo.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		log.debug("I am debugging");

		log.info("2 is greater than 3");
		log.error("This is an error");

		log.fatal("A fatal message");

	}

}
