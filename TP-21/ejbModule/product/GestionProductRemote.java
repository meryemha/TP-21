import javax.ejb.Remote;


import java.util.List;

@Remote
public interface GestionProductRemote {

    Product createProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long productId);

    Product getProductById(Long productId);

    List<Product> getAllProducts();
}
