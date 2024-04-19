import java.util.Scanner;

public class BinaryPrinter {

    public static void main(String[] args) {

        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 사용자에게 입력 요청
        System.out.print("입력 숫자 : ");

        // 숫자 입력 받기
        int inputNumber = scanner.nextInt();

        //0~255 숫자 입력받기
        while (!(inputNumber >= 0 && inputNumber < 256)){
            System.out.println("0~255 숫자를 입력해주세요.");
            // 사용자에게 입력 요청
            System.out.print("입력 숫자 : ");
            // 숫자 재입력 받기
            inputNumber = scanner.nextInt();
        }

        //이진수 출력 배열
        int[] resultArray = new int[8];

        int number = 0;
        //2진수 변환 로직
        for (;0 != inputNumber / 2; number++){
            resultArray[number] = inputNumber % 2;
            inputNumber = inputNumber / 2;
        }

        if(inputNumber != 0)
            resultArray[number] = 1;
        System.out.println("inputNumber :"+inputNumber);


        System.out.print("출력 숫자 :");
        for (int resultNum = 7; resultNum >= 0; resultNum--) {
            System.out.print(resultArray[resultNum]);
            if(resultNum == 4){
                System.out.print(" ");
            }
        }
        System.out.println();

        // Scanner 닫기
        scanner.close();
    }
}
