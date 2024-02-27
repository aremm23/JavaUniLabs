package Encryption;

public class Decrypt {
    private String decryptedString;

    public Decrypt(String decryptedString) {
        decryptString(decryptedString);
    }

    public void decryptString(String stringToDecrypt) {
        decryptedString = new StringBuilder(stringToDecrypt).reverse().toString();
    }

    public String getDecryptedString() {
        return decryptedString;
    }
}