import room.Room;
import room.RoomService;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(2, 4);
        RoomService.addUnits(100, room);
    }
}