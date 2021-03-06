package com.github.kurkov.springlibrary.servlets;

import com.github.kurkov.springlibrary.objects.LibraryFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author Aleksey Kurkov. Created on 21.08.2016
 */
@WebServlet(name = "PdfContent", urlPatterns = {"/PdfContent"})
public class PdfContent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf; charset=UTF-8");
        OutputStream out = response.getOutputStream();
        try {
            long id = Long.valueOf(request.getParameter("id"));
            Boolean save = Boolean.valueOf(request.getParameter("save"));

            LibraryFacade libraryFacade = (LibraryFacade) getServletContext().getAttribute("libraryFacade");

            byte[] content = libraryFacade.getContent(id);
            response.setContentLength(content.length);
            if (save) {
                String filename = request.getParameter("filename");
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8") + ".pdf");
            }
            out.write(content);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            out.close();
        }
    }
}