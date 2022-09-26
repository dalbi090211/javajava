import java.util.InputMismatchException;
import java.util.Scanner;
/* 
3.성별이 여자이면서 토익 성적이 700점 이상인 경우 또는
 성별이 남자이면서 토익 성적이 800점 이상인 경우에만 
 “항공 승무원 지원 자격 가능자입니다”를 출력하는 프로그램을 작성하시오.
5.마트에서 구입한 물건 값과 구입 시간을 입력 받아 
실제 지불한 금액을 출력하는 프로그램을 작성하시어. 마트는 시간대별로 할인율을 다르게 적용한다.
[ 오전 12시 이전 : 구입 금액의 5% 할인
오전 12시 이후(12시 포함) : 구입 금액의 2.5% 할인 ]
{ 실행 결과 }
구입 시간 : 10시
총 구입 금액 : 100000
실제 지불 금액 : 95000
7. 첫 번째로 숫자를, 두 번째로 연산자(+, -)를, 세 번째로 숫자를 입력 받아 두 번째로 지정된 연산을 수행하고 
그 결과가 0보다 크면 “수식의 결과는 양수입니다”, 0이면 “수식의 결과가 0ㅇㅂ니다”, 0보다 작으면 “수식의 결과가 음수입니다”를 출력하는 프로그램을 작성하시오.
*/
public class Selection2 {
    //전역변수
    public static Boolean roop_count = false;       //사용자의 입력이 잘못됬을 경우 true로 바꿔 다시 입력받음
    public static Scanner sc = new Scanner(System.in);  //입력을 받기 위한 변수
    //전역함수
    public static int get_int(){    //정수입력 시 예외처리를 하여 리턴하는 함수
        int input_value = 0;
        try{
            input_value = sc.nextInt();
        }
        catch(InputMismatchException e){    //문자열, 객체와 같은 다른 타입의 값 입력 시의 에러를 캐치함
            sc.next();  //입력버퍼를 비움
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
            System.out.println("실수를 입력해주세요.");
        }
        return input_value;
    }
    //기능
    public static void one() {  //나이와 성적을 입력받아 조건에 맞다면 추천, 다르다면 비추천하는 함수

        int age = 0; 
        float grade = 0;

        do{
            roop_count = false;
            System.out.print("나이 : ");
            age = get_int();
            if(age < 0 ){
                System.out.println("0보다 큰 나이를 입력해주세요.");
                roop_count = true;
            }
        }
        while(roop_count == true);
        do{
            roop_count = false;
            System.out.print("성적 : ");
            grade = get_float();
            if(grade < 0 || grade > 5){
                System.out.println("0~100사이의 성적을 입력해주세요.");
                roop_count = true;
            }
        }
        while(roop_count == true);

        if(age < 30 && grade >= 3.5){
            System.out.println("추천 대상입니다.");
        }else {
            System.out.println("추천 대상이 아닙니다.");
        }
    }
    public static void three() {
        
        int grade = 0;
        String gender = "";

        System.out.print("성 : ");  
        gender = sc.next();     //next는 공백으로 구분되어지는 문자열 전부를 받음. 줄 전체를 받으려면 nextln을 써야함. 문자열이다보니 성별이 남성, 남, 남자 이런 경우로 들어간걸 하나로 바꾸는 코드 짜야함
        System.out.print("토익 성적 : ");
        grade = sc.nextInt(); 
        if((gender == "남성" && grade >= 800) || (gender == "여성"  && grade >= 700)){
            System.out.println("항공 승무원 지원 자격 가능자입니다");
        }
        else{
            System.out.println("항공 승무원 지원 자격 불가능자입니다");
        }
    }
    public static void five() {
        float price = 0;
        int purchase_date = 0;
 
        System.out.print("구입 시간 : ");   //substring으로 : 기준으로 자르고 둘 다 isnum으로 숫자인지 확인. 이후 12보다 크거나 0보다 작은지 확인해서 시간인지 검사.하나라도 아니면 루프
        purchase_date = sc.nextInt();
        System.out.print("총 구입 금액 : ");  
        price = sc.nextFloat();

        if(purchase_date >= 12){
            price += price * 2.5;
            System.out.println("실제 지불 금액 : " + price);
        }else{
            price += price * 5;
            System.out.println("실제 지불 금액 : " + price);
        }
        
    }
    public static void seven() {
        int num1 = 0;
        int num2 = 0;
        Character ope;
        
        num1 = sc.nextInt();
        ope = sc.next().charAt(0);
        num2 = sc.nextInt();

        if(ope == '+'){
            System.out.println(num1 + num2);
        }
        else if(ope == '-'){
            System.out.println(num1 - num2);
        }
        else {
            System.out.println("잘못된 실행입니다.");
        }
        
    }
    //메인
    public static void main(String args[]) {
        int go_num;
        System.out.print("실행할 코드의 번호를 입력해주세요 : ");
        go_num = sc.nextInt();
        switch(go_num){
            case 1 : one(); 
                break;
            case 3 : three();
            break;
            case 5 : five();
            break;
            case 7 : seven();
            break;
            default : 
            System.out.println("원하시는 코드가 없습니다.");
        }
        System.out.println("정상종료되었습니다.");
    }

}

https://www.nextree.co.kr/p3239/
