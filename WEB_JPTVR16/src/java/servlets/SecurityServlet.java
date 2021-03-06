/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import util.Encription;
import entity.Reader;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.ReaderFacade;
import session.UserFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "SecurityServLet", loadOnStartup = 1, urlPatterns = {"showLogin", "/login", "/registration", "/showRegistration", "/showChangePassword", "/changePassword",})
public class SecurityServlet extends HttpServlet {

    @EJB
    private UserFacade userFacade;
    @EJB
    private ReaderFacade readerFacade;

    @Override
    public void init() throws ServletException {
        List<User> listUsers = userFacade.findAll();
        if (listUsers.size() != 0) {
            return;
        }
        Reader reader = new Reader("andrei.kovaljov@ivkhk.ee", "Andrei", "Kovaljov");
        readerFacade.create(reader);
        Encription encription = new Encription();
        String password = null;
        try {
            password = encription.getEncriptionPass("admin");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecurityServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        User user = new User("admin", password, true, reader);
        userFacade.create(user);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = null;
        String path = request.getServletPath();
        if (path != null) {
            switch (path) {
                case "/showLogin":
                    request.getRequestDispatcher("/showLogin.jsp").forward(request, response);

                    break;
                case "/login":
                    String login = request.getParameter("login");
                    String password = request.getParameter("password");
                    User regUser = userFacade.findUserByLogin(login);
                    if (regUser == null) {
                        request.setAttribute("info", "Неправильный логин или пароль!");
                        request.getRequestDispatcher("/showLogin.jsp").forward(request, response);
                    }
                    Encription encription = new Encription();
                    String encriptPassword = encription.getEncriptionPass(password);
                    if (!encriptPassword.equals(regUser.getPassword())) {
                        request.setAttribute("info", "Неправильный логин или пароль!");
                        request.getRequestDispatcher("/showLogin.jsp").forward(request, response);
                    }
                    session = request.getSession(true);
                    session.setAttribute("regUser", regUser);
                    request.setAttribute("info", "Вы вошли!");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
                case "/showRegistration":
                    request.getRequestDispatcher("/showRegistartion.jsp").forward(request, response);
                    break;
                case "/registration":
                    String name = request.getParameter("name");
                    String surname = request.getParameter("surname");
                    String email = request.getParameter("email");
                    login = request.getParameter("login");
                    String password1 = request.getParameter("password1");
                    String password2 = request.getParameter("password2");
                    if (!password1.equals(password2)) {
                        request.setAttribute("info", "Непсовпадает пароль!");
                        request.getRequestDispatcher("/showRegistartion.jsp").forward(request, response);
                    }

                    Reader reader = new Reader(email, name, surname);
                    readerFacade.create(reader);
                    encription = new Encription();
                    encriptPassword = encription.getEncriptionPass(password1);
                    User user = new User(login, encriptPassword, true, reader);
                    userFacade.create(user);
                    request.setAttribute("info", "Регистрация успешна!");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;

                case "/showChangePassword":
                    request.getRequestDispatcher("/changePassword.jsp").forward(request, response);
                    break;

                case "/changePassword":
                    session = request.getSession();
                    regUser = (User) session.getAttribute("regUser");
                    String oldPassword = request.getParameter("oldPassword");
                    encription = new Encription();
                    String encriptOldPassword = encription.getEncriptionPass(oldPassword);
                    if (!encriptOldPassword.equals(regUser.getPassword())) {
                        request.setAttribute("info", "Вы должны войти");
                        request.getRequestDispatcher("/showLogin.jsp").forward(request, response);
                        break;
                    }
                    String newPassword1 = request.getParameter("newPassword1");
                    String newPassword2 = request.getParameter("newPassword2");
                    if(newPassword1.equals(newPassword2)){
                      regUser.setPassword(encription.getEncriptionPass(newPassword1));
                      userFacade.edit(regUser);
                    }
                    request.setAttribute("info", "Вы успешно изменили пароль");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;

            }

        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecurityServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecurityServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
