package com.myapp.spring

interface ProductService {
	
	List<Product> findAll()
	
		Product findById(Integer productId)
	
		Product saveProduct(Product product)
	
		
	
		Product deleteProduct(Integer productId)
}
