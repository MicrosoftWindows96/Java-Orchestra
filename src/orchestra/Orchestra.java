package orchestra;

import people.musicians.Musician;

import java.util.HashMap;

public class Orchestra {
    HashMap<Integer, Musician> seating;

    public Orchestra() {
        seating = new HashMap<>();
    }

    public Orchestra(Musician musician) {
    }

    public int sitDown(Musician musician) {
        if (seating.containsValue(musician)) return 2;
        else if (seating.size() == 15) return 1;
        else for (int i = 1; i < 16; i++)
                if (!seating.containsKey(i)) {
                    seating.put(i, musician);
                    musician.setSeat(i);
                    return 0;
                }
        return 0;
    }

    public void standUp(Musician musician) {
        seating.remove(musician.getSeat());
    }

    public void playNextNote() {
        seating.forEach((k, v) -> v.playNextNote());
    }

    public boolean isSeated(Musician musician) {
        return seating.containsValue(musician);
    }
}