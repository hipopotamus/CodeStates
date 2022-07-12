package delivery;

import java.util.concurrent.TimeUnit;

public class DeliveryErrorHandler {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    public DeliveryErrorHandler(RestaurantRepository restaurantRepository, ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }

    public boolean restaurantNameDuplicate(String restaurantName) throws InterruptedException {
        boolean match = restaurantRepository.restaurantList.stream()
                .anyMatch(restaurant -> restaurant.getName().equals(restaurantName));
        if (match) {
            System.out.println("\n[경고] 같은 상호가 이미 존재합니다.\n");
            System.out.println("[안내] 시작화면으로 돌아갑니다.\n");
            TimeUnit.SECONDS.sleep(2);
            return false;
        }
        return true;
    }

    public boolean illegalMenuPrice(int price) throws InterruptedException {

        if (price < 0) {
            System.out.println("\n[경고] 잘못된 가격입니다.\n");
            System.out.println("[안내] 시작화면으로 돌아갑니다.\n");
            TimeUnit.SECONDS.sleep(2);
            return false;
        }
        return true;
    }

    public boolean nonExistRestaurant(String name) throws InterruptedException {
        if (restaurantRepository.getRestaurantByName(name).isEmpty()) {
            System.out.println("\n[경고] 입력된 상호가 존재하지 않습니다.\n");
            System.out.println("[안내] 시작화면으로 돌아갑니다.\n");
            TimeUnit.SECONDS.sleep(2);
            return false;
        }
        return true;
    }

    public boolean nonExistMenu(Restaurant restaurant, String menuName) throws InterruptedException {
        boolean match = restaurant.getMenuList().stream()
                .anyMatch(menu -> menu.getName().equals(menuName));
        if (!match) {
            System.out.println("\n[경고] 입력된 상호가 존재하지 않습니다.\n");
            System.out.println("[안내] 시작화면으로 돌아갑니다.\n");
            TimeUnit.SECONDS.sleep(2);
            return false;
        }
        return true;
    }

    public boolean illegalStar(int star) throws InterruptedException {
        if (star < 1 || star > 5) {
            System.out.println("\n[경고] 별점은 1점 ~ 5점 사이여야 합니다.\n");
            System.out.println("[안내] 시작화면으로 돌아갑니다.\n");
            TimeUnit.SECONDS.sleep(2);
            return false;
        }
        return true;
    }
}
