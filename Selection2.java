import java.util.InputMismatchException;
import java.util.Scanner;

public class Selection2 {
    //전역변수
    public static int patience = 0;
    public static Boolean roop_count = false;       //사용자의 입력이 잘못됬을 경우 true로 바꿔 다시 입력받음
    public static Scanner sc = new Scanner(System.in);  //입력을 받기 위한 변수
    //전역함수
    public static void fury() {
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
    public static void one(){  //나이와 성적을 입력받아 조건에 맞다면 추천, 다르다면 비추천하는 함수

        int age = 0; 
        float grade = 0;

        do{
            fury();
            roop_count = false;
            System.out.print("나이 : ");
            age = get_int();
            if(age < 0 ){
                System.out.print("\033[H\033[2J");
                System.out.println("0보다 큰 나이를 입력해주세요.");
                roop_count = true;
            }
        }
        while(roop_count == true);
        patience = 0;
        do{
            fury();
            roop_count = false;
            System.out.print("성적 : ");
            grade = get_float();
            if(grade < 0 || grade > 5){
                System.out.print("\033[H\033[2J");
                System.out.println("0~5사이의 성적을 입력해주세요.");
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

        roop_count = false;
        int grade = 0;
        String gender = "";

        do{
            fury();
            System.out.print("성 : ");
            gender = sc.next();
            if(gender.indexOf("남자") == -1 || gender.indexOf("남") == -1 || gender.indexOf("남성") == -1){
                gender = "남성";
            }
            else if(gender.indexOf("여자") == -1 || gender.indexOf("여") == -1 || gender.indexOf("여성") == -1){
                gender = "여성";
            }
            else{
                sc.next();
                System.out.print("\033[H\033[2J");
                System.out.println("인식할 수 있는 형태는 남자, 남, 남성입니다.");
                roop_count = true;
            }
        }   
        while(roop_count == true); 
        patience = 0;
        do{
            fury();
            roop_count = false;
            System.out.print("성적 : ");
            grade = get_int();
            if(grade < 0 || grade > 980){
                System.out.print("\033[H\033[2J");
                System.out.println("0~980사이의 점수를 입력해주세요.");
                roop_count = true;
            }
        }
        while(roop_count == true); 
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
 
        do{
            fury();
            roop_count = false;
            System.out.print("구입 시간 : ");
            purchase_date  = get_int();
            if(purchase_date < 0 || purchase_date > 24){
                System.out.print("\033[H\033[2J");
                System.out.println("0 ~ 24 사이의 정수를 입력해주세요.");
                roop_count = true;
            }
        }
        while(roop_count == true); 
        patience = 0;
        do{
            fury();
            roop_count = false;
            System.out.print("총 구입 금액 : ");
            price = get_int();  //가격 자체는 정수이므로 정수로 받음.
            if(price < 0){
                System.out.print("\033[H\033[2J");
                System.out.println("양의 정수를 입력해주세요.");
                roop_count = true;
            }
        }
        while(roop_count == true); 
        if(purchase_date >= 12){
            price += price * 2.5;
            System.out.println("실제 지불 금액 : " + price);
        }else{
            price += price * 5;
            System.out.println("실제 지불 금액 : " + price);
        }
        
    }
    public static void seven() {
        float num1 = 0;
        float num2 = 0;
        Character ope;
        float temp = 0;

        do{
            fury();
            roop_count = false;
            System.out.print("숫자1 : ");
            num1 = get_int();  //가격 자체는 정수이므로 정수로 받음.
        }
        while(roop_count == true); 
        patience = 0;
        do{
            fury();
            System.out.print("연산자 : ");
            ope = sc.next().charAt(0);
            if(ope != '+' && ope != '-'){
                System.out.print("\033[H\033[2J");
                System.out.println("다시 연산자(+,-)를 입력해주세요.");
                roop_count = true;
            }
        }   
        while(roop_count == true); 
        patience = 0;
        do{
            fury();
            roop_count = false;
            System.out.print("숫자2 : ");
            num2= get_int();  //가격 자체는 정수이므로 정수로 받음.
        }
        while(roop_count == true); 

        if(ope == '+'){
            temp = num1 + num2;
        }
        else if(ope == '-'){
            temp = num1 - num2;
        }

        if(temp > 0){
            System.out.print("수식의 결과는 양수입니다");
        }
        else if(temp == 0){
            System.out.print("수식의 결과는 0입니다");
        }
        else if(temp < 0){
            System.out.print("수식의 결과는 음수입니다");
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
    }

}

