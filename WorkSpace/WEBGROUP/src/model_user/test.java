package model_user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static boolean ktra(String s) {
		Pattern patternObject = Pattern.compile("^0\\d{9}");
		Matcher matcherObject = patternObject.matcher(s);
		if (!matcherObject.matches()) {
			System.out.println("Error");
			return false;
		} else
			System.out.println("Done!!");
		return true;
	}

	public static void main(String[] args) {
		test.ktra("035735225");
	}

}
