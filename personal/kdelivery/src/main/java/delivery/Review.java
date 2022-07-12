package delivery;

public class Review {
    private String reviewer;
    private String restaurantName;
    private String menuName;
    private int star;

    public Review(String reviewer, String restaurantName, String menuName, int star) {
        this.reviewer = reviewer;
        this.restaurantName = restaurantName;
        this.menuName = menuName;
        this.star = star;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("\n")
                .append("리뷰어 : ").append(reviewer).append(" [고객님]")
                .append("\n")
                .append("주문 매장 : ").append(restaurantName)
                .append("\n")
                .append("주문 메뉴 : ").append(menuName)
                .append("\n")
                .append("별점 : ").append("*".repeat(Math.max(0, star)))
                .toString();
    }
}
