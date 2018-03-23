import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Url {

        public static void main(String[] args)
                throws MalformedURLException
        {
//            // creates a URL with string representation.
            URL url1 = new URL("https://mail.google.com/mail/u/0/#inbox");
            URL url2 = new URL("http://mail.google.com/mail/u/0/#inbox");
//
//            // creates a URL with a protocol,hostname,and path
//            URL url2 = new URL("https://news.google.com/news/");
//
//            URL url3 = new URL("https://www.google.com/news/");
//
//            // print the String representation of the URL.
            System.out.println(url1.getAuthority());
//            System.out.println(url2.toString());
//            System.out.println(url3.toString());
//            System.out.println();
//            //System.out.println("Different components of the URL3-");
//
//            // retrieve the protocol for the URL
//            System.out.println("Protocol:- " + url1.getProtocol());
//            System.out.println(url1.getProtocol().equals("https"));
//            // retrieve the hostname of the url
//            System.out.println("Hostname:- " + url1.getHost());
//
//            // retrieve the defalut port
//            System.out.println("Default port:- " +
//                    url1.getDefaultPort());
//
//            // retrieve the query part of URL
//            System.out.println("Query:- " + url1.getQuery());
//
//            // retrive the path of URL
//            System.out.println("Path:- " + url1.getPath());
//
//            // retrive the file name
//            System.out.println("File:- " + url1.getFile());
//
//            // retrieve the reference
//            System.out.println("Reference:- " + url1.getRef());
//            // retrieve the query part of URL

//            PriorityQueue<URL> pq = new PriorityQueue<>(11, new Comparator<URL>() {
//                @Override
//                public int compare(URL o1, URL o2) {
//                    // Priority1: protocol
//                    if(o1.getProtocol().equals("https") && o2.getProtocol().equals("http")){
//                        return -1;
//                    }
//                    if(o1.getProtocol().equals("http1") && o2.getProtocol().equals("https")){
//                        return 1;
//                    }
//                    // Priority2: actual location
//                    //if(o1.equals(ser))
//
//                    // Priority3: has path or file
//                    return o1.toString().length() < o2.toString().length() ? -1:1;
//                }
//            });
//            pq.add(url2);
//            pq.add(url1);
//
//            System.out.println(pq.poll().toString());
//            System.out.println(pq.poll().toString());
        }



}
