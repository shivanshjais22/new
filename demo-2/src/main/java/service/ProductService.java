package service;

import java.util.List;

import org.springframework.data.domain.Page;

import dto.GenericProductDTO;

public interface ProductService {
	  GenericProductDTO createProduct(GenericProductDTO product);
	    List<GenericProductDTO> createProductsInBulk(List<GenericProductDTO> productDTOS);
	    GenericProductDTO getProductById(long productId);
	    Page<GenericProductDTO> getAllProduct(int pageNumber, int pageSize);
	    GenericProductDTO updateProduct(GenericProductDTO genericProductDTO, long productId);
	    GenericProductDTO deleteProduct(long id);
}
