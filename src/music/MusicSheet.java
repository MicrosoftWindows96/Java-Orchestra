package music;

import orchestra.Orchestra;
import people.musicians.Musician;

import java.util.ArrayList;
import java.util.List;

public class MusicSheet implements Composition {
    private String name;
    private String tempo;
    public boolean soft;
    private int length;
    public ArrayList<MusicScore> scores;
    public int[] notesInteger = new int[length];

    public MusicSheet(String name, String tempo, int length) {
        this.name = name;
        this.tempo = tempo;
        this.length = length;
        this.scores = new ArrayList<>();
    }

    public int[] getNotesInteger(List<String> notes) {
        int[] notesInteger = new int[notes.size()];
        for (int i = 0; i < notes.size(); i++) {
            switch (notes.get(i)) {
                case "A0":
                    notesInteger[i] = 21;
                    continue;
                case "A#0":
                    notesInteger[i] = 22;
                    continue;
                case "B0":
                    notesInteger[i] = 23;
                    continue;
                case "C1":
                    notesInteger[i] = 24;
                    continue;
                case "C#1":
                    notesInteger[i] = 25;
                    continue;
                case "D1":
                    notesInteger[i] = 26;
                    continue;
                case "D#1":
                    notesInteger[i] = 27;
                    continue;
                case "E1":
                    notesInteger[i] = 28;
                    continue;
                case "F1":
                    notesInteger[i] = 29;
                    continue;
                case "F#1":
                    notesInteger[i] = 30;
                    continue;
                case "G1":
                    notesInteger[i] = 31;
                    continue;
                case "G#1":
                    notesInteger[i] = 32;
                    continue;
                case "A1":
                    notesInteger[i] = 33;
                    continue;
                case "A#1":
                    notesInteger[i] = 34;
                    continue;
                case "B1":
                    notesInteger[i] = 35;
                    continue;
                case "C2":
                    notesInteger[i] = 36;
                    continue;
                case "C#2":
                    notesInteger[i] = 37;
                    continue;
                case "D2":
                    notesInteger[i] = 38;
                    continue;
                case "D#2":
                    notesInteger[i] = 39;
                    continue;
                case "E2":
                    notesInteger[i] = 40;
                    continue;
                case "F2":
                    notesInteger[i] = 41;
                    continue;
                case "F#2":
                    notesInteger[i] = 42;
                    continue;
                case "G2":
                    notesInteger[i] = 43;
                    continue;
                case "G#2":
                    notesInteger[i] = 44;
                    continue;
                case "A2":
                    notesInteger[i] = 45;
                    continue;
                case "A#2":
                    notesInteger[i] = 46;
                    continue;
                case "B2":
                    notesInteger[i] = 47;
                    continue;
                case "C3":
                    notesInteger[i] = 48;
                    continue;
                case "C#3":
                    notesInteger[i] = 49;
                    continue;
                case "D3":
                    notesInteger[i] = 50;
                    continue;
                case "D#3":
                    notesInteger[i] = 51;
                    continue;
                case "E3":
                    notesInteger[i] = 52;
                    continue;
                case "F3":
                    notesInteger[i] = 53;
                    continue;
                case "F#3":
                    notesInteger[i] = 54;
                    continue;
                case "G3":
                    notesInteger[i] = 55;
                    continue;
                case "G#3":
                    notesInteger[i] = 56;
                    continue;
                case "A3":
                    notesInteger[i] = 57;
                    continue;
                case "A#3":
                    notesInteger[i] = 58;
                    continue;
                case "B3":
                    notesInteger[i] = 59;
                    continue;
                case "C4":
                    notesInteger[i] = 60;
                    continue;
                case "C#4":
                    notesInteger[i] = 61;
                    continue;
                case "D4":
                    notesInteger[i] = 62;
                    continue;
                case "D#4":
                    notesInteger[i] = 63;
                    continue;
                case "E4":
                    notesInteger[i] = 64;
                    continue;
                case "F4":
                    notesInteger[i] = 65;
                    continue;
                case "F#4":
                    notesInteger[i] = 66;
                    continue;
                case "G4":
                    notesInteger[i] = 67;
                    continue;
                case "G#4":
                    notesInteger[i] = 68;
                    continue;
                case "A4":
                    notesInteger[i] = 69;
                    continue;
                case "A#4":
                    notesInteger[i] = 70;
                    continue;
                case "B4":
                    notesInteger[i] = 71;
                    continue;
                case "C5":
                    notesInteger[i] = 72;
                    continue;
                case "C#5":
                    notesInteger[i] = 73;
                    continue;
                case "D5":
                    notesInteger[i] = 74;
                    continue;
                case "D#5":
                    notesInteger[i] = 75;
                    continue;
                case "E5":
                    notesInteger[i] = 76;
                    continue;
                case "F5":
                    notesInteger[i] = 77;
                    continue;
                case "F#5":
                    notesInteger[i] = 78;
                    continue;
                case "G5":
                    notesInteger[i] = 79;
                    continue;
                case "G#5":
                    notesInteger[i] = 80;
                    continue;
                case "A5":
                    notesInteger[i] = 81;
                    continue;
                case "A#5":
                    notesInteger[i] = 82;
                    continue;
                case "B5":
                    notesInteger[i] = 83;
                    continue;
                case "C6":
                    notesInteger[i] = 84;
                    continue;
                case "C#6":
                    notesInteger[i] = 85;
                    continue;
                case "D6":
                    notesInteger[i] = 86;
                    continue;
                case "D#6":
                    notesInteger[i] = 87;
                    continue;
                case "E6":
                    notesInteger[i] = 88;
                    continue;
                case "F6":
                    notesInteger[i] = 89;
                    continue;
                case "F#6":
                    notesInteger[i] = 90;
                    continue;
                case "G6":
                    notesInteger[i] = 91;
                    continue;
                case "G#6":
                    notesInteger[i] = 92;
                    continue;
                case "A6":
                    notesInteger[i] = 93;
                    continue;
                case "A#6":
                    notesInteger[i] = 94;
                    continue;
                case "B6":
                    notesInteger[i] = 95;
                    continue;
                case "C7":
                    notesInteger[i] = 96;
                    continue;
                case "C#7":
                    notesInteger[i] = 97;
                    continue;
                case "D7":
                    notesInteger[i] = 98;
                    continue;
                case "D#7":
                    notesInteger[i] = 99;
                    continue;
                case "E7":
                    notesInteger[i] = 100;
                    continue;
                case "F7":
                    notesInteger[i] = 101;
                    continue;
                case "F#7":
                    notesInteger[i] = 102;
                    continue;
                case "G7":
                    notesInteger[i] = 103;
                    continue;
                case "G#7":
                    notesInteger[i] = 104;
                    continue;
                case "A7":
                    notesInteger[i] = 105;
                    continue;
                case "A#7":
                    notesInteger[i] = 106;
                    continue;
                case "B7":
                    notesInteger[i] = 107;
                    continue;
                case "C8":
                    notesInteger[i] = 108;
                    continue;
                default:
                    notesInteger[i] = 0;
                    continue;
            }
        }
        return notesInteger;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addScore(String instrumentName, List<String> notes, boolean soft) {
        MusicScore score = new MusicScore(instrumentName, this.getNotesInteger(notes), soft);
        scores.add(score);
    }

    @Override
    public MusicScore[] getScores() {
        return scores.toArray(new MusicScore[0]);
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getNoteLength() {
        return switch (tempo) {
            case "Larghissimo" -> 1500;
            case "Lento" -> 1000;
            case "Andante" -> 500;
            case "Moderato" -> 300;
            case "Allegro" -> 175;
            case "Presto" -> 150;
            default -> 0;
        };
    }

    public int[] getNotes() {
        return this.notesInteger;
    }

    public boolean isSoft() {
        return this.soft;
    }

    public void setTempo(String thisTempo) {
        this.tempo = thisTempo;
    }

    public String getTempo() {
        return tempo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
