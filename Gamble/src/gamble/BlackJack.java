package gamble;
/* 
 * [게임 규칙]
 * 
 * 공통
 *  - ?��???? ?��?��?�� 1:1 ??�?
 *  - 52?��?�� ?��?��?�� 카드�? ?��?��(13?��(A~K)?�� 4묶음_
 *    ?? 문양(?��?��?��?��, ?��?��?��몬드, ?��?��, ?��로버)?�� ?��미는 ?��?��
 *  - 최초 기본 카드?�� 각각 2?��?�� 배분
 *  - 'J, Q, K'?�� 10?��?���? 계산
 *  - 'A'?�� '1?��' ?��?�� '11?��'?���? 계산?��?��?��,
 *    '?��?�� > 21?�� == 1?��'?���? 계산, '?��?�� <= 21?�� == 11?��'?���? 계산
 * 
 * ?��??
 *  - 기본 카드�? 받고 ?�� ?�� ?��???�� ?��?���? 결정?���? ?��까�?, 'Hit'or'Stay'�? 결정?��?�� ?��
 *  - 'Hit'결정 ?�� ?��???�� 카드 1?��?�� 뽑음 
 *    'Hit'?�� 4번만 �??��. �? 6개의 카드�? �?�? ?�� ?��?��
 *  - 'Stay'결정 ?�� 각자?�� 카들�? 모두 공개?���?, ?��?���? 비교?��?�� ?��?���? 결정
 * 
 * ?��?��
 *  - ?��?��?�� �? 번째 카드?�� ?��???���? 보여주�? ?��?��
 *    ?? '?'�? ?��?��
 *  - ?��??�? 'Hit'or'Stay'�? 결정?���?, �? ?��?���? 비교?��
 *    ?��?��?�� ?��?���? '21?�� ?��?��'?���?, ?��???�� ?��?��보다 ?��?�� 경우 카드 1?��?�� 뽑음
 *    ?? 게임 진행 �? 1?���? 뽑을 ?�� ?��?��
 *
 * ?��?��
 * 1.?��?? ?���?
 *  - ?��???�� 기본 카드 2?��?�� 블랙?��(A, K)?���?, ?��?��?�� ?��?��?���? ?��?�� 경우
 *  - 각자 ?��?���? '21?�� ?��?��'?���?, ?��???�� ?��?���? ?�� ?��?�� 경우
 *  - ?��???�� ?��?���? '21?�� ?��?��'?���?, ?��?��?�� ?��?��?�� '21?��?�� 초과'?�� 경우
 *  
 * 2.?��?? ?���?
 *  - ?��?��?�� 기본 카드 2?��?�� 블랙?��(A, K)?���?, ?��???�� ?��?��?���? ?��?�� 경우
 *  - 각자 ?��?���? '21?�� ?��?��'?���?, ?��?��?�� ?��?���? ?�� ?��?�� 경우
 *  - ?��???�� ?��?���? '21?��?�� 초과'?�� 경우
 *  
 * 3.무승�?
 *  - 각자 기본 카드 2?��?�� 블랙?��(A, K)?�� 경우 
 *  - 각자 ?��?���? ?��?��?�� 경우 
 */
 
 
import java.util.Scanner;
 
class blackjackGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        boolean uCardSetFull = false;        // '?��??'?�� 카드set?�� 비어?��?�� ?��?���? 초기?��
        boolean dCardSetFull = false;        // '?��?��'?�� 카드set?�� 비어?��?�� ?��?���? 초기?��
        boolean gameWin = true;              // 게임 결과 ?��?��. ?��리로 초기?��
        int comCardSet[] = new int[52];      // 무작?���? 결정?�� ?��?���? ???��
 
        comCardSetInit(comCardSet);          // 공용 카드set ?��?�� �? 초기?�� 
        
        // ?��?��?��: ?��?��?�� 공용 카드set ?��?��
