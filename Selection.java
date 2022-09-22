import java.util.InputMismatchException;
import java.util.Scanner;



public class Selection {

    public static Boolean roop_count = false;
    public static Scanner sc = new Scanner(System.in); 

    public static void one() {
        int Score_math = 0;
        int Score_english = 0;
        do{
                roop_count = false;
                System.out.println("수학 점수를 입력해주세요 : ");
                Score_math = get_int();
                if(roop_count == true){
                    System.out.println("잘못된 입력입니다. 1~100사이의 정수를 다시 입력해주세요.");
            }
                else if(Score_math > 100 || Score_math < 0){
                    System.out.println("잘못된 입력값입니다. 1~100사이의 값을 다시 입력해주세요.");
                    roop_count = true;
            }
        }
        while(roop_count == false);

        System.out.println("영어 점수를 입력해주세요 : ");
        Score_english = sc.nextInt();
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
        if(voter_par / voter_max > 50){
            System.out.print("유효 투표입니다");
        }
        else{
            System.out.print("무효 투표입니다");
        }
    }

    public static void five() {
        int movie_watcher = 0;
        System.out.print("사람 수 : ");
        movie_watcher = sc.nextInt();
        if(movie_watcher > 20){
            System.out.println("총 비용(20%할인 적용 : " + movie_watcher*6400 + "원");
        }
        else if (movie_watcher > 10) {
            System.out.println("총 비용(10%할인 적용 : " + movie_watcher*7200 + "원");
        }
        else {
            System.out.println("총 비용(0%할인 적용 : " + movie_watcher*8000 + "원");
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
            System.out.println("출력 값 : " + num1 + num2);
        }
        else if (num2 > num1){
            System.out.println("출력 값 : " + num2 + num1);
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
            System.out.println("총 금액 : " + value*quantity*100/80);
        }else if (quantity >= 200 ){
            System.out.println("총 금액 : " + value*quantity*100/85);
        }else if (quantity >= 100){
            System.out.println("총 금액 : " + value*quantity*100/92);
        }else{
            System.out.println("총 금액 : " + value*quantity);
        }
    }
    public static void main(String args[]){
        int go_num;
        System.out.print("실행할 코드의 번호를 입력해주세요 : ");
        go_num = sc.nextInt();
        switch(go_num / 2){
            case 0 : one(); 
                break;
            case 1 : three();
            break;
            case 2 : five();
            break;
            case 3 : seven();
            break;
            case 4 : nine();
            break;
            case 5 : eleven();
            break;
            default : System.out.println("정상종료되었습니다.");
        }
    }

    public static int get_int(){
        int input_value = 0;
        try{
            input_value = sc.nextInt();
        }
        catch(InputMismatchException e){
            sc.next();
            roop_count = true;
        }
        return input_value;
    }

}
