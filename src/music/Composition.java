package music;

import people.musicians.Musician;

import java.util.List;

public interface Composition {
    String getName();

    void addScore(String instrumentName, List<String> notes, boolean soft);

    MusicScore[] getScores();

    int getLength();

    int getNoteLength();
}
