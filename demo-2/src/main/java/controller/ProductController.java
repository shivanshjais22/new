package controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dto.GenericProductDTO;
import lombok.AllArgsConstructor;
import service.ProductService;


@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
	
	
	ProductService productService;
    @PostMapping
    public ResponseEntity<GenericProductDTO> createProduct(@RequestBody GenericProductDTO genericProductDTO){
        GenericProductDTO genericProductDTO1 = productService.createProduct(genericProductDTO);
        return new ResponseEntity<>(genericProductDTO1, HttpStatus.OK);
    }
    @PostMapping("/bulk")
    public ResponseEntity<List<GenericProductDTO>> createProductsInBulk(@RequestBody List<GenericProductDTO> productDTOS){
        List<GenericProductDTO> productDTOList = productService.createProductsInBulk(productDTOS);
        return new ResponseEntity<>(productDTOList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenericProductDTO> getProductById(@PathVariable("id") long productId){
        GenericProductDTO genericProductDTO = productService.getProductById(productId);
        return new ResponseEntity<>(genericProductDTO, HttpStatus.OK);
    }
    @GetMapping("page/{page}/{size}")
    public ResponseEntity<Page<GenericProductDTO>> getAllProduct(@PathVariable("page") int pageNumber, @PathVariable("size") int pageSize){
        Page<GenericProductDTO> productDTOS = productService.getAllProduct(pageNumber,pageSize);
        return new ResponseEntity<>(productDTOS,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenericProductDTO> updateProduct(@RequestBody GenericProductDTO genericProductDTO, @PathVariable("id") long productId){
        GenericProductDTO productDTO = productService.updateProduct(genericProductDTO,productId);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDTO> deleteProduct(@PathVariable("id") long productId){
        GenericProductDTO genericProductDTO = productService.deleteProduct(productId);
        return new ResponseEntity<>(genericProductDTO,HttpStatus.OK);
    }

}
