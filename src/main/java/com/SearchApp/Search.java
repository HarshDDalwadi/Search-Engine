package com.SearchApp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Search")

public class Search extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String keyword = request.getParameter("keyword");
        Connection connection = DatabaseConnection.getConnection();
        try{
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT pageTitle, pageLink, (LENGTH(LOWER(pageText)) - LENGTH(REPLACE(LOWER(pageText),'"+keyword.toLowerCase()+"', '')))/LENGTH('"+keyword.toLowerCase()+"')  AS COUNT FROM pages ORDER BY COUNT DESC LIMIT 30");
            ArrayList<SearchResult> results = new ArrayList<SearchResult>();
            while(resultSet.next()){
                SearchResult result = new SearchResult();
                result.setTitle(resultSet.getString("pageTitle"));
                result.setLink(resultSet.getString("pageLink"));
                results.add(result);
            }

            for(SearchResult result : results){
                System.out.println(result.getTitle() + "\t" + result.getLink());
            }

            request.setAttribute("results", results);
            request.getRequestDispatcher("search.jsp").forward(request, response);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }
}