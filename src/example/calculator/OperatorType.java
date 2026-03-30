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

    /**
     *문자열에서 Enum 찾는 메서드
     * @param symbol
     * @return 해당하는 OperatorType, 없으면 null 반환
     */
    public static OperatorType fromSymbol(String symbol) { //어디서든접근 객체생성X호출O 반환타입 메서드명(매개변수)
        for (OperatorType op : OperatorType.values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        return null;
    }


}