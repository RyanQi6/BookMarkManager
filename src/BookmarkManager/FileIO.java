package BookmarkManager;

import java.io.*;
import java.util.*;
import java.net.URL;

public class FileIO {
    private HashMap<String, URL> deduplication = new HashMap<>();

    public void readTxtFileIntoGroups(String[] filePath, BookMarkCollector collector)
    {
        try
        {   for(int i=0; i<3; i++){
                File file = new File(filePath[i]);
                if (file.isFile() && file.exists())
                {
                    InputStreamReader read = new InputStreamReader(
                            new FileInputStream(file));
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = "";

                    while ((lineTxt = bufferedReader.readLine()) != null){

                        if(!deduplication.containsKey(lineTxt)){
                            URL current = new URL(lineTxt);
                            deduplication.put(lineTxt,current);
                        }
                    }
                    bufferedReader.close();
                    read.close();
                }
                else
                {
                    System.out.println("File Not Found");
                }
            }
            for(Map.Entry<String, URL> entry: deduplication.entrySet()){
                collector.BookMarkCollector(entry.getValue());
            }
        }
        catch (Exception e)
        {
            System.out.println("Something is Wrong here");
            e.printStackTrace();
        }

        return;
    }
    public void writeFiles(String filePath, BookMarkCollector collector)
    {
        String fileName = filePath;
        try
        {
            BufferedWriter out=new BufferedWriter(new FileWriter(fileName));
            int index = 0;
            for(Map.Entry<String, PriorityQueue<Pair>> entry : collector.bookmarkGroups.entrySet()){
                out.write("----------Group "+ Integer.toString(index++)+ " : " + entry.getKey() + " -------------- ");
                out.newLine();
                PriorityQueue<Pair> pq = entry.getValue();
                while(!pq.isEmpty()){
                    out.write(pq.poll().serverUrl.toString());
                    out.newLine();
                }
            }
            out.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

