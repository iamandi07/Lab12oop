import Domain.HotelValidator;
import Repo.HotelRepo;
import Service.HotelService;
import UI.Console;

public class Main {

    public static void main(String[] args) {

        HotelValidator hotelValidator = new HotelValidator();
        HotelRepo hotelRepository = new HotelRepo(hotelValidator);
        HotelService hotelService = new HotelService(hotelRepository);
        Console console = new Console(hotelService);
        console.run();
    }
}
