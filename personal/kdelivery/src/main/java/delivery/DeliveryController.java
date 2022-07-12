package delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DeliveryController {

    private final RestaurantRepository restaurantRepository = RestaurantRepository.getRestaurantRepository();
    private final ReviewRepository reviewRepository = ReviewRepository.getReviewRepository();
    private final DeliveryErrorHandler deliveryErrorHandler = new DeliveryErrorHandler(restaurantRepository, reviewRepository);

    public void adaptor(int i) throws InterruptedException {

        switch (i) {
            case 1:
                addRestaurant();
                break;
            case 2:
                getReview();
                break;
            case 3:
                getRestaurant();
                break;
            case 4:
                orderMenu();
                break;
            case 5:
                review();
                break;

        }

    }

    public void printMainGuide() {
        System.out.println("\n[치킨의 민족 프로그램 V1] ");
        System.out.println("-------------------------");
        System.out.println("1) [사장님용] 음식점 등록하기");
        System.out.println("2) [고객님과 사장님용] 음식점 별점 조회하기");
        System.out.println("3) [고객님과 사장님용] 음식점 조회하기");
        System.out.println("4) [고객님용] 음식 주문하기");
        System.out.println("5) [고객님용] 별점 등록하기");
        System.out.println("6) 프로그램 종료하기");
        System.out.println("-------------------------");
        System.out.println("[시스템] 무엇을 도와드릴까요?\n");
    }

    public void printEnd() throws InterruptedException {
        System.out.println("\n[안내] 이용해주셔서 감사합니다.\n");
        TimeUnit.SECONDS.sleep(1);
    }

    private void addRestaurant() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("\n[안내] 반갑습니다. 가맹주님!\n");
        System.out.println("[안내] 음식점 상호는 무엇인가요?\n");
        String restaurantName = input.next();
        if (!deliveryErrorHandler.restaurantNameDuplicate(restaurantName)) {
            return;
        }

        System.out.println("\n[안내] 대표 메뉴 이름은 무엇인가요?\n");
        String firstMenuName = input.next();

        System.out.println("\n[안내] 해당 메뉴 가격은 얼마인가요?\n");
        int menuPrice = input.nextInt();
        if (!deliveryErrorHandler.illegalMenuPrice(menuPrice)) {
            return;
        }

        Menu menu = new Menu(firstMenuName, menuPrice);
        Restaurant restaurant = new Restaurant(restaurantName, menu);
        restaurantRepository.add(restaurant);
        System.out.println("\n[안내]" + restaurantName + "에 음식(" + firstMenuName + ", " + menuPrice + ") 추가되었습니다.\n");
        System.out.println("[시스템] 가게 등록이 정상 처리되었습니다.\n");
        TimeUnit.SECONDS.sleep(2);
    }

    private void getReview() {
        List<Review> reviewList = reviewRepository.reviewList;
        Scanner input = new Scanner(System.in);

        System.out.println("");
        for (Review review : reviewList) {
            System.out.println(review);
            System.out.println("");
        }

        System.out.println("[안내] 나가기 : 아무버튼 + 엔터");
        String end = input.next();
    }

    private void getRestaurant() {
        List<Restaurant> restaurantList = restaurantRepository.restaurantList;
        Scanner input = new Scanner(System.in);

        System.out.println("\n[안내] 등록된 상호 내역");
        System.out.println("-------------------------");
        restaurantList.forEach(restaurant -> System.out.println(restaurant.getName()));
        System.out.println("");
        System.out.println("[안내] 나가기 : 아무버튼 + 엔터");
        String end = input.next();
    }

    private void orderMenu() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("\n[안내] 고객님! 메뉴 주문을 진행하겠습니다!\n");
        System.out.println("[안내] 주문자 이름을 알려주세요!\n");
        String orderName = input.next();

        System.out.println("\n[안내] 주문할 음식점 상호는 무엇인가요?\n");
        String restaurantName = input.next();
        if (!deliveryErrorHandler.nonExistRestaurant(restaurantName)) {
            return;
        }

        Restaurant restaurant = restaurantRepository.getRestaurantByName(restaurantName).get();

        System.out.println("\n" + restaurantName + "의 메뉴");
        System.out.println("-------------------------");
        ArrayList<Menu> menuList = restaurant.getMenuList();
        menuList.forEach(menu -> System.out.println(menu.getName() + ", " + menu.getPrice()));
        System.out.println("");

        System.out.println("\n[안내] 주문할 메뉴 이름을 알려주세요!\n");
        String menuName = input.next();
        if (!deliveryErrorHandler.nonExistMenu(restaurant, menuName)) {
            return;
        }

        System.out.println("\n[안내] " + orderName + "님!\n");
        System.out.println("[안내] " + restaurantName + "매장에 " + menuName + "주문이 완료되었습니다.\n");
        TimeUnit.SECONDS.sleep(2);
    }

    private void review() throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("\n[안내] 고객님! 별점 등록을 진행합니다.\n");
        System.out.println("[안내] 주문자 이름은 무엇인가요?\n");
        String reviewerName = input.next();

        System.out.println("\n[안내] 음식점 상호는 무엇인가요?\n");
        String restaurantName = input.next();
        if (!deliveryErrorHandler.nonExistRestaurant(restaurantName)) {
            return;
        }
        Restaurant restaurant = restaurantRepository.getRestaurantByName(restaurantName).get();

        System.out.println("\n[안내] 주문하신 음식 이름은 무엇인가요?\n");
        String menuName = input.next();
        if (!deliveryErrorHandler.nonExistMenu(restaurant, menuName)) {
            return;
        }

        System.out.println("\n[안내] 음식맛은 어떠셨나요? (1점 ~ 5점)\n");
        int star = input.nextInt();
        if (!deliveryErrorHandler.illegalStar(star)) {
            return;
        }

        reviewRepository.add(new Review(reviewerName, restaurantName, menuName, star));
        System.out.println("\n[안내] 리뷰 등록이 완료되었습니다.\n");
        TimeUnit.SECONDS.sleep(2);
    }
}