/*      System.out.print("공용 카드set");
        comCardSetPrint(comCardSet);
*/
        // ?��?��?��?��, ?��?�� 블랙?�� ?��?��?�� ?��?�� ???�� 공간
        boolean uBlackjack[] = new boolean[2];        // ?��???�� 카드set?�� 블랙?�� ?��?��?���? ?��?��?��?�� 공간
        boolean dBlackjack[] = new boolean[2];        // ?��?��?�� 카드set?�� 블랙?�� ?��?��?���? ?��?��?��?�� 공간
        boolean uBlackjackWin = false;                // ?��???�� 블랙?�� ?���? ?��?�� 초기?��
        boolean dBlackjackWin = false;                // ?��?��?�� 블랙?�� ?���? ?��?�� 초기?��
        
        // 카드 기본 ?��?��: ?��?? 2?��, ?��?�� 2?�� 배분
        String uCardSet[] = new String[6];            // ?��???�� 카드set �?�?
        String dCardSet[] = new String[3];            // ?��?��?�� 카드set �?�?
        cardSetInit(uCardSet, dCardSet);              // ?��??�? ?��?��?�� 카드set ?��?��
        basicCardSetInit(comCardSet, uCardSet, uBlackjack);        // ?��???�� 기본 카드 2?�� 배분
        basicCardSetInit(comCardSet, dCardSet, dBlackjack);        // ?��?��?�� 기본 카드 2?�� 배분
        
        // 게임 진행 루프
        gameLoop(comCardSet, uCardSet, dCardSet, uCardSetFull, dCardSetFull,
                uBlackjack, dBlackjack, uBlackjackWin, dBlackjackWin, gameWin, scan);
 
        // 결과 출력
        gameResult(uCardSet, dCardSet, uBlackjackWin, dBlackjackWin, gameWin);
 
        scan.close();
    }
 
////////////////////////// 메소?�� ?��?��
 
/*
 * 52?��?�� ?��?��?��?�� ?��?��?�� 공용 카드set?�� ?��?�� �? 초기?��
 * ?��?��?�� 카드?�� 중복불�?(?��?��?��?��,?��?��?��몬드,?��?��,?��로버 13?��?�� 4?�� 존재)
 * ?��?�� ?���??��?�� 무작?���? ?��?��
 */
    public static void comCardSetInit(int comCardSet[]) {
        
        boolean noSame[] = new boolean[52];
        
        // 무작?�� ?��?�� 결정 ?�� 중복 불�?�? ?��?�� �?�?
        for(int i = 0; i < noSame.length ; i++) {
            noSame[i] = false;
        }
        
        // �? 결정?�� 개수만큼 중복?��?�� ?��?���? ?��?�� ?��까�? 무작?�� 결정?�� 반복
        int randLoop = 0;
        int randTemp;
        while(randLoop < 52) {
            randTemp = (int)(Math.random() * 52);
            if(noSame[randTemp] == false) {
                noSame[randTemp] = true;
                comCardSet[randLoop] = randTemp + 1;
                randLoop++;
            }
        }
    }
    
    // ?��?�� 공용 카드set?�� 출력
    public static void comCardSetPrint(int cardSet[]) {
        for(int i=0; i < cardSet.length; i++) {
            if (i % 3 == 0) {
                System.out.println();
            }
            System.out.print("cardSet[" + i + "] = " + cardSet[i] + " ");
        }
        System.out.println("\n");
    }
    
    // ?��??�? ?��?��?�� 카드set 초기?��
    public static void cardSetInit(String uCardSet[], String dCardSet[]) {
        for (int i = 0; i < uCardSet.length; i++) {
            uCardSet[i] = "0";
        }
        for (int i = 0; i < dCardSet.length; i++) {
            dCardSet[i] = "0";
        }
    }
    
    // 공용 카드?��?�� 초기 카드 2?�� 뽑기
    public static void basicCardSetInit(int comCardSet[], String cardSet[], boolean blackjack[]) {
        String drawCardStr = "";
        int drawCard = 0;
        int cardSetPos = 0;
        int drawLoop = 0;
        
        // 공용 카드set?��?�� 뽑�? 카드?�� ?��?�� 뽑�? ?��?��
        while (drawLoop < 2) {
            cardSetPos = (int)(Math.random() * 52);
            drawCard = comCardSet[cardSetPos];
            if (drawCard != 0) {
                // ?��?��?��: 공용 카드set?��?�� 뽑�? 카드?�� ?���? ?��?��
                // System.out.println("뽑�? 카드?�� 배열 ?��?��?�� = " + cardSetPos);
                
                drawCardStr = checkNum(drawCard, blackjack);
                cardSet[drawLoop] = drawCardStr;
                comCardSet[cardSetPos] = 0;
                drawLoop++;
            }
        }
 
/*      // ?��?��?��: 블랙?��
        cardSet[0] = checkNum(1, blackjack);
        cardSet[1] = checkNum(13, blackjack);
*/
    }
 
