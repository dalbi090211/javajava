import java.util.InputMismatchException;
import java.util.Scanner;
/* 

1.	1부터 100까지의 수 중에서 4의 배수의 합을 구하여 출력하는 프로그램을 작성하시오.



2.	구구단 2단을 다음과 같이 출력하는 프로그램을 반복문을 사용하여 작성하시오.

{ ** 2단 **

2 * 1 = 2

2 * 3 = 6

2 * 5 = 10

2 * 7 = 14

2 * 8 = 16 }



3.	두 개의 숫자를 입력 받아 두 숫자 사이의 홀수 값을 모두 더하여 출력하는 프로그램을 작성하시오.





4.	100부터 1까지의 수 중에서 홀수의 합을 구하여 출력하는 프로그램을 do-while문을 사용하여 작성하시오.



5.	1부터 100까지의 합을 구하여 다음과 같이 출력하는 프로그램을 do-while 반복문을 이용하여 작성하시오. 10을 기준으로 합계를 출력한다.

{ 1 – 10 : 0000

1 – 20 : 0000

1 – 30 : 0000

. . . . .

1 – 100 : 5050 }



6.	사용자로부터 단을 입력 받아 그 단에 해당되는 구구단을 다음과 같은 형태로 출력하는 프로그램을 do-while문을 사용하여 작성하시오.

{ 사용자 입력 : 12

** 12단 **

8 * 12 = 96

6 * 12 = 72

4 * 12 = 48

2 * 12 = 24 }



7.	사용자로부터 가장 좋아하는 월을 입력 받아 그 월에 해당되는 계절을 출력하는 프로그램을 메뉴 형태로 do-while 문을 사용하여 작성하시오.

{ =======================

가장 좋아하는 월은? (종료 : 0 )

=======================

****** 5월 ******

5월은 봄에 해당됩니다 }
*/

class SyntaxException extends Exception {   //문법오류 시 예외를 처리하기 위한 사용자 정의 예외 클래스
    public SyntaxException(){   //오류메세지를 넣지 않는 경우
    }
    public SyntaxException(String message){ //오류메세지를 넣는 경우
        super(message);
    }
}

public class Roop {
    //전역함수 선언
    public static Scanner sc  = new Scanner(System.in);
    public static int i = 0;
    public static int trial = 0;
    //기능
    public static void one() throws SyntaxException{
        int max = 0;
        int factor = 0;
        int temp = 0;
        System.out.println("배수의 합을 구할 숫자를 입력해주세요.");
        factor = sc.nextInt();
        if(factor < 1){
            throw new SyntaxException("1보다 큰 숫자를 입력해주세요.");
        }
        System.out.println("어디까지 구할까요?");
        max = sc.nextInt();
        if(max < 1){
            throw new SyntaxException("1보다 큰 숫자를 입력해주세요.");
        }
        else if(max < factor){
            throw new SyntaxException("배수를 구할 숫자보다 큰 값을 입력해주세요.");
        }
        for(i = 1; i < max / factor + 1; i++){
            temp += i * factor;
        }
        System.out.println(factor + "의 배수의 합은 : " + temp + "입니다.");
    }

    public static void two() throws SyntaxException{
        int repeat_num = 0;
        int end = 0;
        System.out.println("몇 단을 출력할까요?(최대 15) ");
        repeat_num = sc.nextInt();
        if(repeat_num > 15 || repeat_num < 1){
            throw new SyntaxException("조건에 맞는 정수를 입력해주세요.");
        }
        System.out.println("어디까지 출력할까요?(최대 20) ");
        end = sc.nextInt();
        if(end > 20 || end < 1){
            throw new SyntaxException("조건에 맞는 정수를 입력해주세요.");
        }
        System.out.println("{** " + repeat_num + "단 **");
        for(i = 1; i < end + 1; i++){
            if( i == end){
                System.out.println(repeat_num + "*" + i + "=" + (repeat_num * i) + "}");
            }
            else{
            System.out.println(repeat_num + "*" + i + "=" + (repeat_num * i));
            }
        }
    }

    public static void three() throws SyntaxException{
        int temp = 0;
        int start = 0;
        System.out.print("시작값(250까지) : ");
        start = sc.nextInt();
        if(start > 250 || start < 1){
            throw new SyntaxException("조건에 맞는 정수를 입력해주세요.");
        }
        int end = 0;
        System.out.print("종료값(300까지) : ");
        end = sc.nextInt();
        if(end > 300){
            throw new SyntaxException("조건에 맞는 정수를 입력해주세요.");
        }
        else if(end < start){
            throw new SyntaxException("시작값이 종료값보다 큽니다."); 
        }
        for(i = start; i < end + 1; i++){   //i를 초기값부터 종료값까지 1씩 증가시키면서 넣음
            if(i % 2 == 1){ //i가 홀수인 경우
                temp += i;
            }
        }
        System.out.println("홀수의 합 : " + temp);
    }
    //코드들을 실행하는 함수
    public static void start_code(int code_num) throws SyntaxException{
        trial++;
        if(trial % 3 == 0){
            System.out.print("\033[H\033[2J");
        }
            switch(code_num){ 
                case 1 : 
                one();
                break;
                case 2 : 
                two();
                break;
                case 3 : 
                three();
                break;
                /* 
                case 4 : 
                four();
                break;
                case 5 : 
                five();
                break;
                case 6 : 
                six();
                break;
                case 7 : 
                seven();
                break;
                */
            }
            try{
                System.out.println("다시 시작하려면 코드번호를 아니라면 X를 입력해주세요.");
                code_num = sc.nextInt();
                if(code_num >= 1 && code_num <= 7){ //제대로 된 정수가 들어간 경우
                    start_code(code_num);
                }
                else{   //정수인데 제대로 된 값이 아닌 경우
                    throw new SyntaxException("1~7사이의 숫자를 입력해주세요.");
                }
            }
            catch(InputMismatchException e){    //X혹은 숫자가 아닌 다른 타입을 넣은 경우
                throw new SyntaxException();
            }
    }
    //main함수
    public static void main(String args[]){
        int code_num = 0;
        try{
            System.out.println("실행할 코드의 번호를 정수로 입력해주세요.");
            code_num = sc.nextInt();
            if(code_num >= 1 && code_num <= 7){
                start_code(code_num);
            }
            else{
                throw new SyntaxException("1~7사이의 숫자를 입력해주세요.");
            }
        }
        catch(SyntaxException e){
            if(e.getMessage() != null){   //오류메세지가 없을 경우 출력하지 않음
                System.out.println(e.getMessage()); 
            }
            System.out.println("프로그램이 종료되었습니다.");
        }
        catch(InputMismatchException e){
            System.out.println("예상되는 타입과 다른 타입을 입력하셨습니다.");  
        }

        
    }
}
