package delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantRepository {
    private static final RestaurantRepository restaurantRepository = new RestaurantRepository();

    public List<Restaurant> restaurantList = new ArrayList<>();

    public static RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }

    public void add(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }

    public Optional<Restaurant> getRestaurantByName(String restaurantName) {
        return restaurantList.stream()
                .filter(restaurant -> restaurant.getName().equals(restaurantName))
                .findFirst();
    }
}