/*
 * 카드번호 체크 메소?��?�� ?�� �?�? 종류�? ?��?���?,
 * �? 번째 체크?��?���? 블랙?��?�� ?��?��
 */
    // 카드번호 체크 �? �??�� + 블랙?�� ?��?��
    public static String checkNum(int cardNum, boolean blackjack[]) {
        String result = "";
 
        // 뽑�? 카드?�� 번호�? '1'?���? 'A'�? �??�� 
        if (cardNum == 1 || cardNum % 13 == 1) {
            result = "A";
            blackjack[0] = true;
        } else if (cardNum % 13 == 0) {
            cardNum = 13;
            blackjack[1] = true;
        }
        else {
            cardNum = (cardNum % 13);
        }
 
        // 카드 번호�? '11' ?��?��?���? 'J, Q, K'�? �??��
        if (cardNum > 10) {
            switch (cardNum) {
                case 11:
                    result = "J";
                    break;
                case 12:
                    result = "Q";
                    break;
                case 13:
                    result = "K";
                    break;
            }
        }
        // ?���? ?��?���? �??�� ?��?��
        else {
            if (cardNum > 1 && cardNum <= 10) {
                result = Integer.toString(cardNum);
            }
        }
 
        return result;
    }
    
    // 카드번호 체크 �? �??��
    public static String checkNum(int cardNum) {
        String result = "";
 
        // ?��?�� 카드 ?��?���? �??��
        if (cardNum == 1 || cardNum % 13 == 1) {
            result = "A";
        } else if (cardNum % 13 == 0) {
            cardNum = 13;
        }
        else {
            cardNum = (cardNum % 13);
        }
 
        // 카드 번호�? '11' ?��?��?���? 'J, Q, K'�? �??��
        if (cardNum > 10) {
            switch (cardNum) {
                case 11:
                    result = "J";
                    break;
                case 12:
                    result = "Q";
                    break;
                case 13:
                    result = "K";
                    break;
            }
        }
        // ?���? ?��?���? �??�� ?��?��
        else {
            result = Integer.toString(cardNum);
        }
 
        return result;
    }
    
    // 게임 반복 루프
    public static void gameLoop(int comCardSet[], String uCardSet[], String dCardSet[],
            boolean uCardSetFull, boolean dCardSetFull,
            boolean uBlackjack[], boolean dBlackjack[],
            boolean uBlackjackWin, boolean dBlackjackWin, boolean gameWin, Scanner scan) {
        
        System.out.println("게임?�� ?��?��?��?��?��.");
        System.out.println();
        
        // 최초?�� 배분?�� 기본 카드 2?��?�� 각각 공개
        System.out.println("?��???���? 배분?�� 카드");
        cardSetNum(uCardSet, 1);
        
        System.out.println("?��?��?���? 배분?�� 카드");
        cardSetNum(dCardSet, 2);
        System.out.println();
        
        // ?��???�� 기본 카드 2?��?�� 'A'?? 'K'�? ?��???�� 블랙?�� ?��리로 ?��?��
        if (uBlackjack[0] == true && uBlackjack[1] == true) {
            uBlackjackWin = true;
        } 
        // ?��?��?�� 기본 카드 2?��?�� 'A'?? 'K'�? ?��?��?�� 블랙?�� ?��리로 ?��?��
        if (dBlackjack[0] == true && dBlackjack[1] == true) {
            dBlackjackWin = true;
        }
        
        // 반복 ?��?��
        while (true) {
            // 카드�? 뽑�? ?�� ?��???�� ?��?���? '21'?�� 초과?���? 즉시 게임 ?���?
            if (pointResult(uCardSet) > 21) {
                gameWin = false;
                break;
            }
            
            // ?��?? or ?��?���? '블랙?��'?���? 즉시 게임 종료
            if (uBlackjackWin || dBlackjackWin) {
                break;
            } else if (!gameWin) {
                break;
            }
            else {
            // ?��???���? 'Hit or Stay' 물어�?
            System.out.print("?��?��?�� 결정?��주세?��. Hit(1), Stay(2): ");
            int decision = scan.nextInt();
            System.out.println();
        
                // ?��???�� 'Hit' 결정 ?�� 추�? 카드 1?�� 받음            
                if (decision == 1) {
        
                    // 카드 뽑기 조건: ???��?�� 카드set?�� 비어?��?�� ?��?��?��?��?�� ?��
                    if (!cardFull(uCardSet, uCardSetFull)) {
                        drawCardOne(comCardSet, uCardSet);        // 카드 뽑기
                    }
                    // 카드�? �? 찾을 경우 강제�? 'Stay'�? ?��?��
                    else {
                        System.out.println("?�� ?��?�� 카드�? 받을 ?�� ?��?��?��?��. 강제�? 'Stay'?��?��?��.");
                        decision = 2;
                    }
                    
                    // �? ?��?�� 비교 ?�� ?��?��?�� ?��?���? ?��?��?��?��보다 ?��?���?, ?��?�� 추�? 카드 1?��  ?? 1?�� ?��?��
                    // 카드 뽑기 조건: ?��?��?�� ?��?���? ?��???�� ?��?��보다 ?���?, 공간?�� ?��?���? ?��?�� ?��?��?��?�� ?��(= 카드�? 2개인 ?��?��)
                    if (pointResult(dCardSet) < pointResult(uCardSet) && !cardFull(dCardSet, dCardSetFull)) {        
                        drawCardOne(comCardSet, dCardSet);        // 카드 뽑기
                    }
                    
                    // 카드�? 뽑�? ?�� ?��???�� ?��?���? '21'?�� 초과?���? 즉시 게임 ?���?
                    if (pointResult(uCardSet) > 21) {
                        gameWin = false;
                        break;
                    }
                    
                    System.out.println("?��???���? 배분?�� 카드 ?��?��");
                    cardSetNum(uCardSet, 1);
                    
                    System.out.println("?��?��?���? 배분?�� 카드 ?��?��");
                    cardSetNum(dCardSet, 2);
                    
                } else if (decision == 2) {
                    // �? ?��?�� 비교 ?�� ?��?��?�� ?��?���? ?��?��?��?��보다 ?��?���? ?��?�� 추�? 카드 1?��  ?? 1?�� ?��?��
                    
                    // 카드 뽑기 조건: ?��?��?�� ?��?���? ?��???�� ?��?��보다 ?���?, 공간?�� ?��?���? ?��?�� ?��?��?��?�� ?��(= 카드�? 2개인 ?��?��)
                    if (pointResult(dCardSet) < pointResult(uCardSet) && !cardFull(dCardSet, dCardSetFull)) {        
                        drawCardOne(comCardSet, dCardSet);        // 카드 뽑기
                    }
                    break;
                }
                else {
                    // ?��?�� 처리
                    System.out.println("?���? ?��?��?��?��?��?��?��. ?��?�� ?��?��?��주세?��");
                    System.out.println();
                }
            }
        }
    }
    
    // 카드 1?�� 뽑기
    public static void drawCardOne(int comCardSet[], String cardSet[]) {
        int drawLoop = 0;
        int cardSetPos = 0;
        int drawCard = 0;
        String drawCardStr = "";
        while (drawLoop < 1) {
            cardSetPos = (int)(Math.random() * 52);
            drawCard = comCardSet[cardSetPos];
    
            if (drawCard != 0) {
                // ?��?��?��: 공용 카드set?��?�� 뽑�? 카드?�� ?���? ?��?��
                // System.out.println("뽑�? 카드?�� 배열 ?��?��?�� = " + cardSetPos);
    
                drawCardStr = checkNum(drawCard);
                for (int i = 0; i < cardSet.length; i++) {
                    if (cardSet[i] == "0") {
                        cardSet[i] = drawCardStr;
                        comCardSet[cardSetPos] = 0;
                        drawLoop++;
                        break;
                    }
                }
            }
        }
    }
 
    // 배분?�� 카드 출력
    public static void cardSetNum(String cardSet[], int index) {
        
        // 'index' 값이 1?���? 카드set 공개
        // 'index' 값이 2�? 카드set?��?�� 카드 1�? ?���?
        if (index == 1) {
            for (int i = 0; i < cardSet.length; i++) {
                if (cardSet[i] == "0") {
                    System.out.print(" ");
                }
                else {
                    System.out.print(cardSet[i] + " ");
                }
            }
            System.out.println();
        } else if (index == 2) {
            for (int i = 0; i < cardSet.length; i++) {
                if (i == 0) {        // �? 번째 ?��리의 카드 ?���?
                    System.out.print("? ");
                }
                else {
                    if (cardSet[i] == "0") {
                        System.out.print(" ");
                    }
                    else {
                        System.out.print(cardSet[i] + " ");
                    }
                }
            }
            System.out.println();
        } 
        else {
            // ?��?�� 처리
            System.out.println("?��버그. ?��?��?�� 값이 ?��못되?��?��?��?��.");
        }
    }
    
    // ?��???�� 카드set?�� �? �? ?��?��?���? 체크
    public static boolean cardFull(String cardSet[], boolean cardSetFull) {
        int count = 0;
        for (int i = 0; i < cardSet.length; i++) {
            if (cardSet[i] == "0") {
                count++;
            }
        }
        // 비어?��?�� 개수�? ?��?���? �? �? ?��?��
        if (count == 0) {
            cardSetFull = true;
        }
        
        return cardSetFull;
    }
    
    // ?��?�� 구하�?
    public static int pointResult(String cardSet[]) {
        int point = 0;
        
        // 1�? ?��?�� ?��?��: ?��?���? 카드?�� ?��?�� ?��?���? ?��르게 ?��?��
        for (int i = 0; i < cardSet.length; i++) {
            if (cardSet[i] == "A") {
                point += 1;
            } else if (cardSet[i] == "J") {
                point += 10;
            } else if (cardSet[i] == "Q") {
                point += 10;
            } else if (cardSet[i] == "K") {
                point += 10;
            } else if (Integer.parseInt(cardSet[i]) > 1 
                    && Integer.parseInt(cardSet[i]) <= 10) {
                point += Integer.parseInt(cardSet[i]);
            } 
            else {
                point += 0;
            }
        }
        // 2�? ?��?�� ?��?��: 1�? ?��?�� ?��?��?�� ?��?�� ?�� 카드set?�� 'A'�? 존재?�� 경우,
        // 10?��?�� 추�??�� ?��?���? '21?�� ?��?��'�? 10?�� 추�?(= 'A'?�� '11?��'�? 같�? ?���?)
        for (int i = 0; i < cardSet.length; i++) {
            if (cardSet[i] == "A" && point + 10 <= 21) {
                point += 10;
            } 
        }
    
        return point;
    }
    
