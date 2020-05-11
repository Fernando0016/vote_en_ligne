/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_Test;

import servlet.Connexion;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Antoine
 */
public class Test_connexion {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_connexion_empty() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession ses = mock(HttpSession.class);

        when(request.getParameter("emaill")).thenReturn("");
        when(request.getParameter("password")).thenReturn("");
        when(request.getSession()).thenReturn(ses);

        new Connexion().test_post(request, response);
        verify(request).setAttribute("info", "vous devez remplir tous les champs svp");
    }

    @Test
    public void test_connexion_empty_email() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession ses = mock(HttpSession.class);

        when(request.getParameter("emaill")).thenReturn("");
        when(request.getParameter("password")).thenReturn("drowssap");
        when(request.getSession()).thenReturn(ses);

        new Connexion().test_post(request, response);
        verify(request).setAttribute("info", "vous devez remplir tous les champs svp");
    }

    @Test
    public void test_connexion_empty_pswd() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession ses = mock(HttpSession.class);

        when(request.getParameter("emaill")).thenReturn("email@ema.il");
        when(request.getParameter("password")).thenReturn("");
        when(request.getSession()).thenReturn(ses);

        new Connexion().test_post(request, response);
        verify(request).setAttribute("info", "vous devez remplir tous les champs svp");
    }
}
