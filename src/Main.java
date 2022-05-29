import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //菜单
        option(Start.menu());
    }
    public static void option(int opt){
        if(opt==1){
            Encrypt.encryption();
        }else if(opt==2){
            Decrypt.decryption();
        }else if(opt==4) {
            Admin.admin();
        }else if(opt==3){
            Query.queryWord();
            //ecp(start);
        }else{
            System.out.println("待开发");
        }
    }

}
