package example.calculator;

import javax.swing.*;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(":::계산기 프로그램 시작");



        int result = 0;
        String q;

        do {
            System.out.print("첫번 째 수 입력 : ");
            int num1 = sc.nextInt();

            System.out.print("연산 기호 입력(+, -, *, /) : ");
            String opInput = sc.next();
            char op = opInput.charAt(0);

            System.out.print("두번 째 수 입력 : ");
            int num2 = sc.nextInt();


            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 % num2;
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
            System.out.println(num1 +" "+ op + " " + num2 +" = "+result);
            System.out.print("계속 하려면 아무 키, 종료하려면 exit 입력 : ");
            q = sc.next();

        }while (!q.equals("exit"));
        System.out.println(":::계산기 프로그램 종료");
        }
}
