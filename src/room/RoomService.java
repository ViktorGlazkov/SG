package room;

import display.Display;
import unit.Unit;
import unit.Doctor;
import unit.Visitor;

import java.util.List;
import java.util.Random;

import static utils.Const.*;

public class RoomService {

    public static void addUnits(int unitAmount, Room room) {
        Random random = new Random();

        Display.printMaxValues(room);
        for (int i = 0; i < unitAmount; i++) {

            addUnits(room);

            try {
                Thread.sleep(random.nextInt(HUNDRED));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addUnits(Room room) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    addUnit(room);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void addUnit(Room room) throws InterruptedException {
        Random random = new Random();
        int val = random.nextInt(FIVE) + ONE;

        if (val == 1) {
            while (isaBusy(room.getMaxDoctors(), room.getVisitors(), room.getDoctors())) {
            }
            addUnit(new Doctor(), room.getDoctors(), room);

        } else {
            while (isaBusy(room.getMaxVisitors(), room.getDoctors(), room.getVisitors())) {
            }
            addUnit(new Visitor(), room.getVisitors(), room);
        }
    }

    private static boolean isaBusy(int max, List<Unit> listA, List<Unit> listB) {
        return listA.size() > ZERO || listB.size() >= max;
    }

    private static void addUnit(Unit unit, List<Unit> units, Room room) throws InterruptedException {
        synchronized (room) {
            units.add(unit);
        }
        Display.printCurrentValues(room);
        Thread.sleep(unit.getLifetime());
        units.remove(unit);
    }
}
