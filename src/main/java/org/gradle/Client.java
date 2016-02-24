package org.gradle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 4700);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String readline;
			readline = sin.readLine();
			while (!readline.equals("bye")) {
				os.println(readline);
				os.flush();
				System.out.println("Client:" + readline);
				System.out.println("Server:" + in.readLine());
				readline = sin.readLine();
			}
			os.close();
			in.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
	}

}
