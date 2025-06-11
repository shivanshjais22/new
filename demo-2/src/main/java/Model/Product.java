package Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product  extends Basemodel{

	
	  private String title;
	    private String description;
	    private String  image;
	    
	    @ManyToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name="category_id")
	    private Category category;

	    @OneToOne(cascade = {CascadeType.ALL}) //Add and remove price when product is added or removed
	    private Price price;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public Price getPrice() {
			return price;
		}

		public void setPrice(Price price) {
			this.price = price;
		}
	

}
