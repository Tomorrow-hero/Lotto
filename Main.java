import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("안녕하세요 로또번호 생성기 입니다~~ ^^");
        Scanner sc = new Scanner(System.in);
        Lotto lotto = new Lotto();
        boolean isRunning = true;
        while (isRunning) {
//
            System.out.println("----------------------------");
            System.out.println("1:로또번호 생성 *기본*");
            System.out.println("  로또번호 전체를 생성해줍니다.");
            System.out.println("----------------------------");
            System.out.println("2:로또번호 생성 *고급*");
            System.out.println("  원하는 번호 포함하기");
            System.out.println("  싫어하는 번호 제외하기");
            System.out.println("  고급기능 포함되어 있습니다.");
            System.out.println("----------------------------");
            System.out.println("3:프로그램 종료");
            System.out.println("----------------------------");
            System.out.print("원하시는 번호를 선택해주세요: ");
            int choseNum = sc.nextInt();

            switch (choseNum) {
                case 1:
                    System.out.println("로또번호 생성 *기본*을 선택하셨습니다.");
                    System.out.println("생성할 로또번호 세트수를 입력해주세요");
                    System.out.println("예)5");
                    System.out.print("--> ");
                    lotto.setNumOfSet(sc.nextInt());
                    lotto.generateLottoNumbers();
                    break;
                case 2:
                    System.out.println("로또번호 생성 *고급*을 선택하셨습니다.");
                    System.out.println("생성할 로또번호 세트수를 입력해주세요");
                    System.out.println("예)5");
                    System.out.print("--> ");
                    lotto.setNumOfSet(sc.nextInt());
                    sc.nextLine();
                    System.out.println("원하시는 번호를 입력해주세요");
                    System.out.println("1 ~ 45 사이의 숫자를 입력해주세요");
                    System.out.println("예)1, 5, 13");
                    System.out.println("만약 원하시는 번호가 없으면 엔터를 쳐 주세요");
                    System.out.println("-->");
                    lotto.setPixNum(sc.nextLine());
                    System.out.println("제외 할 번호를 입력해주세요");
                    System.out.println("1 ~ 45 사이의 숫자를 입력해주세요");
                    System.out.println("예)2, 4, 21");
                    System.out.println("만약 제거하실 번호가 없으면 엔터를 쳐 주세요");
                    System.out.println("-->");
                    lotto.setHateNum(sc.nextLine());
                    lotto.generateLottoNumbers3();

                    break;
                case 3:
                    System.out.println("프로그램 종료");
                    isRunning = false;
                    break;

                default:
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요");
                    break;
            }
        }
        sc.close();


    }
}