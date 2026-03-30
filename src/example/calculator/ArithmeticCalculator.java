package example.calculator;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

    //가장 먼저 저장된 데이터 삭제 기능
    public void resultRemove() {
        if (results.isEmpty()) { //isEmpty() : 리스트 비어있음 = true, 값 있음 = false
            System.out.println("삭제할 결과가 없습니다.");
            return;
        }
        results.remove(0);
    }

    /**
     *Scanner로 입력받아 저장된 값들중 입력값보다 큰 값 출력
     * @param value 비교 기준이 되는 값 (이 값보다 큰 값만 출력)
     */
    public void numfilter(double value) {
        String result = results.stream()
                .filter(n -> n.doubleValue() > value)
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", "));
        System.out.println("기준 값 보다 큰 결과 : [" + result + "]");
    }

}
