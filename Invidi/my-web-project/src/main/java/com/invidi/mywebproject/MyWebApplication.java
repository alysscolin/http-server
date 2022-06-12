package com.invidi.mywebproject;

import com.invidi.mywebproject.controllers.MyController;
import com.invidi.simplewebserver.main.*;

import java.io.IOException;

public class MyWebApplication {

   public static void main(String[] args) throws IOException {
      final WebServer ws = new SimpleWebServer(8080);
      ws.getWebContext().setHandler("GET", "/api/data", new Handler() {
         @Override
         public void handle(Request request, Response response) throws IOException {
            String html = "http server, " + request.getParameter("name") + "";
            response.setResponseCode(200, "OK");
            response.addHeader("Content-Type", "text/html");
            response.addBody(html);
         }
      });

      ws.start(8080);
   }
}
