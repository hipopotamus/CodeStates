package kiosk;

public enum Menu {
    GimBob("김밥", 1000, 1), EggGimBob("계란 김밥", 1500, 2),
    ChungmuGimBob("충무 김밥", 1000, 3), DDuckBockI("떡볶이", 2000, 4);

    public final String name;
    public final int price;
    public final int index;

    Menu(String name, int price, int index) {
        this.name = name;
        this.price = price;
        this.index = index;
    }
}
