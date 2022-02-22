package httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Example Class for building HttpClient example
 * */
public class WebsiteChecker implements Runnable {
 String url;
 public WebsiteChecker(String url)
 {
   this.url=url;
 }
  public static void main(String[] args) {
      List<String> websites=asList("http://facebook.com","http://google.com","http://stackoverflow.com","http://facebookblahblah.com");
      for(String url:websites)
      {
          Thread t=new Thread(new WebsiteChecker(url));
          t.start();
      }
      //************ @ second approach of making it dynamic to accept all websites  ***********
    /*Thread t1= new Thread(new WebsiteChecker("http://facebook.com"),"httpResponseThread");
    t1.start();
    Thread t2= new Thread(new WebsiteChecker("http://google.com"),"httpResponseThread");

    t2.start();
    Thread t3= new Thread(new WebsiteChecker("http://stackoverflow.com"),"httpResponseThread");
    t3.start();
      Thread t4= new Thread(new WebsiteChecker("http://facebookblahblah.com"),"httpResponseThread");
      t4.start();*/

  }
  public void run() {
      HttpClient client = HttpClient.newHttpClient();
      try{
        HttpRequest request=(HttpRequest.newBuilder(new URI(url)).GET().build()); // It can also be POST() for data to be taken to form ,build is used to make request through bulder,as it returns a http request
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // Response we are getting will be of String type
      System.out.println(url + " Website is Up"+ response);
      }
     catch (URISyntaxException |IOException |InterruptedException ex) {
      System.out.println(url+" Website is down");
    }
  }
}



    //System.out.println("Response :"+ response); //301 : shows that it is being moved permanently, (Now traffic goes to https://google.com )it has moved the request to https from http


