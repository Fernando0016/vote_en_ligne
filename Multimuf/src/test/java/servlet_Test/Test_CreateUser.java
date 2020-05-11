/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_Test;

import servlet.CreateUser;
import org.junit.Test;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import static org.mockito.Mockito.*;

/**
 *
 * @author Antoine
 */
public class Test_CreateUser {

    @Test
    public void test_create_empty_args() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("email")).thenReturn("");
        when(request.getParameter("password")).thenReturn("");
        when(request.getParameter("pseudo")).thenReturn("");
        when(request.getParameter("confirmation")).thenReturn("");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        new CreateUser().test_post(request, response);
        verify(request).setAttribute("info", "vous devez remplir tous les champs");
    }

    @Test
    public void test_create_empty_pseudo() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("email")).thenReturn("email@ema.il");
        when(request.getParameter("password")).thenReturn("drowssap");
        when(request.getParameter("pseudo")).thenReturn("");
        when(request.getParameter("confirmation")).thenReturn("drowssap");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        new CreateUser().test_post(request, response);
        verify(request).setAttribute("info", "vous devez remplir tous les champs");
    }

    @Test
    public void test_create_empty_mail() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("email")).thenReturn("");
        when(request.getParameter("password")).thenReturn("drowssap");
        when(request.getParameter("pseudo")).thenReturn("pseudo");
        when(request.getParameter("confirmation")).thenReturn("drowssap");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        new CreateUser().test_post(request, response);
        verify(request).setAttribute("info", "vous devez remplir tous les champs");
    }

    @Test
    public void test_create_empty_pswd() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("email")).thenReturn("email@ema.il");
        when(request.getParameter("password")).thenReturn("");
        when(request.getParameter("pseudo")).thenReturn("pseudo");
        when(request.getParameter("confirmation")).thenReturn("drowssap");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        new CreateUser().test_post(request, response);
        verify(request).setAttribute("info", "vous devez remplir tous les champs");
    }

    @Test
    public void test_create_empty_conf() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("email")).thenReturn("email@ema.il");
        when(request.getParameter("password")).thenReturn("drowssap");
        when(request.getParameter("pseudo")).thenReturn("pseudo");
        when(request.getParameter("confirmation")).thenReturn("");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        new CreateUser().test_post(request, response);
        verify(request).setAttribute("info", "vous devez remplir tous les champs");
    }
}
