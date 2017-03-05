package display;

import room.Room;

public class Display {

    public static void printCurrentValues(Room room) {
        int visitors = room.getVisitors().size();
        int doctors = room.getDoctors().size();

        System.out.println("V: " + visitors + "\tD: " + doctors);
    }

    public static void printMaxValues(Room room) {
        System.out.println(room);
    }
}
