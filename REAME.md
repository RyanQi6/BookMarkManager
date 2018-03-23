# Bookmark Manager

### 1. Scenario

A user is trying to reorganize his browsers bookmarks. The user is currently using both `Safari`, `Chrome` and `Firefox` and over the time has collected thousands of bookmarks in each of them. We want to collect all bookmarks from 3 different browsers, de-duplicate them, group them, and then sort them by preference.

Sorting preference: (1) protocol: bookmark with "https" protocol precedes; (2) redirection: bookmark without HTTP/2 302 redirection has higher priority; (3) length: bookmark with shorter length precedes.

### 2. Assumptions

Bookmarks are stored in text files, each of which takes up one line.  No space in between.

The output which is the organized collection of the bookmarks is also stored in a text file.

### 3. Implementation 

##### (1) Read file and de-duplicate

Create a `HashMap<String, URL>` where the key is url of the bookmark and URL is its instance, and read the urls as `String` from each browser, iterating through to de-duplicate all bookmarks.

##### (2) Group the URL 

After de-duplication, put all bookmarks into `HashMap<String, PriorityQueue<URL>>` where the key is the host name of the **actual location** after redirection check and `URL` in the `PriorityQueue ` corresponds to **original** url.

##### (3) Comparator

(1) protocol: bookmark with "https" protocol precedes; (2) redirection: bookmark without HTTP/2 302 redirection has higher priority; (3) length: bookmark with shorter length precedes.

##### (4) Write file

Traverse the `HashMap` using `Map.Entry`, and poll each element from the top of the `PriorityQueue`.

