import Dao.WordDaoImpl;

import java.util.Scanner;

public class Decrypt {
    //---------解密方法----------
    public static void decryption(){
        WordDaoImpl wdi=new WordDaoImpl();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入userHash：");
        String userHash=sc.next();
        if(wdi.search(userHash)==null){
            System.out.println("无此加密信息！请重新输入！");
            decryption();
        }else
        System.out.println("请输入密文：");
        sc.nextLine();
        String cWord=sc.nextLine();
        long timeAgo=System.currentTimeMillis();
        char[] word=cWord.toCharArray();
        //在数据库中查找密文段的偏移值
        String cipher=wdi.search(userHash).getCipher();
        String[] arr=cipher.split(" ");
        StringBuilder wordOp= new StringBuilder();
        //arr数组为密文段的偏移值数组，记录每一个字符的偏移值
        //用加密后的字符的值 减去 偏移值
        //因为加密后的字符由 字符加上一个随机偏移值组成
        //但是若加密前字符的值加上偏移值（若为n）大于127后，此时加密后的字符值为n%127
        //此时n减去偏移值一定小于0，所以必须加上127，才能得到加密前的字符
        for(int n=0;n<arr.length;n++){
            int a=Integer.parseInt(arr[n]);
            int num=word[n]-a;
            if(num<0){
                num+=127;
            }
            wordOp.append((char) num);
        }
        long timeNow=System.currentTimeMillis();
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("密文为:"+wordOp);
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("解密耗时"+(timeNow-timeAgo)+"ms");
        System.exit(200);
    }
}
