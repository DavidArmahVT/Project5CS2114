import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Chase Conover
 * @author David Armah
 *
 */
public class Input {

    public Input() {

    }


    public static void main(String[] args) throws FileNotFoundException {
        SinglyLinkedList<Student> studentList;
        SongList songList;

        if (args.length == 2) {
            studentList = scanStudents(args[0]);
            songList = scanSongs(args[1]);
        }
        else {
            studentList = scanStudents("MusicSurveyData2019F.csv");
            songList = scanSongs("SongList2019F.csv");
        }

    }


    public static SongList scanSongs(String file) throws FileNotFoundException {
        // the output for the song list
        SongList output = new SongList();
        // the scanner to parse the file
        Scanner scanner = new Scanner(new File(file));
        // initializes ID at 0
        int index = 0;
        while (scanner.hasNextLine()) {
            // creates the scanner to parse through each line
            Scanner scanner2 = new Scanner(scanner.nextLine());
            // uses commas to parse through each line
            scanner2.useDelimiter(",");
            String title = scanner2.next();
            String artist = scanner2.next();
            String year = scanner2.next();
            String genre = scanner2.next();
            Song addition = new Song(title, artist, year, genre);
            output.add(index, addition);
            scanner2.close();
            index++;
        }

        scanner.close();
        return output;

    }


    public static SinglyLinkedList<Student> scanStudents(String file) throws FileNotFoundException {
        SinglyLinkedList<Student> output = new SinglyLinkedList<>();
        Scanner scanner = new Scanner(new File(file));
        
        while (scanner.hasNextLine()) {
            Scanner scanner2 = new Scanner(scanner.nextLine());
            scanner2.useDelimiter(",");
            String studentID = scanner2.next();
            String dateAndTime = scanner2.next();
            SinglyLinkedList<String[]> responses = new SinglyLinkedList<>();

            // gets major
            String majorString = scanner2.next();
            MajorEnums major = null;
            if (majorString.equalsIgnoreCase("Computer Science")) {
                major = MajorEnums.CS;
            }
            else if (majorString.equalsIgnoreCase("Other Engineering")) {
                major = MajorEnums.ENG;
            }
            else if (majorString.equalsIgnoreCase("Math or CMDA")) {
                major = MajorEnums.MATHORCMDA;
            }
            else if (majorString.equalsIgnoreCase("Other")) {
                major = MajorEnums.OTHER;
            }

            // gets region
            String regionString = scanner2.next().toUpperCase();
            RegionEnums region = null;
            if (regionString.equalsIgnoreCase("Northeast US")) {
                region = RegionEnums.NE;
            }
            else if (majorString.equalsIgnoreCase("Southeast US")) {
                region = RegionEnums.SE;
            }
            else if (majorString.equalsIgnoreCase("the rest of US")) {
                region = RegionEnums.OTHER;
            }
            else if (majorString.equalsIgnoreCase("outside the US")) {
                region = RegionEnums.OUTSIDE;
            }

            // gets hobby
            String hobbyString = scanner2.next().toUpperCase();
            HobbyEnums hobby = null;
            if (hobbyString.equalsIgnoreCase("read")) {
                hobby = HobbyEnums.READ;
            }
            else if (hobbyString.equalsIgnoreCase("art")) {
                hobby = HobbyEnums.ART;
            }
            else if (hobbyString.equalsIgnoreCase("sports")) {
                hobby = HobbyEnums.SPORTS;
            }
            else if (hobbyString.equalsIgnoreCase("music")) {
                hobby = HobbyEnums.MUSIC;
            }

            // gets the students liked values
            while (scanner2.hasNext()) {
                String heard = scanner2.next();
                String liked = "";
                if (scanner2.hasNext()) {
                    liked = scanner2.next();
                }
                String[] response = { heard, liked };
                responses.add(response);
            }
            scanner2.close();

            if (major != null && region != null && hobby != null) {
                Student addition = new Student(studentID, dateAndTime, major,
                    region, hobby, responses);
                output.add(addition);
            }
        }
        scanner.close();
        return output;

    }
}
