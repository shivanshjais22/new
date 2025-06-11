package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Order extends Basemodel{
    @ManyToMany
    @JoinTable(name="product_order",
            joinColumns =@JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<Product> product;
}