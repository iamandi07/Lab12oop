package UI;

import Domain.Hotel;
import Domain.RoomReportView;
import Service.HotelService;

import java.util.Scanner;

public class Console {

    private HotelService service;
    private Scanner scanner;

    public Console(HotelService service) {
        this.service = service;
        scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Add guests to the hotel.");
        System.out.println("2. Remove guests from hotel.");
        System.out.println("3. Show rooms feedback.");
        System.out.println("a. Show every room.");
        System.out.println("x. exit");
        System.out.print("Your option: ");
    }

    public void run() {

        while (true) {
            showMenu();

            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleEntry();
            } else if (option.equals("2")) {
                handleExit();
            } else if (option.equals("3")) {
                handleReport();
            } else if (option.equals("a")) {
                handleShowAll();
            } else if (option.equals("x")){
                break;
            }
        }
    }

    private void handleEntry() {
        System.out.println("Entry id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Room number: ");
        int roomNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Person number: ");
        int personNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of days: ");
        int dayNumber = Integer.parseInt(scanner.nextLine());

        try {
            service.enterHotel(id, personNumber, roomNumber, dayNumber);
            System.out.println("Guests entered in Hotel successfully!");
        } catch (RuntimeException rex) {
            System.out.println("We have errors:");
            System.out.println(rex.getMessage());
        }
    }

    private void handleExit() {
        try {
            System.out.println("Room number: ");
            int roomNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Feedback: ");
            String feedback = scanner.nextLine();
            System.out.println("Rating: ");
            double rating = Double.parseDouble(scanner.nextLine());

            service.leaveRoom(roomNumber, feedback, rating);
            System.out.println("Guest left hotel successfully!");
        } catch (RuntimeException rex) {
            System.out.println("We have errors:");
            System.out.println(rex.getMessage());
            
        }
    }

    private void handleReport() {

        for (RoomReportView roomReport : service.getRoomsReport()) {
            System.out.println(String.format("%d %f", roomReport.getRoomNumber(), roomReport.getRatingAverage()));
        }
    }

    private void handleShowAll(){
        for (Hotel c: service.getAll())
            System.out.println(c);
    }
}
