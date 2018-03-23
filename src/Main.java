import BookmarkManager.*;

public class Main {

    public static void main(String[] args){
        String[] path = new String[3];
        path[0] = ".\\chrome.txt";
        path[1] = ".\\safari.txt";
        path[2] = ".\\firefox.txt";
        // read the file
        BookMarkCollector collector = new BookMarkCollector();
        FileIO fileIO = new FileIO();
        fileIO.readTxtFileIntoGroups(path, collector);

        // write the file
        fileIO.writeFiles("output.txt", collector);
    }
}
