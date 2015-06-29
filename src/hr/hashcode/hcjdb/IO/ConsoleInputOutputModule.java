package hr.hashcode.hcjdb.IO;

import java.io.IOException;

import jline.console.ConsoleReader;

public class ConsoleInputOutputModule {

	private static ConsoleReader consoleReader;
	private static boolean input = false;

	static {
		try {
			consoleReader = new ConsoleReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readLine() throws IOException {
		if (consoleReader != null) {
			input = true;
			String ret = consoleReader.readLine();
			input = false;
			return ret;
		} else
			throw new IOException("ConsoleInputModule not initialized!");
	}

	public static void println(String line) {
		try {
			consoleReader.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void print(String line) {
		try {
			consoleReader.print(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void print(char c) {
		CharSequence out = String.valueOf(c);
		try {
			consoleReader.print(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void println() {
		println("");
	}

	public static void flush() {
		try {
			consoleReader.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printPrompt(String prompt) {
		consoleReader.setPrompt(prompt);
		try {
			if (input)
				consoleReader.redrawLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
