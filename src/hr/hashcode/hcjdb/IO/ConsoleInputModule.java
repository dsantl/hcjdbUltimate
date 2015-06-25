package hr.hashcode.hcjdb.IO;

import java.io.IOException;

import jline.console.ConsoleReader;

public class ConsoleInputModule {

	private ConsoleReader consoleReader = null;

	public ConsoleInputModule() {
		try {
			consoleReader = new ConsoleReader();
			consoleReader.setPrompt("> ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readLine() throws IOException {
		if (consoleReader != null)
			return consoleReader.readLine();
		else
			throw new IOException("ConsoleInputModule not initialized!");
	}

}
