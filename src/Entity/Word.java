package Entity;

public class Word {
    //加密签名
    private String userKey;
    //签名hash值
    private String userHash;
    //密文
    private String epWord;
    //密文偏移值
    private String cipher;
    //加密时间
    private String time;



    public Word(String userKey, String userHash, String epWord, String cipher, String time) {
        this.userKey = userKey;
        this.userHash = userHash;
        this.epWord = epWord;
        this.cipher = cipher;
        this.time = time;
    }

    public Word() {

    }

    public String getTime(){
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getUserHash(){
        return userHash;
    }
    public void setUserHash(String userHash){
        this.userHash=userHash;
    }
    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getEpWord() {
        return epWord;
    }

    public void setEpWord(String epWord) {
        this.epWord = epWord;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }
}

