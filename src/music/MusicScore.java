package music;

import people.musicians.Cellist;
import people.musicians.Pianist;
import people.musicians.Violinist;

import java.util.ArrayList;
import java.util.List;

public class MusicScore {
    public final String instrumentName;
    public final int[] notes;
    public boolean soft;
    List<String> notesList;

    public MusicScore(String instrumentName, int[] notes, boolean soft) {
        this.instrumentName = instrumentName;
        this.notes = notes;
        this.soft = soft;
    }

    public int getInstrumentID() {
        return switch (instrumentName) {
            case "Piano" -> Pianist.instrumentID;
            case "Violin" -> Violinist.instrumentID;
            case "Cello" -> Cellist.instrumentID;
            default -> 0;
        };
    }

    public int[] getNotes() {
        return this.notes;
    }

    public List<String> getNotesList(int[] notes) {
        notesList = new ArrayList<>();
        for (int note : notes) {
            switch (note) {
                case 48 -> notesList.add("C3");
                case 49 -> notesList.add("C#3");
                case 50 -> notesList.add("D3");
                case 51 -> notesList.add("D#3");
                case 52 -> notesList.add("E3");
                case 53 -> notesList.add("F3");
                case 54 -> notesList.add("F#3");
                case 55 -> notesList.add("G3");
                case 56 -> notesList.add("G#3");
                case 57 -> notesList.add("A3");
                case 58 -> notesList.add("A#3");
                case 59 -> notesList.add("B3");
                case 60 -> notesList.add("C4");
                case 61 -> notesList.add("C#4");
                case 62 -> notesList.add("D4");
                case 63 -> notesList.add("D#4");
                case 64 -> notesList.add("E4");
                case 65 -> notesList.add("F4");
                case 66 -> notesList.add("F#4");
                case 67 -> notesList.add("G4");
                case 68 -> notesList.add("G#4");
                case 69 -> notesList.add("A4");
                case 70 -> notesList.add("A#4");
                case 71 -> notesList.add("B4");
                case 72 -> notesList.add("C5");
                case 73 -> notesList.add("C#5");
                case 74 -> notesList.add("D5");
                case 75 -> notesList.add("D#5");
                case 76 -> notesList.add("E5");
                case 77 -> notesList.add("F5");
                case 78 -> notesList.add("F#5");
                case 79 -> notesList.add("G5");
                case 80 -> notesList.add("G#5");
                case 81 -> notesList.add("A5");
                case 82 -> notesList.add("A#5");
                case 83 -> notesList.add("B5");
                case 84 -> notesList.add("C6");
                default -> notesList.add("0");
            }
        }
        return notesList;
    }
    
    public boolean isSoft() {
        return this.soft;
    }
}
