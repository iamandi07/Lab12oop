package Domain;

import java.util.Objects;

public class Hotel {

    private int id, personNumber, roomNumber, dayNumber;
    private double rating;
    private boolean isleftRoom = false;
    private String feedback;

    public Hotel(int id, int personNumber, int roomNumber, int dayNumber) {
        this.id = id;
        this.personNumber = personNumber;
        this.roomNumber = roomNumber;
        this.dayNumber = dayNumber;
    }

    public Hotel(int id, int personNumber, int roomNumber, int dayNumber, double rating, boolean isleftRoom, String feedback) {
        this.id = id;
        this.personNumber = personNumber;
        this.roomNumber = roomNumber;
        this.dayNumber = dayNumber;
        this.rating = rating;
        this.isleftRoom = isleftRoom;
        this.feedback = feedback;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isLeftRoom() {
        return isleftRoom;
    }

    public void setLeftRoom(boolean leftRoom) {
        this.isleftRoom = leftRoom;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", personNumber=" + personNumber +
                ", roomNumber=" + roomNumber +
                ", dayNumber=" + dayNumber +
                ", rating=" + rating +
                ", isleftRoom=" + isleftRoom +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
