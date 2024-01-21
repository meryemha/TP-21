package product;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.entities.Product;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private GestionProductRemote gestionProductBean;

	@Override
	public void init() throws ServletException {
	    try {
	        // Initialiser le contexte JNDI
	        Context context = new InitialContext();

	        // Obtenir une référence vers le bean EJB via JNDI
	        gestionProductBean = (GestionProductRemote) context.lookup("java:global/TP-21/ejbModule/product.GestionProductBean!product.GestionProductRemote");
	    } catch (NamingException e) {
	        throw new ServletException("Erreur lors de l'initialisation du bean EJB", e);
	    }
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer la liste des produits depuis le bean EJB
        List<Product> listeProducts = gestionProductBean.getAllProducts();

        // Mettre la liste des produits dans la portée de la requête
        request.setAttribute("listeProducts", listeProducts);

        // Rediriger vers la page JSP pour afficher la liste des produits
        request.getRequestDispatcher("/WEB-INF/product-list.jsp").forward(request, response);
    }
}
