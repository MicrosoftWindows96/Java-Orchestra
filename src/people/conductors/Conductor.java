package people.conductors;

import music.Composition;
import music.MusicScore;
import orchestra.Orchestra;
import people.Person;
import people.musicians.Musician;
import utils.SoundSystem;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class Conductor extends Person {
    private final SoundSystem soundSystem;
    public ArrayList<Musician> band;
    public HashMap<Musician, MusicScore> bandScores;
    public Orchestra orchestra;

    public Conductor(String name, SoundSystem soundSystem) {
        super(name);
        this.soundSystem = soundSystem;
        this.band = new ArrayList<>();
    }

    public void registerMusician(Musician musician) {
        this.band.add(musician);
    }

    public void playComposition(Composition composition) {
        orchestra = new Orchestra();
        bandScores = new HashMap<>();

        for (Musician musician : band) {
            for (MusicScore musicScore : composition.getScores()) {
                if (musician.getInstrumentID() == musicScore.getInstrumentID()) {
                    this.orchestra.sitDown(musician);
                    bandScores.put(musician, musicScore);
                    musician.readScore(musicScore.getNotes(), musicScore.isSoft());
                }
            }
        }

        for (int i = 0; i < composition.getLength(); i++) {
            try {
                this.orchestra.playNextNote();
                sleep(composition.getNoteLength());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        soundSystem.init();
    }
}