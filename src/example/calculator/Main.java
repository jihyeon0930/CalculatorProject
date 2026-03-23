package example.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(); //인스턴스화

        System.out.println(":::계산기 프로그램 시작");

        String q;

        do {
            System.out.print("첫번 째 수 입력 : ");
            int num1 = sc.nextInt();

            System.out.print("연산 기호 입력(+, -, *, /) : ");
            String opInput = sc.next();
            char op = opInput.charAt(0);

            System.out.print("두번 째 수 입력 : ");
            int num2 = sc.nextInt();

            //Calculator 클래스
            int result = calculator.calculate(op, num1, num2);
//            result = calculatorFunction(op, num1, num2);

            System.out.println(num1 +" "+ op + " " + num2 +" = "+result);
            System.out.print("계속 하려면 아무 키, 종료하려면 exit 입력 : ");
            q = sc.next();

        }while (!q.equals("exit"));

        System.out.println(":::계산기 프로그램 종료");
    }
}
