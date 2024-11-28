import music.Composition;
import music.MusicSheet;
import people.conductors.Conductor;
import people.musicians.Cellist;
import people.musicians.Musician;
import people.musicians.Pianist;
import people.musicians.Violinist;
import utils.SoundSystem;

import javax.sound.midi.MidiUnavailableException;
import java.io.*;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

public class EcsBandAid {
    private final ArrayList<Musician> band;
    private final ArrayList<Composition> compositions;

    private ArrayList<Composition> randomCompositions;
    private final SoundSystem soundSystem;
    private Random rand;
    private MusicSheet musicSheet;

    public EcsBandAid(SoundSystem soundSystem, ArrayList<Musician> band, ArrayList<Composition> compositions) {
        this.soundSystem = soundSystem;
        soundSystem.setTextMode(true);
        this.band = band;
        this.compositions = compositions;
    }

    public void performForAYear(ArrayList<Composition> parseCompositions) throws MidiUnavailableException {
        rand = new Random();
        randomCompositions = new ArrayList<>();
        Conductor conductor = new Conductor("Conductor", soundSystem);
        for (int i = 0; i < 3; i++) randomCompositions.add(parseCompositions.get(rand.nextInt(parseCompositions.size())));

        for (Musician musician : band) conductor.registerMusician(musician);

        for (Composition composition : randomCompositions) conductor.playComposition(composition);

        band.removeIf(musician -> rand.nextInt(2) == 1);
    }

    public void readMusiciansFile(String filePath) throws IOException {
        System.out.println("********************************************");
        System.out.println("Reading musicians file: " + filePath);
        System.out.println("********************************************");

        try {
            File file = new File(filePath);
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);

                if (line.toLowerCase().contains("(piano)")) {
                    System.out.println("Pianist detected");
                    band.add(new Pianist((line.substring(0, line.indexOf("("))), soundSystem));
                } else if (line.toLowerCase().contains("(violin)")) {
                    System.out.println("Violinist detected");
                    band.add(new Violinist((line.substring(0, line.indexOf("("))), soundSystem));
                } else if (line.toLowerCase().contains("(cello)")) {
                    System.out.println("Cellist detected");
                    band.add(new Cellist((line.substring(0, line.indexOf("("))), soundSystem));
                } else {
                    System.out.println("No match found");
                }
            }
            input.close();

            System.out.println("********************************************");
            System.out.println("Finished reading musicians file: " + filePath);
            System.out.println("********************************************");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void readCompositionsFile(String filePath) throws IOException {
        System.out.println("********************************************");
        System.out.println("Reading compositions file: " + filePath);
        System.out.println("********************************************");
        try {
            File file = new File(filePath);
            Scanner input = new Scanner(file);
            musicSheet = new MusicSheet("", "", 0);

            while (input.hasNextLine()) {
                String line = input.nextLine();

                if (line.contains("Name")) {
                    String name = line.substring(line.indexOf(":") + 1).trim();
                    System.out.println("Name: " + name);
                    musicSheet.setName(name);
                } else if (line.contains("Tempo")) {
                    String tempo = line.substring(line.indexOf(":") + 1).trim();
                    System.out.println("Tempo: " + tempo);
                    musicSheet.setTempo(tempo);
                } else if (line.contains("Length")) {
                    int length = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                    System.out.println("Length: " + length);
                    musicSheet.setLength(length);
                } else if (line.contains("Piano")) {
                    System.out.println("Piano composition detected");

                    boolean isSoft = line.contains("soft");
                    List<String> theseNotes = Arrays.stream(line.substring(line.indexOf("{") + 1, line.indexOf("}"))
                                    .trim()
                                    .split(","))
                            .map(String::trim)
                            .collect(Collectors.toList());

                    musicSheet.addScore("Piano", theseNotes, isSoft);
                    compositions.add(musicSheet);
                    System.out.println("Piano " + theseNotes);
                } else if (line.contains("Cello")) {
                    System.out.println("Cello composition detected");

                    boolean isSoft = line.contains("soft");
                    List<String> theseNotes = Arrays.stream(line.substring(line.indexOf("{") + 1, line.indexOf("}"))
                                    .trim()
                                    .split(","))
                            .map(String::trim)
                            .collect(Collectors.toList());

                    musicSheet.addScore("Cello", theseNotes, isSoft);
                    compositions.add(musicSheet);
                    System.out.println("Cello " + theseNotes);
                } else if (line.contains("Violin")) {
                    System.out.println("Violin composition detected");

                    boolean isSoft = line.contains("soft");
                    List<String> theseNotes = Arrays.stream(line.substring(line.indexOf("{") + 1, line.indexOf("}"))
                                    .trim()
                                    .split(","))
                            .map(String::trim)
                            .collect(Collectors.toList());

                    musicSheet.addScore("Violin", theseNotes, isSoft);
                    compositions.add(musicSheet);
                    System.out.println("Violin " + theseNotes);
                }
            }
            input.close();

            System.out.println("********************************************");
            System.out.println("Finished reading compositions file: " + filePath);
            System.out.println("********************************************");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Composition> getCompositions() {
        return compositions;
    }

    public ArrayList<Composition> getRandomCompositions() {
        return randomCompositions;
    }

    public static String resourcesPath(String fileName) throws URISyntaxException {
        return Objects.requireNonNull(EcsBandAid.class.getResource(fileName))
                .toURI()
                .getPath();
    }

    public void performForXYears(int years) throws MidiUnavailableException {
        for (int i = 0; i < years; i++) {
            performForAYear(compositions);
        }
    }

    public void parseArgs(String musiciansFileName, String compositionsFileName, int years) throws IOException, MidiUnavailableException {
        readMusiciansFile(musiciansFileName);
        readCompositionsFile(compositionsFileName);
        performForXYears(years);
    }

    public static void main(String[] args) throws IOException, MidiUnavailableException, URISyntaxException {
        EcsBandAid ecsBandAid = new EcsBandAid(new SoundSystem(), new ArrayList<>(), new ArrayList<>());

        if (args.length == 3) {
            String musiciansFileName = resourcesPath(args[0]);
            String compositionsFileName = resourcesPath(args[1]);
            int years = Integer.parseInt(args[2]);
            ecsBandAid.parseArgs(musiciansFileName, compositionsFileName, years);
        } else {
            System.out.println("Please provide the following terminal arguments: <musiciansFileName>.txt, <compositionsFileName>.txt, <numYearsToPerform>");
            System.out.println("As arguments were not provided in the required format, the program will resort to default values");
            ecsBandAid.readMusiciansFile(resourcesPath("musicians.txt"));
            ecsBandAid.readCompositionsFile(resourcesPath("compositions.txt"));
            ecsBandAid.performForAYear(ecsBandAid.getCompositions());
        }
    }
}