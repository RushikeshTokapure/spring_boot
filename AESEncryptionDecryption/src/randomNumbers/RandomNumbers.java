package randomNumbers;

import java.security.SecureRandom;

public class RandomNumbers {

	private static byte[] generateRandom(int length) {
		SecureRandom random = new SecureRandom();
		byte[] randomBytes = new byte[length];
		random.nextBytes(randomBytes);
		return randomBytes;
	}
	
	public static void main(String[] args) {
//		RandomNumbers.generateRandom(16);
		System.out.println(RandomNumbers.generateRandom(32));
	}

}
