
public class Demo {
	public static void main(String[] args) {
		int[] arr = {2, -1, 7, -3, 4, -5, 6};
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]*arr[i+1]<0) {
				System.out.println("Đan dấu");
			} else 
			System.out.println("Ko đan dấu");
		}
	}

}
