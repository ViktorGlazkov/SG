package room;

import unit.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Room {
    private int maxDoctors;
    private int maxVisitors;

    private List<Unit> doctors;
    private List<Unit> visitors;

    public Room(int maxDoctors, int maxVisitors) {
        this.maxDoctors = maxDoctors;
        this.maxVisitors = maxVisitors;

        this.doctors = Collections.synchronizedList(new ArrayList<>());
        this.visitors = Collections.synchronizedList(new ArrayList<>());
    }

    public List<Unit> getDoctors() {
        return doctors;
    }

    public List<Unit> getVisitors() {
        return visitors;
    }

    public int getMaxDoctors() {
        return maxDoctors;
    }

    public int getMaxVisitors() {
        return maxVisitors;
    }

    @Override
    public String toString() {
        return  "maxVisitors=" + maxVisitors +
                ", maxDoctors=" + maxDoctors;
    }
}
