import Dao.WordDaoImpl;

import java.util.Scanner;

public class Query {
    public static void queryWord(){
        WordDaoImpl wdi=new WordDaoImpl();
        System.out.println("请输入userHash：");
        Scanner sc=new Scanner(System.in);
        String userHash=sc.next();
        long timeAgo=System.currentTimeMillis();
        if(wdi.search(userHash)==null){
            System.out.println("无此加密信息！");
            System.out.println("1、重新输入   2、退回到上一级");
            int ans=sc.nextInt();
            if(ans==1){
                queryWord();
            }else if(ans==2){
                Main.main(null);
            }else{
                System.out.println("无效输入，退回到上一级");
                Main.main(null);
            }
        }else{
            String userKey=wdi.search(userHash).getUserKey();
            String epWord=wdi.search(userHash).getEpWord();
            String time=wdi.search(userHash).getTime();
            long timeNow=System.currentTimeMillis();
            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■");
            System.out.println("userKey:"+userKey);
            System.out.println("userHash:"+userHash);
            System.out.println("密文:"+epWord);
            System.out.println("加密时间:"+time);
            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■");
            System.out.println("查询耗时"+(timeNow-timeAgo)+"ms");
        }
    }
}
