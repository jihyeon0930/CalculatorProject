package example.calculator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    //연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    private ArrayList<Integer> results = new ArrayList<>();

    //양의 정수 2개와 연산기호 매개변수로 받기
    public int calculate(char op, int num1, int num2) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없음");
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                System.out.println("다시 입력해 주세요");
        }

        results.add(result);
        return result;
    }

    public ArrayList<Integer> getResults() {
        return results;
    }

    public void setResults(ArrayList<Integer> results) {
        this.results = results;
    }
}
