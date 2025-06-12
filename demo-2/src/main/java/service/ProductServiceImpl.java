package service;

import java.util.List;

import dto.GenericProductDTO;
import Model.Category;
import Model.Price;
import Model.Product;
import repository.ProductRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    ProductRepository productRepository;

    public Product from(GenericProductDTO genericProductDTO) {
    	  Product product = new Product();

    	    // Add this line to set ID if updating
    	
    	    Category category = new Category();
    	    category.setName(genericProductDTO.getCategory());

    	    Price price = new Price();
    	    price.setValue(genericProductDTO.getPrice());

    	    product.setTitle(genericProductDTO.getTitle());
    	    product.setDescription(genericProductDTO.getDescription());
    	    product.setImage(genericProductDTO.getImage());
    	    product.setCategory(category);
    	    product.setPrice(price);

    	    return product;
    	    }

    public GenericProductDTO from(Product product) {
    	 GenericProductDTO dto = new GenericProductDTO();
    	   dto.setTitle(product.getTitle());
    	    dto.setDescription(product.getDescription());
    	    dto.setCategory(product.getCategory().getName());
    	    dto.setPrice(product.getPrice().getValue());
    	    dto.setImage(product.getImage());
    	    return dto;
    }

	@Override
	public GenericProductDTO createProduct(GenericProductDTO product) {
		/*
		 * Product product = from(genericProductDTO); Product savedProduct =
		 * productRepository.save(product); return from(savedProduct);
		 * 
		 */
		
		Product product1=from(product);
	Product p=	productRepository.save(product1);
		
		return from(p);
	}

	@Override
	public List<GenericProductDTO> createProductsInBulk(List<GenericProductDTO> productDTOS) {
		  
		 List<Product> products = productDTOS.stream()
	                .map(this::from)
	                .collect(Collectors.toList());
	        return productRepository.saveAll(products)
	                .stream()
	                .map(this::from)
	                .collect(Collectors.toList());
	}

	@Override
	public GenericProductDTO getProductById(long productId) {
		// TODO Auto-generated method stub
		 Optional<Product> product = Optional.of(productRepository.findById(productId).orElseThrow());
	        return from(product.get());
	}

	@Override
	public Page<GenericProductDTO> getAllProduct(int pageNumber, int pageSize) {
		   return productRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("title"))).map(this::from);
		   
	}

	@Override
	public GenericProductDTO updateProduct(GenericProductDTO genericProductDTO, long productId) {
		  Product product = productRepository.findById(productId).orElseThrow();
	        product.setTitle(genericProductDTO.getTitle());
	        product.getCategory().setName(genericProductDTO.getCategory());
	        product.getPrice().setValue(genericProductDTO.getPrice());
	        product.setDescription(genericProductDTO.getDescription());
	        product.setImage(genericProductDTO.getImage());
	        productRepository.save(product);
	        return genericProductDTO;
	}

	@Override
	public GenericProductDTO deleteProduct(long id) {
		return productRepository.findById(id)
                .map((product) -> {
                    productRepository.delete(product);
                    return from(product);
                })
                .orElseThrow();
	}
}