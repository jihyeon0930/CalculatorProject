package example.calculator;

import java.util.ArrayList;

public class ArithmeticCalculator {

    //연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    private ArrayList<Number> results = new ArrayList<>(); //<Number>로 받아서 여러 타입 저장

    public <T extends Number, S extends Number> Number calculate(T num1, S num2, OperatorType op) {

        double numInput1 = num1.doubleValue();
        double numInput2 = num2.doubleValue();

        Number lastResult;
        double result = 0;

        switch (op) {
            case PLUS:
                result = numInput1 + numInput2;
                break;
            case MINUS:
                result = numInput1 - numInput2;
                break;
            case MULTIPLY:
                result = numInput1 * numInput2;
                break;
            case DIVIDE:
                if (numInput1 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없음");
                } else {
                    result = numInput1 / numInput2;
                }
                break;
            default:
                System.out.println("다시 입력해 주세요");
        }

        //마지막 타입 변경
        if (result == (int) result) {
            lastResult = (int) result; // 실제 정수이면 Integer로 저장
        } else {
            lastResult = result;       // 아니면 Double로 저장
        }
        //연산 결과 추가
        results.add(lastResult);
        return lastResult;
    }

    public ArrayList<Number> getResults() {
        return results;
    }

    public void setResults(ArrayList<Number> results) {
        this.results = results;
    }

    //가장 먼저 저장된 데이터 삭제 기능
    public void resultRemove() {
        results.remove(0);
    }

}
