package com.flintcore.web_info;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.flintcore.datos.ClienteDAO;
import com.flintcore.dominios.cliente;

@WebServlet("/ServletMovement")
public class ServletMovement extends HttpServlet {

	private static final String LIST_CLIENT = "clientes.jsp";
	private static final String INDEX = "Inicio.jsp";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.goToListClients(request, response);
	}

	//method to go to the list of clients.
	private void goToListClients(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<cliente> list = new ClienteDAO().listClients();

		// Send the list
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listCl", list);
		response.sendRedirect(LIST_CLIENT);
	}

}
