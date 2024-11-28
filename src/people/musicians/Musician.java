package people.musicians;

public interface Musician {
    void setSeat(int seat);
    void readScore(int[] notes, boolean soft);
    void playNextNote();
    int getSeat();
    int getInstrumentID();
}
