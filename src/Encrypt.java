import Dao.WordDaoImpl;
import Entity.Word;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

public class Encrypt {
    static WordDaoImpl wdi=new WordDaoImpl();
    public static void encryption(){
        //--------------加密方法---------------
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入userKey：");
        String userKey=sc.nextLine();
        String hash=Long.toString(userKey.hashCode());
        if(wdi.search(hash)==null){
            way(userKey,hash);
        }else{
            System.out.println("userKey已被使用");
            System.out.println("y:覆盖   n:取消");
            String key=sc.nextLine();
            if(key.equals("y")||key.equals("Y")){
                    way(userKey,hash);
            }else if(key.equals("n")||key.equals("N")){
                    System.exit(0);
            }else{
                System.out.println("无效输入！");
            }
        }
        sc.close();
    }
    //加密方法
    public static void way(String userKey,String hash){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入需要加密文段：");
        String word=sc.nextLine();
        long timeAgo=System.currentTimeMillis();
        char[] wordStrings=word.toCharArray();
        StringBuilder serWord= new StringBuilder();
        //StringBuilder ecpWord= new StringBuilder();
        StringBuilder ecpString= new StringBuilder();
        Random rdNum=new Random();
        for (char wordString : wordStrings) {
            //随机偏移量为[0,25)
            int malNum = rdNum.nextInt(25);
            //当加密前字符的值加上偏移量后大于127，需要求其值与127的模
            //解密时，若计算出来为负数，加上127即可
                int num = (wordString + malNum) % 127;
                //ascii码的前31个字符为特殊符号，会显示成乱码，所以需要避免加密成前31个字符
                if(num<=32){
                    num+=32;
                    //只需要在偏移量上也加32，就不会在解密时出现问题
                    malNum+=32;
                }
                serWord.append((char)num);
                //ecpWord.append((char)num);
            ecpString.append(malNum).append(" ");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sw= serWord.toString();
        String es= ecpString.toString();
        Word wd=new Word();
        wd.setUserKey(userKey);
        wd.setUserHash(hash);
        wd.setEpWord(sw);
        wd.setCipher(es);
        wd.setTime(df.format(System.currentTimeMillis()));
        long timeNow=System.currentTimeMillis();
        System.out.println("加密耗时"+(timeNow-timeAgo)+"ms");
        //将加密后的信息写入数据库
        if(wdi.insert(wd)) {
            System.out.println("请保存以下内容！");
            System.out.println("■■■■■■■■■■■■■■■■■■■■■■");
            System.out.println("userHash:" + hash);
            System.out.println("密文:" + serWord);
            System.out.println("■■■■■■■■■■■■■■■■■■■■■■");
        }else{
            System.out.println("-------加密失败-------");
        }
    }
}
