package kiosk;

public class KioskService {

    public void printFirstGuide() {
        System.out.println("[안내]안녕하세요. 김밥천국에 오신 것을 환영합니다.");
    }

    public void printSelectMenu() {
        System.out.println("[안내]원하시는 메뉴의 번호를 입력하여 주세요.");
        System.out.println("1) 김밥(1000원) 2) 계란 김밥(1500원) 3) 충무 김밥(1000원) 4) 떡볶이(2000원)");
    }

    public void printCountMenu() {
        System.out.println("[안내]선택하신 메뉴의 수량을 입력하여 주세요.");
        System.out.println("(※ 최대 주문 가능 수량 : 99)");
    }

    public void calculate(KioskStatus kioskStatus) {
        int totalPrice = kioskStatus.calculate();
        System.out.println("[안내]주문하신 메뉴의 총 금액은 " + totalPrice + "원 입니다.");
        System.out.println("[안내]이용해 주셔서 감사합니다.");
    }
}
