package controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import dto.GenericProductDTO;
import lombok.AllArgsConstructor;
import service.CategoryService;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	CategoryService categoruservice;
	
	public ResponseEntity<Page<GenericProductDTO>> getProductsByCategoryId(@PathVariable("id") long categoryId,
            @PathVariable("page") int pageNumber,
            @PathVariable("size") int pageSize){

		Page<GenericProductDTO> genericProductDTOS=this.categoruservice.getProductsByCategoryId(categoryId, pageNumber, pageSize);
	     
		return new ResponseEntity<>(genericProductDTOS, HttpStatus.OK);

		
	}
	
}
