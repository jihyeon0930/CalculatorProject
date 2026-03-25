package example.calculator;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    //문자열에서 Enum 찾는 메서드
    //어디서든접근 객체생성X호출O 반환타입 메서드명(매개변수)
    public static OperatorType fromSymbol(String symbol) { //주어진 기호(symbol)에 해당하는 OperatorType Enum값 반환
        for(OperatorType op : OperatorType.values()) { // OperatorType에 있는 값을 op에 넣음
            if(op.getSymbol().equals(symbol)) return op; //op.getSymbol() : Enum에 저장된 실제 정보, symbol : opInput
        }
        return null; //없으면 null 반환
    }



}