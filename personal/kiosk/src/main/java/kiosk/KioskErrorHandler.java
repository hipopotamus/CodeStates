package kiosk;

public class KioskErrorHandler {

    public boolean menuIndexError(int i) {
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            System.out.println("[안내]메뉴에 포함된 번호를 입력하여 주세요.");
            System.out.println("");
            return false;
        }
        return true;
    }

    public boolean menuCountError(int i) {
        if (i <= 0 || i >= 100) {
            System.out.println("[경고]" + i + "개는 입력하실 수 없습니다.");
            System.out.println("[경고]수량 선택 화면으로 돌아갑니다.");
            System.out.println("");
            return false;
        }
        return true;
    }

}
