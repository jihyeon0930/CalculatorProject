package example.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        System.out.println(":::계산기 프로그램 시작");
        String q = "";

        do {
            System.out.print("첫번 째 수 입력 : ");
            String num1Str = sc.next();

            System.out.print("연산 기호 입력(+, -, *, /) : ");
            String opInput = sc.next();

            //formsymbol()메서드 호출, opInput 전달(OperatorType에선 symbol)
            OperatorType op = OperatorType.fromSymbol(opInput);

            if (op == null) {
                System.out.println("잘못된 연산자 입력, 재입력");
                continue;
            }

            System.out.print("두번 째 수 입력 : ");
            String num2Str = sc.next();

            try {
                Number num1 = parseNumber(num1Str);
                Number num2 = parseNumber(num2Str);

                //arithmeticCalculator 기능 가져오기
                Number result = arithmeticCalculator.calculate(num1, num2, op);

                System.out.println(num1 +" "+ op.getSymbol() + " " + num2 +" = "+result);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 올바르게입력해주세요.");
                continue;
            }

            System.out.print("계속 하려면 아무 키, 종료하려면 exit, 더보기 more 입력 : ");
            q = sc.next();

        }while (!q.equals("exit") && !q.equals("more"));
        //반복 종료

        if(q.equals("more")) {
            System.out.println("1. 삭제 remove 입력");
            System.out.println("2. 특정 값보다 큰 결과 출력");
            System.out.print("숫자 입력 : ");
            String sub = sc.next();
            if(sub.equals("1")){
                arithmeticCalculator.resultRemove();//remove기능
            } else if(sub.equals("2")) {
                double value;
                while (true) {
                    System.out.print("기준 값 입력 : ");
                    try {
                        value = sc.nextDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println("숫자를 입력해주세요.");
                        sc.next();//잘못된 값 버림
                    }
                }
                arithmeticCalculator.numfilter(value);//filter 기능
            }
        }

        //getter
        ArrayList<Number> results = arithmeticCalculator.getResults();
        System.out.println("계산 목록 : " + results);

        System.out.println(":::계산기 프로그램 종료");
    }

    //String -> double로 바꾸기
    private static Number parseNumber(String input) {
        if (input.contains(".")){
            return Double.parseDouble(input);
        } else {
            return Integer.parseInt(input);
        }
    }
}