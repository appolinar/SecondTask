# Project Title

Android Coding Assignment.  

### Description
App which displays a list of posts coming from a JSON feed.  
App loads posts from JSON URL and displays all the results in a list. The list contains 2 different row types - VIDEO and LINK  
VIDEO rows contain button PLAY which open a media player to play the item.  
LINK rows(fully clickable) display new screen that loads a WebView with the given link.  
Sorted by title  
For launching app on real device necessary install apk file on device and start it via launch icon.  
Screen rotation does not support. As extra option - possible to fix orientation "only vertical"  
Filtering - according the task on the top of the list located search box area that filters the posts according to the input text  
Posts filtered according to the Title  
Filtering executes dynamically with every character that is input by user  

### Installing

Clone this repository and import into **Android Studio**
```bash
git clone https://github.com/appolinar/SecondTask.git
```

## Generating APK
From Android Studio:  
1. ***Build*** menu  
2. ***Generate APK...***  


## Built With

* Retrofit - REST-client
* Gradle - Dependency Management
* RecyclerView - Container for rendering larger data set of views
* Glide - Image loading library for android


## Author

* **Pushkarev Andrey**


