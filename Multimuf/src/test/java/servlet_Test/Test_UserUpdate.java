/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_Test;

import servlet.UserUpdate;
import org.junit.Test;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import static org.mockito.Mockito.*;

/**
 *
 * @author Antoine
 */
public class Test_UserUpdate {

//    @Test
//    public void test_empty_args() throws ServletException, IOException {
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//
//        when(request.getParameter("email")).thenReturn("");
//        when(request.getParameter("password")).thenReturn("");
//        when(request.getParameter("pseudo")).thenReturn("");
//
//        new UserUpdate().test_post(request, response);
//        verify(request).setAttribute("info", "vous devez renseigner tous les champs SVP ");
//    }
//
//    @Test
//    public void test_empty_mail() throws ServletException, IOException {
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//
//        when(request.getParameter("email")).thenReturn("");
//        when(request.getParameter("password")).thenReturn("drosswap");
//        when(request.getParameter("pseudo")).thenReturn("pseudo");
//
//        new UserUpdate().test_post(request, response);
//        verify(request).setAttribute("info", "vous devez renseigner tous les champs SVP ");
//    }
//
//    @Test
//    public void test_empty_pswd() throws ServletException, IOException {
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//
//        when(request.getParameter("email")).thenReturn("email@ema.il");
//        when(request.getParameter("password")).thenReturn("");
//        when(request.getParameter("pseudo")).thenReturn("pseudo");
//
//        new UserUpdate().test_post(request, response);
//        verify(request).setAttribute("info", "vous devez renseigner tous les champs SVP ");
//    }
//
//    @Test
//    public void test_empty_pseudo() throws ServletException, IOException {
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//
//        when(request.getParameter("email")).thenReturn("email@ema.il");
//        when(request.getParameter("password")).thenReturn("drosswap");
//        when(request.getParameter("pseudo")).thenReturn("");
//
//        new UserUpdate().test_post(request, response);
//        verify(request).setAttribute("info", "vous devez renseigner tous les champs SVP ");
//    }
}
