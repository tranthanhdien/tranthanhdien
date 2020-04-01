package POP3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerPOP3 extends Thread {
	BufferedReader br;
	PrintWriter pw;
	static final int port = 5555;
	Socket sc;
	static ArrayList<Student> listStudents = new ArrayList<Student>();
	static ArrayList<User> listUsers = new ArrayList<User>();

	public ServerPOP3(BufferedReader br, PrintWriter pw, Socket sc) {
		this.br = br;
		this.pw = pw;
		this.sc = sc;
	}

	@Override
	public void run() {

		try {
			br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(sc.getOutputStream()), true);
			boolean check = checkLogin(br, pw);
			if (check == true) {
				pw.println("Login Success");
				findInformationStu(br, pw);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// check user
	public boolean checkLogin(BufferedReader in, PrintWriter out) throws IOException {
		
		while (true) {
			boolean result = false;
			in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(sc.getOutputStream()), true);
			String line = in.readLine();
			String[] infor = line.split(" ");
			String command = infor[0];
			String check = infor[1];
			for (User user : listUsers) {
				if (command.equalsIgnoreCase("USER")) {
					out.println("OK USER");
					if (user.getUserName().equalsIgnoreCase(check)) {
						result = true;
						out.println("UserName ok!");
						return result;
					} else {
						result = false;
						out.println("UserName fail!");
					}
				} else if (command.equalsIgnoreCase("PASS")) {
					out.println("OK PASS");
					if (user.getPass().equalsIgnoreCase(check)) {
						result=true;
						out.println("Password ok");
						return result;

					} else {
						result = false;	
						out.println("Password fail!");
					}
				} else {
					out.println("No found command");
				}
			}
			return result;
		}

	}

	//
	public String findInformationStu(BufferedReader in, PrintWriter pw) {
		String result = "";
		BufferedReader receiveFromClient;
		try {
			receiveFromClient = new BufferedReader(new InputStreamReader(sc.getInputStream()));

			String inputUser = receiveFromClient.readLine();
			System.out.println("input user: " + inputUser);
			PrintWriter sendToClient = new PrintWriter(new OutputStreamWriter(sc.getOutputStream()), true);
			// b3: xu li yeu cau
			String[] arr = inputUser.split(" ");
			String method = arr[0];
			while (arr != null) {
				if (arr.length == 1) {
					if (method.equalsIgnoreCase("findList")) {
						result = "";
					} else if (method.equalsIgnoreCase("Exit")) {
						/// close connect
						System.out.println("GoodBye!");
						result = "Exit";
						sc.close();
						return result;

					}

				} else if (arr.length == 2) {
					String findObect = arr[1];

					if (method.equalsIgnoreCase("findByName")) {
						System.out.println();
						result = findByName(findObect);

					}
					// tach lam 2 phuong thuc lon hon va nho hon
					if (method.equalsIgnoreCase("findByUpperAge")) {
						result = findByUpperAge(Integer.parseInt(findObect));
					} else if (method.equalsIgnoreCase("findByUderAge")) {
						result = findByUnderAge(Integer.parseInt(findObect));
					} else if (method.equalsIgnoreCase("findByUpperScore")) {
						result = findByUpperScore(Double.parseDouble(findObect));
					} else if (method.equalsIgnoreCase("findByUnderScore")) {
						result = findByUnderScore(Double.parseDouble(findObect));
					} else {
						/// other command
						result = "No found command";
					}

				} else {
					// ko dung cu phap
					result = " No Format";
				}

				// b4: gui ve Client

				sendToClient.println(result);
				System.out.println(result);
				break;

				// b5: dong nguon
				// socket.close();
				// server.close();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static ArrayList<User> generateListUser() {
		if (listUsers == null) {
			listUsers = new ArrayList<User>();
		} else {
			listUsers.add(new User("ttdien", "1111"));
			listUsers.add(new User("dvda", "2222"));
			listUsers.add(new User("abc", "3333"));
			listUsers.add(new User("dcf", "4444"));

		}
		return listUsers;
	}

	public static ArrayList<Student> generateListStudent() {
		if (listStudents == null) {
			listStudents = new ArrayList<Student>();
		} else {
			listStudents.add(new Student("dien", 20, 9.5));
			listStudents.add(new Student("da", 15, 10));
			listStudents.add(new Student("binh", 17, 8));
			listStudents.add(new Student("nghi", 22, 7.5));
			listStudents.add(new Student("lua", 18, 8));
			listStudents.add(new Student("tung", 22, 8.5));
			listStudents.add(new Student("an", 23, 8.5));
			listStudents.add(new Student("son", 19, 9));
		}
		return listStudents;
	}

	public static String findByName(String name) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getName().equalsIgnoreCase(name)) {
				result += s + "\n";

			}
		}
		return result;
	}

	public static String findByAge(int age) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() == age) {
				result += s + "n";
			}
		}
		return result;
	}

	public static String findByUpperAge(int age) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() >= age) {
				result += s + "n";
			}
		}
		return result;
	}

	public static String findByUnderAge(int age) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() <= age) {
				result += s + "n";
			}
		}
		return result;
	}

	public static String findByScore(double score) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() == score) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static String findByUpperScore(double score) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() >= score) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static String findByUnderScore(double score) {
		String result = "";
		for (Student s : listStudents) {
			if (s.getAge() <= score) {
				result += s + "\n";
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		generateListUser();
		generateListStudent();
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(port);
		System.out.println("Start connection ....");
		Socket socket;
		while (true) {
			socket = server.accept();
			System.out.println("Accepted ....");
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			ServerPOP3 stcp = new ServerPOP3(br, pw, socket);
			pw.println("Welcome system POP3");
			stcp.start();
		}

	}
}
