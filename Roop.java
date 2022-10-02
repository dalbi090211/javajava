import java.util.InputMismatchException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

public class Roop {
    //전역함수 선언
    public static int patience = 0;
    public static Boolean roop_count = false;
    public static Scanner sc  = new Scanner(System.in);
    public static int i = 0;
    public static int trial = 0;
    //전역변수 선언
    public static void fury() { //많은 시도시 프로그램을 종료시키는 함수
        patience++;
        if(patience > 2){
            System.out.println("앞으로 " + (6 - patience) + "번 실패하면 종료합니다.");
        }
        if(patience == 6){
            System.out.print("\033[H\033[2J");
            System.out.println("시도가 너무 많습니다. 프로그램을 종료합니다.");
            System.exit(0);
        }
    }
    public static int get_int(){    //정수입력 시 예외처리를 하여 리턴하는 함수
        int input_value = 0;
        try{
            input_value = sc.nextInt();
        }
        catch(InputMismatchException e){    //문자열, 객체와 같은 다른 타입의 값 입력 시의 에러를 캐치함
            sc.next();  //입력버퍼를 비움
            System.out.print("\033[H\033[2J");
            System.out.println("정수를 입력해주세요.");
            roop_count = true;
        }
        return input_value; 
    }
    public static float get_float(){    //실수입력 시 예외처리를 하여 리턴하는 함수
        float input_value = 0;
        try{
            input_value = sc.nextFloat();
        }
        catch(InputMismatchException e){
            sc.next();  
            roop_count = true;
            System.out.print("\033[H\033[2J");
            System.out.println("실수를 입력해주세요.");
        }
        return input_value;
    }
    //기능
    public static void one(int max, int factor){
        int temp = 0;
        for(i = 0; i < max / factor; i++){
            temp += i * factor;
        }
        System.out.println(factor + "의 배수의 합은 : " + temp + "입니다.");
    }
    public static void two(int end, int repeat_num){
        System.out.println("{** " + repeat_num + "단 **");
        for(i = 0; i < end + 1; i++){
            if( i == end){
                System.out.println(repeat_num + "*" + i + "=" + (repeat_num * i) + "}");
            }
            else{
            System.out.println(repeat_num + "*" + i + "=" + (repeat_num * i));
            }
        }
    }
    public static void three(int start, int end) throws IllegalArgumentException{
        int temp = 0;
        if(end < start){
            throw new IllegalArgumentException(); 
        }
        for(i = start; i < end + 1; i++){   //i를 초기값부터 종료값까지 1씩 증가시키면서 넣음
            if(i % 2 == 1){ //i가 홀수인 경우
                temp += i;
            }
        }
        System.out.println("홀수의 합 : " + temp);
    }


    public static void main(String args[]) throws Exception_treat{
        trial++;
        if(trial == 10){
            throw new ManytrialException("졸리다"); 
        }
        int a, b;
        int go_num;
        Character roop_count;
        try{
            System.out.print("실행할 코드의 번호를 입력해주세요 : ");
            go_num = sc.nextInt();
            switch(go_num){
                case 1 : 
                    trial++; //사용자가 많이 시도하면 종료할수 있도록 루프마다 호출함
                    System.out.print("수의 범위(최대값) : ");
                    a = get_int();
                    if(a < 1 ){   //입력받을 변수에 알맞지 않는 값이 들어오면 예외를 발생시킴
                        throw new IllegalArgumentException();
                    }
                one(100, 4); 
                break;
                case 2 : two(9, 2);
                break;
                case 3 : 
                
                three();
                break;
                /* 
                case 7 : seven();
                break;
                */
                default : 
                System.out.println("원하시는 코드가 없습니다.");
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("잘못된 인자입니다. 다시 시작할까요? Y/N");
            roop_count = sc.next().charAt(0);
        }
        catch(ManytrialException e){

        }
    }
}
