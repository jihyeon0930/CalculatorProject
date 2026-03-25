package example.calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(); //인스턴스화
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();


        System.out.println(":::계산기 프로그램 시작");

        String q = "";

        do {
            System.out.print("첫번 째 수 입력 : ");
            int num1 = sc.nextInt();

            System.out.print("연산 기호 입력(+, -, *, /) : ");
            String opInput = sc.next();

            OperatorType op = OperatorType.formSymbol(opInput); //formsymbol()메서드 호출, opInput 전달(OperatorType에선 symbol)

            if (op == null) {
                System.out.println("잘못된 연산자 입력, 재입력");
                continue;
            }

            System.out.print("두번 째 수 입력 : ");
            int num2 = sc.nextInt();

            //arithmeticCalculator 기능 가져오기
            int result = arithmeticCalculator.calculate(num1, num2, op);


            System.out.println(num1 +" "+ op.getSymbol() + " " + num2 +" = "+result);
            System.out.print("계속 하려면 아무 키, 종료하려면 exit 입력(삭제시 remove 입력) : ");
            q = sc.next();

        }while (!q.equals("exit") && !q.equals("remove"));

        //remove기능
        if (q.equals("remove")) {
            arithmeticCalculator.resultRemove();
        }

        //getter
        ArrayList<Integer> results = arithmeticCalculator.getResults();
        System.out.println("계산 목록 : " + results);
        

        System.out.println(":::계산기 프로그램 종료");
    }
}
