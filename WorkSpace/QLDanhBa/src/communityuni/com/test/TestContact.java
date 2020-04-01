package communityuni.com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import communityuni.com.io.SerializeFileFactory;
import communityuni.com.model.Contact;

public class TestContact {
	static HashMap<Integer, Contact>csdl=new HashMap<Integer, Contact>();
	public static void menu()
	{
		System.out.println("1.ThÃªm");
		System.out.println("2.Xuáº¥t");
		System.out.println("3.Sá»­a");
		System.out.println("4.XÃ³a");
		System.out.println("5.TÃ¬m");
		System.out.println("6.Sáº¯p xáº¿p");
		System.out.println("7.LÆ°u File");
		System.out.println("8.Ä�á»�c File");
		System.out.println("9.ThoÃ¡t");
		System.out.println("ThÃ­m má»‘n gÃ¬?:");
		int n=new Scanner(System.in).nextInt();
		switch(n)
		{
		case 1:
			them();
			break;
		case 2:
			xuat();
			break;
		case 3:
			sua();
			break;
		case 4:
			xoa();
			break;
		case 5:
			tim();
			break;
		case 6:
			sapxep();
			break;
		case 7:
			luuFile();
			break;
		case 8:
			docFile();
			break;
		case 9:
			System.err.println("Táº¡m biá»‡t!");
			System.exit(0);
			break;
		}
	}
	private static void docFile() {
		csdl=SerializeFileFactory.readFile("e://csdlcontact.dat");
	}
	private static void luuFile() {
		SerializeFileFactory.saveFile(csdl, "e://csdlcontact.dat");
	}
	private static void sapxep() {
		System.out.println("Tá»± lÃ m nha.. ha ha ha");
		//sáº¯p theo mÃ£
		//sáº¯p theo tÃªn
		//sáº¯p theo sá»‘ Ä‘iá»‡n thoáº¡i
	}
	private static void tim() {
		System.out.println("Nháº­p phone:");
		String phone=new Scanner(System.in).nextLine();
		for(Map.Entry<Integer, Contact> item: csdl.entrySet())
		{
			if(item.getValue().getPhone().startsWith(phone))
				System.out.println(item.getValue());
		}
	}
	private static void xoa() {
		System.out.println("Nháº­p mÃ£:");
		int ma=new Scanner(System.in).nextInt();
		if(csdl.containsKey(ma))
		{
			csdl.remove(ma);
		}
		else
		{
			System.out.println("KhÃ´ng tÃ¬m tháº¥y mÃ£ "+ma+" Ä‘á»ƒ xÃ³a");
		}
	}
	private static void sua() {
		System.out.println("Nháº­p mÃ£ muá»‘n sá»­a:");
		int ma=new Scanner(System.in).nextInt();
		if(csdl.containsKey(ma))
		{
			System.out.println("Nháº­p TÃªn:");
			String ten=new Scanner(System.in).nextLine();
			System.out.println("Nháº­p Phone:");
			String phone=new Scanner(System.in).nextLine();
			
			Contact c=new Contact(ma, ten, phone);
			csdl.put(ma, c);
		}
		else
		{
			System.out.println("mÃ£ "+ma+" khÃ´ng tá»“n táº¡i");
		}
	}
	private static void xuat() {
		System.out.println("Danh sÃ¡ch Danh Báº¡:");
		for(Map.Entry<Integer, Contact> item: csdl.entrySet())
		{
			System.out.println(item.getValue());
		}
	}
	private static void them() {
		System.out.println("Nháº­p MÃ£:");
		int ma=new Scanner(System.in).nextInt();
		System.out.println("Nháº­p TÃªn:");
		String ten=new Scanner(System.in).nextLine();
		System.out.println("Nháº­p Phone:");
		String phone=new Scanner(System.in).nextLine();
		
		Contact c=new Contact(ma, ten, phone);
		if(csdl.containsKey(c.getId())==false)
		{
			csdl.put(c.getId(), c);
		}
	}
	public static void main(String[] args) {
		while(true)
		{
			menu();
		}
	}

}
