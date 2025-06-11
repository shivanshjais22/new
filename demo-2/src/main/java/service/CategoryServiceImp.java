package service;


import dto.GenericProductDTO;
import Model.Product;
import repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public class CategoryServiceImp implements CategoryService {

	CategoryRepository categoryrepository;
	
	@Override
	public Page<GenericProductDTO> getProductsByCategoryId(long categoryId, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		long start =(long) (pageNumber-1)*pageSize;
		
		List<GenericProductDTO> products=categoryrepository.findById(categoryId).orElseThrow().getProducts()
                .stream()
                .skip(start)
                .limit(pageSize)
                .map(this::from)
                .toList();
		 Pageable pageable = PageRequest.of(pageNumber, pageSize);
	        return new PageImpl<>(products, pageable, products.size());
	}  
	   public GenericProductDTO from(Product product) {
	        GenericProductDTO genericProductDTO = new GenericProductDTO();
	        genericProductDTO.setTitle(product.getTitle());
	        genericProductDTO.setDescription(product.getDescription());
	        genericProductDTO.setCategory(product.getCategory().getName());
	        genericProductDTO.setPrice(product.getPrice().getValue());
	        genericProductDTO.setImage(product.getImage());
	        return genericProductDTO;
	    }

}
