package cn.homework;
import java.util.*;
public class Arithmetic {
    static final int MAX = 100010;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生的年级(1~6):");
        int grade = sc.nextInt();
        if(!(grade>=1&&grade<=6)){
            System.out.println("暂无年级的习题，尽请期待!");
            return;
        }
        System.out.print("请输入需要的题目数量:");
        int s = sc.nextInt();
        System.out.print("请输入对运算次数的最大要求:");
        int cnt = sc.nextInt();
        while(cnt<1){
            System.out.println("你的输入不合法，请重新输入");
            cnt = sc.nextInt();
        }
        for(int i = 0; i < s; i++){
            String res = solve(grade, cnt);
            System.out.println(res);
        }
    }
    public static String solve(int grade, int cnt){
        Scanner sc = new Scanner(System.in);
        switch(grade){
            case 1:
                return generatesimpel(20, cnt, "+-");
            case 2:
                return generatesimpel(50, cnt, "+-");
            case 3:
                return generatesimpel(1000, cnt, "+*-");
            case 4:
                return generatecomplex(1000, cnt, "+-*/");
            case 5:
                return generatecomplex(1000, cnt, "+-*/");
            case 6:
                return generatecomplex(1000, cnt, "+-*/");
            default:
                return "暂无年级的习题，尽请期待!";
        }
    }
    public static String generatesimpel(int mx, int cnt, String operators){
        Random random = new Random();
        while(true){
            int first = random.nextInt(mx+1);
            StringBuffer stringBuffer = new StringBuffer(Integer.toString(first));
            int nums=  random.nextInt(cnt)+1;
            for(int i = 0; i < nums; i++){
                stringBuffer.append(operators.charAt(random.nextInt(operators.length())));
                stringBuffer.append(random.nextInt(mx+1));
            }
            if(other.check(stringBuffer, mx)){
                return  stringBuffer.toString();
            }
        }
    }
    public static String generatecomplex(int mx, int cnt, String operators){
        Random random = new Random();
        while(true) {
            int first = random.nextInt(mx) + 1, sum = 0;
            int[] vis = new int[4];
            int stk = 0;
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append(Integer.toString(first));
            int nums =  random.nextInt(cnt)+1;
            for(int i = 0; i < nums; i++){
                boolean f = false;
                int t = random.nextInt(operators.length());
                if(vis[t]==0){
                    sum++;
                    vis[t] = 1;
                }
                stringBuffer.append(operators.charAt(t));
                if ((random.nextInt(MAX) % 3 == 2) && (i!=cnt-1)) {
                    stk++;
                    f = true;
                    stringBuffer.append('(');
                }
                stringBuffer.append(random.nextInt(mx)+1);
                if((f==false)&&(stk>0)){
                    stk--;
                    stringBuffer.append(')');
                }
            }
            if(sum<3){
                continue;
            }
            for(int i = 0; i < stk; i++){
                stringBuffer.append(')');
            }
            if(other.check(stringBuffer, MAX)){
                return  stringBuffer.toString();
            }
        }
    }
}
