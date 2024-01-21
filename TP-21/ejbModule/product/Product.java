package product;


import java.io.Serializable;
import java.lang.Double;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity

public class Product implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private Long Name;
	private Long Description;
	private Double Price;
	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}   
	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}   
	public Long getName() {
		return this.Name;
	}

	public void setName(Long Name) {
		this.Name = Name;
	}   
	public Long getDescription() {
		return this.Description;
	}

	public void setDescription(Long Description) {
		this.Description = Description;
	}   
	public Double getPrice() {
		return this.Price;
	}

	public void setPrice(Double Price) {
		this.Price = Price;
	}
   
}
