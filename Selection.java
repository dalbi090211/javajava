import java.util.InputMismatchException;
import java.util.Scanner;



public class Selection {
    //전역에서 사용할 변수
    public static Boolean roop_count = false;   //사용자의 입력이 잘못됬을 경우 true로 바꿔 다시 입력받음
    public static Scanner sc = new Scanner(System.in); //입력을 받기 위한 변수

    public static void one() {
        //변수 선언
        float Score_math = 0;
        float Score_english = 0;

        //사용자에게 입력
        do{
                roop_count = false;
                System.out.print("영어 점수를 입력해주세요 : ");
                Score_english = get_float();
                if(roop_count == true){ //get_float()에서 잘못된 값 입력 시
                    System.out.println("잘못된 입력입니다. 1~100사이의 실수를 다시 입력해주세요.");
            }
                else if(Score_english > 100 || Score_english < 0){    //입력받은 값이 잘못 되었을 시
                    System.out.println("잘못된 입력값입니다. 1~100사이의 값을 다시 입력해주세요.");
                    roop_count = true;
            }
        }
        while(roop_count == true);
        do{
            roop_count = false;
            System.out.print("수학 점수를 입력해주세요 : ");
            Score_math = get_float();   //예외 처리를 위해 정의함수를 사용함
            if(roop_count == true){ //get_float()에서 잘못된 값 입력 시
                System.out.println("잘못된 입력입니다. 1~100사이의 실수를 다시 입력해주세요.");
            }
            else if(Score_math > 100 || Score_math < 0){    //입력받은 값이 잘못 되었을 시
                System.out.println("잘못된 입력값입니다. 1~100사이의 값을 다시 입력해주세요.");
                roop_count = true;
            }
        }
        while(roop_count == true);

        //조건(합 120 이상)에 따라 합/불합 출력
        if(Score_math + Score_english > 120){
            System.out.println("합격");
        }
        else{
            System.out.println("불합격");
        }
    }

    public static void three() {
        int voter_max = 0;
        int voter_par = 0;

        System.out.print("유권자 수를 입력해주세요 : ");
        voter_max = sc.nextInt();
        System.out.print("투표자 수를 입력해주세요 : ");
        voter_par = sc.nextInt();
        if(voter_par*2 >= voter_max){
            System.out.println("유효 투표입니다");
        }
        else{
            System.out.println("무효 투표입니다");
        }
    }

    public static void five() {
        int movie_watcher = 0;
        System.out.print("사람 수 : ");
        movie_watcher = sc.nextInt();
        if(movie_watcher > 20){
            System.out.println("총 비용(20%할인 적용) : " + movie_watcher*6400 + "원");
        }
        else if (movie_watcher > 10) {
            System.out.println("총 비용(10%할인 적용) : " + movie_watcher*7200 + "원");
        }
        else {
            System.out.println("총 비용(0%할인 적용) : " + movie_watcher*8000 + "원");
        }
    }

    public static void seven() {
        int person_age = 0;
        System.out.print("나이가 어떻게 되십니까? ");
        person_age = sc.nextInt();
        if(person_age > 19){
            System.out.println("성인입니다");
        }
        else if (person_age == 19){
            System.out.println("19세입니다");
        }
        else {
            System.out.println("미성년자입니다");
        }
    }

    public static void nine() {
        int num1 = 0;
        int num2 = 0;
        System.out.print("입력 값 : ");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        if(num1 >= num2){
            System.out.println("출력 값 : " + num1 + " " + num2);
        }
        else if (num2 > num1){
            System.out.println("출력 값 : " + num2 + " " + num1);
        }
    }


    public static void eleven() {
        int quantity = 0;
        float value = 0;
        System.out.print("상품의 개수 : ");
        quantity = sc.nextInt();
        System.out.print("상품의 단가 : ");
        value = sc.nextFloat();
        if(quantity >= 300){
            System.out.println("총 금액 : " + value*quantity*80/100);
        }else if (quantity >= 200 ){
            System.out.println("총 금액 : " + value*quantity*85/100);
        }else if (quantity >= 100){
            System.out.println("총 금액 : " + value*quantity*92/100);
        }else{
            System.out.println("총 금액 : " + value*quantity);
        }
    }
    
    public static void main(String args[]){
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
            case 9 : nine();
            break;
            case 11 : eleven();
            break;
            default : 
            System.out.println("원하시는 코드가 없습니다.");
        }
        System.out.println("정상종료되었습니다.");
    }

    public static int get_int(){    //실수입력 시 예외처리를 한 변수
        int input_value = 0;
        try{
            input_value = sc.nextInt();
        }
        catch(InputMismatchException e){    //문자열, 객체와 같은 다른 타입의 값 입력 시의 에러를 캐치함
            sc.next();
            roop_count = true;
        }
        return input_value;
    }

    public static float get_float(){    //실수입력 시 예외처리를 한 변수
        float input_value = 0;
        try{
            input_value = sc.nextFloat();
        }
        catch(InputMismatchException e){
            sc.next();  //입력버퍼를 비움
            roop_count = true;
        }
        return input_value;
    }

}
