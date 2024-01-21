import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import product.entities.Product;

import java.util.List;

@Stateless
@Remote(GestionProductRemote.class)
public class GestionProductBean implements GestionProductRemote {

    @PersistenceContext
    private EntityManager entityManager;

    public Product createProduct(Product product) {
        entityManager.persist(product);
        return product;
    }

    public Product updateProduct(Product product) {
        return entityManager.merge(product);
    }

    public void deleteProduct(Long productId) {
        Product product = entityManager.find(Product.class, productId);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    public Product getProductById(Long productId) {
        return entityManager.find(Product.class, productId);
    }

    public List<Product> getAllProducts() {
        return entityManager.createQuery("SELECT p FROM Produit p", Product.class).getResultList();
    }
}
