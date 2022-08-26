package com.myapp.spring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


// http://IP:PORT/products
// Owner Pradeep Krishnamurthy





@RestController
@RequestMapping("products")
class ProductController {
	
	 @Autowired
    ProductService ProductService

    @GetMapping
    List<Product> getAllProductList(){
        ProductService.findAll()
    }

    @PostMapping
    Product saveProduct(@RequestBody Product product){
        ProductService.saveProduct product
    }

    @PutMapping('/{productId}')
    Product updateProduct(@PathVariable Integer productId, @RequestBody Product product){
        ProductService.updateProduct productId, product
    }

    @DeleteMapping('/{productId}')
    deleteProduct(@PathVariable Integer productId){
        ProductService.deleteProduct productId
    }

    @GetMapping('/{productId}')
    Product getProductById(@PathVariable Integer productId){
        ProductService.findById productId
    }
	
	
	
	
	
	
	
}
