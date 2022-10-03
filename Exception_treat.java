class SyntaxException extends Exception {
    public SyntaxException(){   //오류메세지를 넣지 않는 경우
    }
    public SyntaxException(String message){ //오류메세지를 넣는 경우
        super(message);
    }
}