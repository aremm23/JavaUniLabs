package Encryption;

public class Encrypt {
    private String encryptedString;

    public Encrypt(String stringToEncrypt) {
        encryptString(stringToEncrypt);
    }

    public void encryptString(String stringToEncrypt) {
        encryptedString = new StringBuilder(stringToEncrypt).reverse().toString();
    }

    public String getEncryptedString() {
        return encryptedString;
    }
}