/*
 * ?��?��
 * 1.?��?? ?���?
 *  - ?��???�� 기본 카드 2?��?�� 블랙?��(A, K)?���?, ?��?��?�� ?��?��?���? ?��?�� 경우
 *  - 각자 ?��?���? '21?�� ?��?��'?���?, ?��???�� ?��?���? ?�� ?��?�� 경우
 *  - ?��???�� ?��?���? '21?�� ?��?��'?���?, ?��?��?�� ?��?��?�� '21?��?�� 초과'?�� 경우
 *  
 * 2.?��?? ?���?
 *  - ?��?��?�� 기본 카드 2?��?�� 블랙?��(A, K)?���?, ?��???�� ?��?��?���? ?��?�� 경우
 *  - 각자 ?��?���? '21?�� ?��?��'?���?, ?��?��?�� ?��?���? ?�� ?��?�� 경우
 *  - ?��???�� ?��?���? '21?��?�� 초과'?�� 경우
 *  
 * 3.무승�?
 *  - 각자 기본 카드 2?��?�� 블랙?��(A, K)?�� 경우 
 *  - 각자 ?��?���? ?��?��?�� 경우 
 */
    
    // 결과 출력
    public static void gameResult(String uCardSet[], String dCardSet[], 
            boolean uBlackjackWin, boolean dBlackjackWin, boolean gameWin) {
        System.out.println("카드�? ?��?��?��?��?��.");
        System.out.println();
        
        // ?��???���? 배분?�� 카드?? ?��?�� 출력
        System.out.println("?��???���? 배분?�� 카드");
        cardSetNum(uCardSet, 1);
        
        System.out.println("?��???�� ?��?�� = " + pointResult(uCardSet));
        System.out.println();
        
        // ?��?��?���? 배분?�� 카드?? ?��?�� 출력
        System.out.println("?��?��?���? 배분?�� 카드");
        cardSetNum(dCardSet, 1);
        
        System.out.println("?��?��?�� ?��?�� = " + pointResult(dCardSet));
        System.out.println();
        
        // 결과 메시�? - 블랙?�� ?���?
        if (uBlackjackWin && !dBlackjackWin) {
            System.out.println("??�?! ?�� 축하?��?��?�� ?�� '블랙?��'?���? ?���?!!");
        } else if (!uBlackjackWin && dBlackjackWin) {
            System.out.println("?��... '블랙?��'?���? ?���?!");
        } else if (uBlackjackWin && dBlackjackWin) {
            System.out.println("?��?��?���?!! '블랙?��'?���? 무승�?!!!");
        }
        // 결과 메시�? - ?��?�� 비교
        else {
            if (gameWin && pointResult(uCardSet) > pointResult(dCardSet) 
                    && pointResult(uCardSet) <= 21
                    || gameWin && pointResult(uCardSet) < pointResult(dCardSet)
                    && pointResult(dCardSet) > 21) {
                System.out.println("결과 = ?�� 축하?��?��?�� ?�� ?��리하?��?��?��?��!!");
            } else if (gameWin && pointResult(uCardSet) == pointResult(dCardSet)
                    && pointResult(uCardSet) <= 21) {
                System.out.println("?��?��?���?... 무승�??��?��?��!");
            }
            else {
                System.out.println("결과 = ?���?!");
            }
        }
    }
}



