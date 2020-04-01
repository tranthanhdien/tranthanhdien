package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.TreeSet;

public class Cart {
	public static TreeSet<Product> cart = new TreeSet<Product>();

	public Cart() {
	}

	// method for add a Product
	public void addProduct(Product p) {
		cart.add(p);
	}

	// method for remove a Product
	public void removeProduct(Product p) {
		cart.remove(p);
	}

	// method for print a list Product
	public void printProduct() {
		System.out.println("\tDANH SÁCH SẢN PHẨM");
		System.out.println("Id\tName\t\tPrice\tQuantity");
		for (Product p : cart) {
			System.out.println(p.toString());
		}
	}

	// method for search a Product
	public void searchProduct(Product p) {
		for (Product product : cart) {
			if (product.getNameProduct().equalsIgnoreCase(p.getNameProduct())) {
				System.out.println(product);
			}
		}

	}

	// method for search a Product start with "A..."
	public void searchProductWithP() {
		String profix = "P";
		for (Product product : cart) {
			if (product.getNameProduct().startsWith(profix))
				System.out.println(product);
		}
	}

	// method for search a Product have quantity greater 2
	public void searchProductByQuantity() {
		for (Product product : cart) {
			if (product.getQuantity() > 2) {
				System.out.println(product);
			}
		}
	}

	public void addSpecial(Product p) {
		for (Product product : cart) {
			if (product.compareTo(p) == 0) {
				product.setQuantity(product.getQuantity() + p.getQuantity());
			}
		}
		cart.add(p);
	}

	// method for remove a special Product
	public void removeSpecial(Product p) {
		for (Product product : cart) {
			if (product.compareTo(p) == 0) {
				cart.remove(product);
			} else {
				try {
					if (product.compareTo(p) == 0 && product.getQuantity() > p.getQuantity()) {
						product.setQuantity(product.getQuantity() - p.getQuantity());
						cart.add(product);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	// method for save file
	public boolean saveFile(String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path); // tạo file để xuất ra
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			String line = "";
			for (Product p : cart) {
				line = p.getIdProduct() + "\t" + p.getNameProduct() + "\t" + p.getPrice() + "\t" + p.getQuantity();
				bw.write(line);
				bw.newLine();
			}
			bw.close();
			osw.close();
			fos.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	// method for read file
	public ArrayList<String> readFile(String path) {
		ArrayList<String> result = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while (line!=null) {
				result.add(line +"\n");
				line=br.readLine();
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static void main(String[] args) {
		Product p1 = new Product("p1", "Product1", 250000, 2);
		Product p2 = new Product("p2", "Product2", 450000, 3);
		Product p3 = new Product("p3", "Product3", 350000, 4);
		Product p4 = new Product("p4", "Product4", 780000, 5);
		Product p5 = new Product("p5", "Product5", 180000, 1);
		Cart cart = new Cart();
		cart.addProduct(p1);
		cart.addProduct(p2);
		cart.addProduct(p3);
		cart.addProduct(p4);
		cart.printProduct();
		// method search a Product
		System.out.println("==================================");
		cart.searchProduct(p1);
		// method search a Product with start "A..."
		System.out.println("==================================");
		System.out.println("Sản phẩm cần tìm bắt đầu với P:");
		cart.searchProductWithP();
		// method search a Product by Quantity
		System.out.println("==================================");
		System.out.println("Sản phẩm cần tìm có số lượng > 2:");
		cart.searchProductByQuantity();
		// method add a special Product, if it already exits then update its quantity
		System.out.println("==================================");
		System.out.println("Danh sách sản phẩm");
		cart.addSpecial(p1);
		//cart.printProduct();
		//cart.saveFile("StoragedFile//file.txt");
		System.out.println(cart.readFile("StoragedFile//file.txt"));
		
	}
}
