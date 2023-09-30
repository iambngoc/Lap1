package Lab1;

public class MyCaesar {
	private int n;
	public static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	public char encryptChar(char c) {
		if (c >= 65 && c <= 90)
			return ALPHABET[(c + n) % 26];
		return (char) ('0' + c);
	}

	public String encrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += encryptChar(input.charAt(i));

		}
		return result;
	}

	public char decryptChar(char c) {
		if (c >= 65 && c <= 90)
			return ALPHABET[(c - n) % 26];
		return (char) ('0' - c);

	}

	public String decrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += decryptChar(input.charAt(i));
		}
		return result;
	}

	public static void main(String[] args) {
		MyCaesar a = new MyCaesar(3);
		System.out.println(a.encryptChar('A'));
		System.out.println(a.decryptChar('B'));
		System.out.println(a.encrypt("WHAT"));
		System.out.println(a.decrypt(a.encrypt("WHAT")));
	}
}
