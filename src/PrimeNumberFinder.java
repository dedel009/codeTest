import java.util.Scanner;

public class PrimeNumberFinder {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 사용자에게 입력 요청
        System.out.print("입력 숫자 : ");

        // 숫자 입력 받기
        int maxNumber = scanner.nextInt();

        //출력 숫자를 담을 배열
        int[] resultArray = new int[maxNumber];

        //출력할 배열의 크기
        int resultArraySize = 0;

        for (int number = 1; number <= maxNumber; number++){
            int[] divisorArray = new int[maxNumber-1];    //약수를 담을 배열
            for (int divisor = 1, arraySize = 0; divisor <= number; divisor++){
                //소수 판단 로직
                if(number % divisor == 0){
                    divisorArray[arraySize] = divisor;
                    arraySize++;
                }
            }

            //출력 배열에 소수 input
            if(divisorArray[1] != 0 && divisorArray[2] == 0){
                resultArray[resultArraySize] = number;
                resultArraySize++;
            }
        }

        System.out.print("출력 숫자 : ");
        for (int resultNum = 0; resultNum <= resultArraySize; resultNum++) {
            if(resultArray[resultNum] != 0) {
                if (resultNum == resultArraySize-1){
                    System.out.println(resultArray[resultNum]);
                }else{
                    System.out.print(resultArray[resultNum]+", ");
                }
            }
        }

        // Scanner 닫기
        scanner.close();
    }
}