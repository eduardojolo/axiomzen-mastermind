package br.com.mastermind.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.log4j.Logger;

import br.com.mastermind.exceptions.MastermindGenericException;

/**
 * Utilitary class for encrypting strings.
 * 
 * @author Eduardo Jolo
 *
 */
public class CryptoUtil {
	
	/**
	 * Logger instance.
	 */
	private static final Logger LOGGER = Logger.getLogger(CryptoUtil.class);
	
	private static Cipher desCipher;
	
	static {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			SecretKey myDesKey = keyGenerator.generateKey();
			
			desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
		} catch(Exception ex) {
			LOGGER.error(ex);
		}
	}

	/**
	 * Private constructor for static class.
	 */
	private CryptoUtil() {
	}
	
	/**
	 * Encrypt the given value and return the result
	 * 
	 * @param value Value to be encrypted
	 * @return Encrypted result
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	public static String encryptString(String value) {
		byte[] valueByteArray = value.getBytes();
		
		byte[] encryptedValue = null;
		try {
			encryptedValue = desCipher.doFinal(valueByteArray);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			LOGGER.error(e);
			throw new MastermindGenericException();
		}
		
		return encryptedValue.toString();
	}
}
