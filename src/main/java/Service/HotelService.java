package Service;

import Domain.Hotel;
import Domain.RoomReportView;
import Repo.HotelRepo;

import java.util.*;

public class HotelService {

    private HotelRepo repository;

    public HotelService(HotelRepo repository) {
        this.repository = repository;
    }

    public void enterHotel(int id, int personNumber, int roomNumber, int dayNumber) {

        Hotel hotel = new Hotel (id, personNumber, roomNumber, dayNumber);
        List<Hotel> rooms = repository.getAll();
        for (Hotel c : rooms) {
            if (c.getRoomNumber() == roomNumber && !c.isLeftRoom()) {
                throw new RuntimeException("That room is already taken by another guess!");
            }
        }
        repository.add(hotel);
    }

    public void leaveRoom(int roomNumber, String feedback, double rating) {

        List<Hotel> hotels = repository.getAll();
        boolean flag = false;

        for (Hotel c : hotels) {
            if (c.getRoomNumber() == roomNumber && !c.isLeftRoom()) {
                flag = true;
                c.setFeedback(feedback);
                c.setRating(rating);
                c.setLeftRoom(false);
                return;
            }
        }
        if (flag == true) {
            //do nothing
        } else {
            throw new RuntimeException("The room was not booked");
        }
    }

    public List<Hotel> getAll(){
        return repository.getAll();
    }

    public List<RoomReportView> getRoomsReport() {

        List<RoomReportView> results = new ArrayList<>();
        HashMap<Integer, List<Double>> roomRatings = new HashMap<>();
        for (Hotel c : repository.getAll()) {
            if (!c.isLeftRoom()) {
            int room = c.getRoomNumber();
            double rating = c.getRating();

            if (!roomRatings.containsKey(room)) {
                roomRatings.put(room, new ArrayList<>());
            }

            roomRatings.get(room).add(rating);

            }
        }

        for (int no : roomRatings.keySet()) {
            List<Double> ratings = roomRatings.get(no);
            int average = 0;
            for (double r : ratings) {
                average += r;
            }
            average /= ratings.size();
            results.add(new RoomReportView(no, average));
        }

        results.sort((r1, r2) -> {
            if (r1.getRatingAverage() > r2.getRatingAverage())
                return -1;
            else if (r1.getRatingAverage() == r2.getRatingAverage())
                return 0;
            else
                return 1;
        });

        return results;
    }

}

