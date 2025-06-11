package service;

import org.springframework.data.domain.Page;

import dto.GenericProductDTO;

public interface CategoryService {
	
	Page<GenericProductDTO> getProductsByCategoryId(long categoryId, int pageNumber, int pageSize);
}
