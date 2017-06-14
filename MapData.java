import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MapData {

java.util.HashMap<String,BuildingStructure> buildings = new HashMap<String,BuildingStructure>();
java.util.List<String[]> settings = Collections.synchronizedList(new ArrayList<String[]>());
String mapName;

// Constructor that takes in the name of the file to read and reads the file.
public MapData(String mapName) {
  this.mapName = mapName;
  readFile();
}


public void readFile() {
    java.util.List<String> cb = Collections.synchronizedList(new ArrayList<String>());
    boolean readingSettings = false;
    String line;

    try {
        FileReader reader = new FileReader("./Map-Files/" + mapName);
        BufferedReader bufferedReader = new BufferedReader(reader);

        // Will read every line until the end of the file is reached
        while ((line = bufferedReader.readLine()) != null) {

            // Blank lines and comments will be skipped.
            if ( line.startsWith("//") || (line.equals("")) ) {
                continue;
            }

            // Once all the builings have been read in, it start adding settings and icon locations.
            if (line.equals("END_OF_All_BUILDINGS")) {
              readingSettings = true;
              continue;
            }
            if (readingSettings) {
                String[] currentLine = line.split(" ");
                settings.add(currentLine);
            }

            // Creates all of the building objects.
            if (line.equals("END_OF_BUILDING")) {
                String name = cb.get(0);
                buildings.put(name, new BuildingStructure(cb.get(0),cb.get(1),cb.get(2),cb.get(3),cb.get(4),cb.get(5),cb.get(6)) );
                cb.clear();
            } else {
                cb.add(line);
            }

        }

        reader.close();

    } catch (IOException e) {
        e.printStackTrace();
    }


}

}
