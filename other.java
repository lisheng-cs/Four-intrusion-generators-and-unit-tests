package cn.homework;
import java.util.*;
public class other {
    public static boolean check(StringBuffer stringBuffer, int mx){
        String s = stringBuffer.toString();
        Map<Character,Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);

        Stack<Character> op = new Stack<>();
        Stack<Integer> num = new Stack<>();

        for(int i = 0 ; i < s.length(); i ++ ){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int x = 0,j = i;
                while(j < s.length() && Character.isDigit(s.charAt(j))){
                    x = x * 10 + s.charAt(j) - '0';
                    j++;
                }
                num.push(x);
                i = j - 1;
            }else if(c == '('){
                op.push(c);
            }else if(c == ')'){
                while(op.peek() != '('){
                    if(op.peek()=='/'&&(num.peek()==0)){
                        return false;
                    }
                    eval(op,num);
                }
                op.pop();
            }else {
                while(!op.empty() && op.peek() != '(' && map.get(op.peek()) >= map.get(c)){
                    if(op.peek()=='/'&&(num.peek()==0)){
                        return false;
                    }
                    eval(op,num);
                }
                op.push(c);
            }
        }
        while(!op.empty()) {
            if(op.peek()=='/'&&(num.peek()==0)){
                return false;
            }
            eval(op,num);
        }
        return num.peek()>=0&&num.peek()<=mx;
    }
    public static void eval(Stack<Character> op,Stack<Integer> num){
        int b = num.pop();
        int a = num.pop();

        char c = op.pop();
        if(c == '+'){
            num.push(a+b);
        }else if(c == '-'){
            num.push(a-b);
        }else if(c == '*'){
            num.push(a*b);
        }else {
            num.push(a/b);
        }
    }
}
