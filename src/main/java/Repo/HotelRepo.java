package Repo;

import Domain.Hotel;
import Domain.HotelValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class HotelRepo {

    private Map<Integer, Hotel> hotels = new HashMap<>();
    private HotelValidator validator;

    public HotelRepo(HotelValidator validator) {
        this.validator = validator;
        }

    public void add(Hotel hotel) {
        if (hotels.containsKey(hotel.getId())) {
            throw new RuntimeException("The reg number with that ID already exists!");
            }

        validator.validate(hotel);
        hotel.isLeftRoom();
        hotels.put(hotel.getId(), hotel);
        }

    public void update(Hotel hotel) {

        if (hotels.containsKey(hotel.getRoomNumber())) {
            throw new RuntimeException("There is no reg number with the given ID!");
        }

        validator.validate(hotel);
        hotels.put(hotel.getRoomNumber(), hotel);
        }

        public List<Hotel> getAll() {
            return new ArrayList<>(hotels.values());
        }
}
