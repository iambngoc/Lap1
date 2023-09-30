package Lab1;

public class Task3 {
	public static String encrypt(String text, int n) {
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if ((int) c >= 65 && (int) c <= 90 || (int) c >= 48 && (int) c <= 57 || (int) c >= 97 && (int) c <= 122)
				result += (char) (c + n);
			result += (char) c;
		}
		return result;
	}

	public static String decrypt(String text, int n) {
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if ((int) c >= 65 && (int) c <= 90 || (int) c >= 48 && (int) c <= 57
					|| (int) c >= 97 && (int) c <= 122)
				result += (char) (c - n);
			result += (char) c;
		}
		return result;
	}

	public static void main(String[] args) {
		String text = "WHAT IS LOVE";
		System.out.println(encrypt(text, 3));
		System.out.println(decrypt(encrypt(text, 3), 3));
	}
}
