import java.util.ArrayList;
import java.io.*;
import java.lang.Object;
import java.util.*;

// This is the main class that is run.

public class Team {






public void start() {
    GUI userInfo = new GUI();
}

public static void main(String[] args) {



  File folder = new File("./Map-Files");
  File[] listOfFiles = folder.listFiles();

  for (File x : listOfFiles) {
    System.out.println(x.getName());
  }



    Team main = new Team();
    main.start();
}
}
