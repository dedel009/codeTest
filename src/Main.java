import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        program:while (true) {

            System.out.println("--------------------");
            System.out.println("1. 소수출력 ");
            System.out.println("2. 이진수 출력 ");
            System.out.println("3. 최고점수 출력 ");
            System.out.println("4. exit ");
            // 사용자에게 입력 요청
            System.out.print("프로그램 선택 : ");

            // 프로그램 숫자 입력 받기
            int inputNumber = scanner.nextInt();

            switch (inputNumber) {
                case 1:
                    System.out.println("소수 출력 프로그램 실행");
                    PrimeNumberFinder(scanner);
                    break;
                case 2:
                    System.out.println("이진수 출력 프로그램 실행");
                    BinaryPrinter(scanner);
                    break;
                case 3:
                    System.out.println("최고점수 출력 프로그램 실행");
                    HighestScorePrinter(scanner);
                    break;
                case 4:
                    scanner.close();
                    break program;
            }
        }

    }

    public static void PrimeNumberFinder(Scanner scanner){

        // 사용자에게 입력 요청
        System.out.println("--------------------");
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

    }

    public static void BinaryPrinter(Scanner scanner){

        // 사용자에게 입력 요청
        System.out.println("--------------------");
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

        System.out.print("출력 숫자 :");
        for (int resultNum = 7; resultNum >= 0; resultNum--) {
            System.out.print(resultArray[resultNum]);
            if(resultNum == 4){
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void HighestScorePrinter (Scanner scanner){

        // 2차원 배열 초기화
        int[][] scores = {
                //1반  2반  3반 4반
                {74, 86, 43, 52}, // 1학년
                {66, 88, 76, 79}, // 2학년
                {74, 66, 65, 78}  // 3학년
        };

        System.out.println("--------------------");
        System.out.println("1. 각 학년의 반별 수학 평균 점수를 높은 순서에서 낮은 순서로 정렬");
        System.out.println("2. 학년 별 수학 평균 점수가 높은 반과 학년 별 평균 값을 출력");
        // 사용자에게 입력 요청
        System.out.print("프로그램 선택 : ");

        // 프로그램 숫자 입력 받기
        int inputNumber = scanner.nextInt();

        if(inputNumber == 1) {
            //각 학년의 반별 수학 평균 점수를 높은 순서에서 낮은 순서로 정렬 로직
            for (int row = 0; row < scores.length; row++) {
                for (int column = 0; column < scores[row].length - 1; column++) {
                    for (int target = 0; target < scores[row].length - 1 - column; target++) {
                        if (scores[row][target] < scores[row][target + 1]) {
                            // 인접한 컬럼을 비교하여 순서 변경
                            int temp = scores[row][target];
                            scores[row][target] = scores[row][target + 1];
                            scores[row][target + 1] = temp;
                        }
                    }
                }
            }

            //각 학년의 반별 수학 평균 점수를 높은 순서에서 낮은 순서로 정렬
            for (int row = 0; row < scores.length; row++) {
                System.out.print((row + 1) + "학년 ");
                for (int column = 0; column < scores[row].length; column++) {
                    if (column == scores[row].length - 1) {
                        System.out.print(scores[row][column]);
                    } else {
                        System.out.print(scores[row][column] + ", ");
                    }
                }
                System.out.println();
            }
        }else {
            //학년 별 수학 평균 점수가 높은 반과 학년 별 평균 값 로직

            //학년 별 평균 점수 저장할 배열
            double[] averageScores = new double[scores.length];

            //평균 점수 계산
            for (int row = 0; row < scores.length; row++) {
                double sum = 0;
                for (int score : scores[row]) {
                    sum += score;
                }
                averageScores[row] = sum / scores[row].length;
            }

            // 각 학년별로 가장 높은 평균 점수를 찾아 출력
            for (int row = 0; row < averageScores.length; row++) {
                // 각 학년별로 가장 높은 평균 점수를 찾기 위한 변수들 초기화
                double maxAverageScore = scores[row][0];
                int maxAverageScoreIndex = 0;

                // 각 학년별로 반의 수학 평균 점수를 비교
                for (int column = 1; column < scores[row].length; column++) {
                    if (scores[row][column] > maxAverageScore) {
                        maxAverageScore = scores[row][column];
                        maxAverageScoreIndex = column + 1;
                    }
                }
                // 학년별로 결과 출력
                System.out.println((row + 1) + "학년 중 수학 평균 점수가 가장 높은 반은 " + maxAverageScoreIndex + "반이며 학년 평균은 " + averageScores[row] + "점 입니다.");
            }
        }
    }
}