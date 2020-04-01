import java.util.Arrays;
import java.util.Random;

public class Test {
	// chèn 1 phần tử vào vị trí index trong mảng đã sắp xếp
	public static int[] insert(int[] arr, int index, int value) {
		// tạo 1 mảng mới có kích cỡ + 1
		int[] newArrr = new int[arr.length + 1];
		// duyệt tất cả phần tử trong mảng
		for (int i = 0; i < newArrr.length; i++) {
			if (i < index) {
				newArrr[i] = arr[i]; // phần tử mảng mới = cũ
			} else if (i == index) {
				newArrr[i] = value;
			} else {
				newArrr[i] = arr[i - 1];
			}
		}
		return newArrr;

	}

	public static int getRandom1ToN(int n) {
		Random rd = new Random();
		return rd.nextInt(n) + 1;
	}

	public static String formatNumber(int num, int digit) {
		int sizeOfNum = (num + "").length();
		String result = "";
		if (digit - sizeOfNum > 0) {
			for (int i = 0; i < digit - sizeOfNum; i++) {
				result += "0";
			}
			result += num;
		} else {
			result += num;
		}
		return result;
	}

	public static String[] createRandomPower6_56() {
		String[] result = new String[6];
		for (int i = 0; i < 6; i++) {
			result[i] = formatNumber(getRandom1ToN(55), 2);
		}
		return result;
	}

	public static int[][] createMatrix(int m, int n) {
		int[][] matrix = new int[m][n];
		Random rd = new Random();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = rd.nextInt(10);
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 7 };
		int index = 3;
		int value = 10;
		System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
		System.out.println("Mảng sau khi thêm: " + Arrays.toString(Test.insert(arr, index, value)));

		int num = 15;
		int digit = 5;
		System.out.println(Test.getRandom1ToN(num));
		System.out.println(Test.formatNumber(num, digit));
		System.out.println(String.valueOf(Test.createRandomPower6_56()));

		int m = 4;
		int n = 4;
		System.out.println(Arrays.toString(Test.createMatrix(m, n)));
	}
}
