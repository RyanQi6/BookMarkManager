package BookmarkManager;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class BookMarkCollector {
    class MyComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair o1, Pair o2) {
        // Priority1: protocol
            if(o1.serverUrl.getProtocol().equals("https") && o2.serverUrl.getProtocol().equals("http")){
                return -1;
            }
            if(o1.serverUrl.getProtocol().equals("http") && o2.serverUrl.getProtocol().equals("https")){
                return 1;
            }
           //  Priority2: actual location
            if(o1.serverUrl.getHost().equals(o1.actualLocation.getHost()) && !o2.serverUrl.getHost().equals(o2.actualLocation.getHost())){
                return -1;
            }
            if(!o1.serverUrl.getHost().equals(o1.actualLocation.getHost()) && o2.serverUrl.getHost().equals(o2.actualLocation.getHost())){
                return 1;
            }
            // Priority3: has path or file
            return o1.serverUrl.toString().length() < o2.serverUrl.toString().length() ? -1:1;
        }
    }
    public HashMap<String, PriorityQueue<Pair>> bookmarkGroups = new HashMap<>();

    public void BookMarkCollector(URL serverUrl){
        //1.check the 302 redirection
        Pair pair = new Pair();
        try {
            pair.serverUrl = serverUrl;
            pair.actualLocation = serverUrl;     // use host names of actual location as keys, and use original urls as values
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setInstanceFollowRedirects(false);
            conn.connect();

            //Judge if there is 302 redirection
            if (conn.getResponseCode() == 302) {
                // if redirected, get the correct location
                String location = conn.getHeaderField("Location");
                pair.actualLocation = new URL(location);
//                pair.redirected = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2. organize the bookmarks in terms of hostname
        if(pair.actualLocation.getPath().equals("/ServiceLogin")){
            pair.actualLocation = pair.serverUrl;
        }
        if (bookmarkGroups.containsKey(pair.actualLocation.getHost())){
            bookmarkGroups.get(pair.actualLocation.getHost()).add(pair);
        }
        else{
            PriorityQueue<Pair> pq = new PriorityQueue<>(new MyComparator());
            pq.add(pair);
            bookmarkGroups.put(pair.actualLocation.getHost(),pq);
        }
    }
}
