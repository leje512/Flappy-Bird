package lumenaer;

import java.util.Arrays;
import java.util.List;

public class LumenaerStarter {

	/**
	 * Main method to start Lumenaer as an Application
	 */
	public static void main(String args[]) {

		List<String> arguments = Arrays.asList(args);

		boolean hardwareMatrixMode;

		// args are given
		if (arguments.size() > 0 && arguments.get(0).equals("true")) {
			hardwareMatrixMode = true;
		} else {
			hardwareMatrixMode = false;
		}

		Lumenaer lumenaer = new Lumenaer(hardwareMatrixMode);
		lumenaer.setup();

		try {
			lumenaer.runForever();
		} catch (Exception e) {
			System.out.println("Programm aborted due to an exception!");
			e.printStackTrace();
		}
	}
		
}
