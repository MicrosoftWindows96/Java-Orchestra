package people.musicians;

// Imports (Packages & Classes)
import people.Person;
import utils.SoundSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cellist extends Person implements Musician {
    public static int instrumentID = 43;
    private int loudness;
    private int seat;
    public List<Integer> notesToRead;
    public Iterator<Integer> nextNote;
    private final SoundSystem soundSystem;

    public Cellist(String name, SoundSystem soundSystem) {
        super(name);
        this.soundSystem = soundSystem;
    }

    public Cellist(String name, SoundSystem soundSystem, int seat) {
        super(name);
        this.soundSystem = soundSystem;
        this.seat = seat;
    }

    @Override
    public void setSeat(int seat) {
        if (seat >= 0 && seat <= 15) this.seat = seat;
        else throw new IllegalArgumentException("Seat number must be an integer between 0 and 15");
        soundSystem.setInstrument(seat, instrumentID);
    }

    @Override
    public void readScore(int[] notes, boolean soft) {
        notesToRead = new ArrayList<>();
        for (int i : notes) notesToRead.add(i);
        this.loudness = soft ? 50 : 100;
        this.nextNote = notesToRead.iterator();
    }

    @Override
    public void playNextNote() {
        if (nextNote.hasNext()) {
            int note = nextNote.next();
            soundSystem.playNote(seat, note, loudness);
        }
    }

    @Override
    public int getSeat() {
        return this.seat;
    }

    @Override
    public int getInstrumentID() {
        return instrumentID;
    }
}
