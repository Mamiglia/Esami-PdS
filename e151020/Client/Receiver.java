package e151020.Client;

import java.util.Scanner;

class Receiver implements Runnable {
	private final GUI frame;
	private final Scanner input;
	private boolean finished = false;

	Receiver(GUI frame, Scanner input) {
		this.frame = frame;
		this.input = input;
	}


	@Override
	public void run() {

		while (!finished && input.hasNextLine()) {
			String s = input.nextLine();
			System.out.println("Received: " + s);
			if (s.equals("END")) {
				frame.write("=======Download Completato=======");
				finished = true;
				frame.setStatus(true, false);
			} else if (s.equals("INTERRUPTED")) {
				frame.write("=======Download Interrotto=======");
				finished = true;
				frame.setStatus(true, false);
			} else if (s.equals("ERROR"))  {
				frame.write("=============Errore============");
				finished = true;
				frame.setStatus(false, false);
			} else if (s.equals("=========File Not Found=========")) {
				frame.write("File non trovato");
				finished = true;
				frame.setStatus(true, false);
			} else {
				frame.write(s);
			}
		}


	}
}
