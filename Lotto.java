import java.util.*;

public class Lotto {
    //멤버필드
    final int LOTTO_NUMS = 6;
    private int numOfSet;

    private Set<Integer> pixNum;


    private Set<Integer> hateNum;


    //setter getter

    public void setNumOfSet(int numOfSet) {this.numOfSet = numOfSet;}

    public void setPixNum(String pixNum) {
        if (pixNum == null || pixNum.trim().isEmpty()) {
            this.pixNum = new HashSet<>();
            return;
        }
        String[] pixNumArr = pixNum.split(",\\s*");
        this.pixNum = new HashSet<Integer>();
        for (String numStr:pixNumArr) {

            try {
                int num = Integer.parseInt(numStr);
                if (0 < num && num < 46) {
                    this.pixNum.add(num);
                } else {
                    System.out.println("유효하지 않는 번호: " + num);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자 변환 오류: " + numStr);
                System.exit(1);
            }
        }

    }

    public void setHateNum(String hateNum) {
        if (hateNum == null || hateNum.trim().isEmpty()) {
            this.hateNum = new HashSet<>(); // 빈 세트로 초기화
            return;
        }
        String[] hateNumArr = hateNum.split(",\\s*");
       this.hateNum = new HashSet<>();
        for (String numStr:hateNumArr) {
            try {
                int num = Integer.parseInt(numStr);
                if (0 < num && num < 46) {
                    this.hateNum.add(num);
                } else {
                    System.out.println("유효하지 않는 번호: " + num);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자 변환 오류: " + numStr);
                System.exit(1);
            }
        }
    }

    public Set<Integer> getPixNum() {return pixNum;}

    public Set<Integer> getHateNum() {return hateNum;}

    //메서드

    //로또번호생성 기본
    public void generateLottoNumbers() {
        for (int i = 0; i < numOfSet; i++) {
            Set<Integer> set = new HashSet<Integer>();
            while(set.size() < LOTTO_NUMS) {
                set.add((int) (Math.random() * 45 + 1));
            }
            List<Integer> lottoNumber = new ArrayList<Integer>(set);
            Collections.sort(lottoNumber);
            System.out.println(lottoNumber);
        }
    }
    public void generateLottoNumbers3() {
        for (int i = 0; i < numOfSet; i++) {
            Set<Integer> setLottoNums = new HashSet<Integer>(pixNum);
            while (setLottoNums.size() < LOTTO_NUMS) {
                int randomNum = (int)(Math.random() * 45 + 1);
                if (!hateNum.contains(randomNum) && !pixNum.contains(randomNum)) {
                    setLottoNums.add(randomNum);
                }
            }
            List<Integer> listLottoNums = new ArrayList<>(setLottoNums);
            Collections.sort(listLottoNums);
            System.out.println(listLottoNums);
        }
    }

    //로또번호생성 고급 원하는 번호 포함
//    public void generateLottoNumbers1(){
//
//        for (int i = 0; i < numOfSet; i++) {
//            Set<Integer> setLottoNums = new HashSet<Integer>();
//            setLottoNums.addAll(pixNum);
//            while (setLottoNums.size() < LOTTO_NUMS){
//                int randomNum = (int)(Math.random() * 45 + 1);
//                if (!setLottoNums.contains(randomNum)){
//                    setLottoNums.add(randomNum);
//                }
//            }
//            List<Integer> listlottoNums = new ArrayList<Integer>(setLottoNums);
//            Collections.sort(listlottoNums);
//            System.out.println(listlottoNums);
//        }
//    }

    //로또번호생성 고급 싫어하는 번호 제외
//   public void generateLottoNumbers2() {
//       for (int i = 0; i < numOfSet; i++) {
//           Set<Integer> setLottoNums = new HashSet<Integer>();
//           while (setLottoNums.size() < LOTTO_NUMS) {
//               int randomNum = (int) (Math.random() * 45 + 1);
//               if (!hateNum.contains(randomNum)) {
//                   setLottoNums.add(randomNum);
//               }
//           }
//           List<Integer> listlottoNums = new ArrayList<Integer>(setLottoNums);
//           Collections.sort(listlottoNums);
//           System.out.println(listlottoNums);
//       }
//
//
//   }

   //로또번호생성 고급 원하는번호 포함, 싫어하는 번호 제외
//    public void generateLottoNumbers3() {
//        if(pixNum == null && hateNum == null) {
//            generateLottoNumbers(); // 일반적인 로또 번호 생성
//        } else if (pixNum != null && hateNum == null) {
//            generateLottoNumbers1(); // pixNum만 포함
//        } else if (pixNum == null && hateNum != null) {
//            generateLottoNumbers2(); // hateNum만 제외
//        } else {
//            // pixNum과 hateNum 둘 다 포함
//            for (int i = 0; i < numOfSet; i++) {
//                Set<Integer> setLottoNums = new HashSet<Integer>(pixNum);
//                while (setLottoNums.size() < LOTTO_NUMS) {
//                    int randomNum = (int)(Math.random() * 45 + 1);
//                    if (!hateNum.contains(randomNum) && !pixNum.contains(randomNum)) {
//                        setLottoNums.add(randomNum);
//                    }
//                }
//                List<Integer> listLottoNums = new ArrayList<>(setLottoNums);
//                Collections.sort(listLottoNums);
//                System.out.println(listLottoNums);
//            }
//        }
//    }




//    public void generateLottoNumbers(String[] numStr) {
//        Set<Integer> pixNum = new HashSet<Integer>();
//        for (String num: numStr) {
//            try {
//                int parsedNum = Integer.parseInt(num);
//                if(parsedNum > 0 && parsedNum < 46){
//                    pixNum.add(parsedNum);
//                }else {
//                    System.out.println("유효하지 않는 번호: " + num);
//                    return;
//                }
//            }catch (NumberFormatException e) {
//                System.out.println("숫자 변환 오류: " + num);
//                return;
//            }
//        }
//        for (int i = 0; i < numOfSet; i++) {
//            Set<Integer> set = new HashSet<Integer>();
//            set.addAll(pixNum);
//            while(set.size() < LOTTO_NUMS) {
//                set.add((int) (Math.random() * 45 + 1));
//            }
//            List<Integer> lottoNumber = new ArrayList<Integer>(set);
//            Collections.sort(lottoNumber);
//            System.out.println(lottoNumber);
//        }
//
//
//    }



}

