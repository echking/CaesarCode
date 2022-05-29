import java.util.Scanner;

public class Admin {
    //----------管理员页-----------
    public static void admin(){
        System.out.println("请输入密码：");
        Scanner sc=new Scanner(System.in);
        String password=sc.next();
        if(password.equals("echking")){
            int ans=Start.adminMenu();
            if(ans==1){
                System.out.println("待开发");
            }else if(ans==2){
                System.out.println("待开发");
            }else{
                System.exit(0);
            }
        }else{
            System.out.println("密码输入错误！");
            System.out.println("1:退出程序    2:返回上一级");
            int a=sc.nextInt();
            if(a==1){
                System.exit(0);
            }else if(a==2){
                Main.main(null);
            }
        }
    }
}
