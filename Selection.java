import java.util.InputMismatchException;
import java.util.Scanner;



public class Selection {

    public static Boolean roop_count = false;
    public static Scanner sc = new Scanner(System.in); 

    public static void main(String args[]){

        Boolean roop_count = false;
        Scanner sc = new Scanner(System.in);
        /*
         * 1.국어와 영어 점수를 입력 받아 두 점수의 합이 120점 이상이면 합격을, 
         * 그렇지 않으면 불합격을 출력하는 프로그램을 작성하시오.
         * 입력을 어떻게 받을지 몰라서 몰라요
         */

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
        
        /*
         * 3. 유권자 수와 투표자 수를 입력 받아 투표율이 50% 이상인 경우 
         * “유효 투표입니다”를 출력하는 프로그램을 작성하시오.
         */
        

        /* 5. 한 사람당 8000원인 영화관에서 10명 이상일 경우 10%, 20명 이상일 경우 20%를 할인해 주고 있다. 
         * 사람 수를 입력 받아 지불해야 하는 총 비용을 출력하는 프로그램을 작성하시오.
        { 실행 결과 }
        사람 수 : 00명
        총 비용(00%할인 적용) : 0000000원
         */


        /* 7. 나이를 입력 받아 입력된 나이가 19세 미만이면 “미성년자입니다”, 19세이면 “19세입니다”를, 
        19세보다 많으면 “성인입니다”를 출력하는 프로그램을 작성하시오.
        */


        /* 9. 2개의 값을 입력 받아 값을 큰 순서대로 출력하는 프로그램을 작성하시오.
        { 실행 결과 }
        입력 값 : 14  23
        출력 값 : 23  14
        */

        /*11. 상품의 개수와 단가를 입력 받아 총 금액을 계산하여 출력하시오. 
        단, 상품의 개수가 100-199 사이이면 8%, 200-299 사이이면 15%, 300개 이상이면 20%의 할인 금액을 적용한다. 
        100개 미만이면 할인 금액을 적용하지 않는다.
         */


    }

    public static int get_int(){
        int input_value;
        try{
            input_value = sc.nextInt();
        }
        catch(InputMismatchException e){
            sc.next();
            roop_count = true;
        }
        finally{
            if(e == null){
                return input_value;
            }
        }
    }

}
