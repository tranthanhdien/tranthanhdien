package lt.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerComputing extends Thread {
	final static int port = 555;
	Socket sc;
	BufferedReader br;
	PrintWriter pw;

	public ServerComputing(Socket sc, BufferedReader br, PrintWriter pw) {
		super();
		this.sc = sc;
		this.br = br;
		this.pw = pw;
	}

	// xử lý phép tính + - * /
	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			String st = br.readLine();
			String[] line = st.split(" ");
			String startA = line[0];
			String operate = line[1];
			String startB = line[2];
			String result = st + "= ";
			pw = new PrintWriter(new OutputStreamWriter(sc.getOutputStream()));
			if (st.equalsIgnoreCase("EXIT")) {
				System.out.println("Goodbye^^");
				pw.close();
				sc.close();
				return;
			}
			int a = 0;
			int b = 0;
			double total = 0;
			while (line != null) {
				try {
					a = Integer.parseInt(startA);
					b = Integer.parseInt(startB);
				} catch (NumberFormatException e) {
					System.out.println("Number....incorrect");
				}
				if (operate.equals("+")) {
					total = a + b;
				} else if (operate.equals("-")) {
					total = a - b;
				} else if (operate.equals("*")) {
					total = a * b;
				} else if (operate.equals("/")) {
					if (b != 0) {
						total = a / b;
					} else {
						System.out.println("Incorrect");
					}
				}
				else {
					System.out.println(""); // không nằm trong phép toán 
				}

				result += total;
				System.out.println(result);

				pw.println(result);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(port);
		System.out.println("Start connection");
		System.out.println("Waiting...");
		Socket sc = null;
		while (true) {
			sc = ss.accept();
			System.out.println("Accept connection");
			BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sc.getOutputStream())); // lấy ra đưa nó đi
			ServerComputing s = new ServerComputing(sc, br, pw);
			s.start();
		}
	}
	
}
