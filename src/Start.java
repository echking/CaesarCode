import java.util.Scanner;

public class Start {
    public static int menu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("加密文程序已启动，请选择功能选项：");
        System.out.println("1、加密文段");
        System.out.println("2、解密文段");
        System.out.println("3、查询已加密内容");
        System.out.println("4、管理员选项");
        int start=sc.nextInt();
        if(start==1||start==2||start==3||start==4){
            return start;
        }else{
            System.out.println("无此选项，请重新输入！");
            return menu();
        }
    }
    public static int adminMenu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("■■■■■■■■■■■管理员菜单■■■■■■■■■■■");
        System.out.println("1、查询所有加密内容");
        System.out.println("2、删除加密内容");
        System.out.println("3、退出程序");
        int start=sc.nextInt();
        if(start==1||start==2||start==3){
            return start;
        }else{
            System.out.println("无此选项，请重新输入！");
            return menu();
        }
    }
}
