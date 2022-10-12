import java.util.InputMismatchException;

class SyntaxException extends Exception {   //문법오류 시 예외를 처리하기 위한 사용자 정의 예외 클래스
    public SyntaxException(){   //오류메세지를 넣지 않는 경우
    }
    public SyntaxException(String message){ //오류메세지를 넣는 경우
        super(message);
    }
}

public class Roop {
    //전역함수 선언
    public static java.util.Scanner sc  = new java.util.Scanner(System.in);
    public static int i = 0;
    public static int j = 0;
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
        int end = 0;
        System.out.print("시작값(0~250까지) : ");
        start = sc.nextInt();
        if(start > 250 || start < 1){
            throw new SyntaxException("조건에 맞는 정수를 입력해주세요.");
        }
        System.out.print("종료값(시작값+1~300까지) : ");
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

    public static void four(){
        int temp = 0;
        i = 100;
        do{
            temp += i;
            i--;
        }
        while(i > 0);
        System.out.println("100부터 1까지의 홀수의 합 : " + temp);
    }

    public static void five(){
        int temp = 0;
        i = 1;
        System.out.println("{ ");
        do{
            temp += i;
            if(i % 10 == 0){
                System.out.println("1 - " + i + " : " + temp);
            }
            i++;
        }
        while(i != 101);
        System.out.println(" }");
    }

    public static void six(){
        int factor = 0;
        i = 8;
        System.out.print("{ 사용자 입력 : ");
        factor = sc.nextInt();
        System.out.print("** ");
        System.out.print(factor + "단 ");
        System.out.println("**");
        do{
            if(i == 2){
                System.out.print(i + " * " + factor + " = " + i*factor);
            }
            else{
            System.out.println(i + " * " + factor + " = " + i*factor);
            }
            i -= 2;
        }
        while(i != 0);
        System.out.println(" }");
    }

    public static void seven() { //4번째줄 별표 사이에 커서를 옮겨야함.
        
        int month = 0;
        String temp;
        Boolean end_count = true;

        do{
            System.out.println("{ =======================");
            System.out.println("가장 좋아하는 월은? (종료 : 0 )");
            System.out.println("=======================");
            try{
                temp = sc.next();
                if(temp == "0"){
                    System.out.println("프로그램을 종료합니다.");
                    end_count = false;
                }
                else if(temp.indexOf("월", temp.length() - 1) != 0) //받은 문자열이 월로 안끝날경우
                {
                    throw new InputMismatchException();
                }
                else{
                    month = Integer.valueOf(temp.substring(0 , temp.length() - 1));
                    System.out.println("월 : " + month);
                    if(month > 12 || month < 1){
                        System.out.print("\033[H\033[2J");
                        System.out.println("1~12사이의 숫자를 넣어주세요.");  
                        end_count = true;    
                    }
                    else{
                        if(month > 11 || month < 3){
                            System.out.println(month + "월은 봄에 해당됩니다 }");
                        }
                        else if(month > 2 && month < 6){
                            System.out.println(month + "월은 여름에 해당됩니다 }");
                        }
                        else if(month > 5 && month < 9){
                            System.out.println(month + "월은 가을에 해당됩니다 }");
                        }
                        else {
                            System.out.println(month + "월은 겨울에 해당됩니다 }");
                        }
                    }
                }
            }
            catch(NumberFormatException e){ //월앞에 숫자가 없는 경우, valueOf에서 발생
                System.out.println("월앞에 숫자를 붙여주세요.");
                //시간을 지연시키는 함수
                System.out.print("\033[H\033[2J");
            }
            catch(InputMismatchException e){    //월로 안끝난 경우
                System.out.println("1~12 + 월의 형식으로 입력해주세요.");
                System.out.print("\033[H\033[2J");
            }
        }
        while(end_count == false);
        System.out.println(" }");
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
            }
            try{    //예외발생 시 가장 가까운 catch문으로 가기에 main의 catch가 아닌 바로 뒤에 catch로 가게됨
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
