package com.example.javaservlet;

import java.io.*;
import java.util.Date;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie firstName = new Cookie("firstName", request.getParameter("firstName"));
        Cookie lastName = new Cookie("lastName", request.getParameter("lastName"));

        firstName.setMaxAge(24*60*60);
        lastName.setMaxAge(24*60*60);

        response.addCookie(firstName);
        response.addCookie(lastName);

        Cookie cookie = null;
        Cookie[] cookies = null;

        cookies = request.getCookies();


        HttpSession session = request.getSession(true);
        Date createdDate = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        String title = "Welcme Back";
        Integer visitCount = new Integer(0);
        String visitCountKey = new String("visitCount");
        String userIdKey = new String("userId");
        String userId = new String("52");

        if(session.isNew()){
            title = "Welcome to my website";
            session.setAttribute(userIdKey, userId);
        }else{
            visitCount = (Integer)session.getAttribute(visitCountKey);
            visitCount = visitCount + 1;
            userId = (String)session.getAttribute(userIdKey);
        }
        session.setAttribute(visitCountKey, visitCount);

        response.setContentType("text/html");
        String docType =
                "<!docType html public \"-//w3c//dtd html 4.0" +
                        "transitional//en\">\n";


        PrintWriter out = response.getWriter();
        out.println(docType +"<html>\n" +
                        "<head><title>" + title +"</title></head>\n" +
                        "<body> bgcolor= \"#f0f0f0\">\n");
        out.println("<h1 align = \"center\">" + title + "</h1>\n");
        out.println("<h2 align = \"center\">Session Information" + title + "</h2>\n");
        out.println("<table border=\"1\" align = \"center\">\n");
        out.println("<tr><td>id</td><td>"+session.getId()+"</td></tr>\n");
        out.println("<tr><td>creation date</td><td>"+createdDate+"</td></tr>\n");
        out.println("<tr><td>time of last access</td><td>"+lastAccessTime+"</td></tr>\n");
        out.println("</table\">\n");

        if(cookies != null){
            out.println("<h2> Found Cookies Name and Value</h2>");
            for (int i = 0; i < cookies.length; i++){
                cookie = cookies[i];
                out.println("Name :" + cookie.getName() + ",  ");
                out.println("Value :" + cookie.getName() + " <br/>  ");
            }
        }else{
            out.println("<h2> No Cookies Found</h2>");
        }

        //delete cookies

        if(cookies != null){
            out.println("<h2>Cookies Names and Values</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if((cookie.getName()).compareTo("firstName") == 0){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    out.println("Deleted cookie :" + cookie.getName() + " <br/>");
                }
                out.println("Name :" + cookie.getName() + ",  ");
                out.println("Value :" + cookie.getName() + " <br/>  ");
            }
        } else {
            out.println("<h2> No Cookies Found</h2>");
        }
        out.println("</body></html>");

    }

    public void destroy() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}