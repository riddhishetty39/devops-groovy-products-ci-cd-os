package com.myapp.spring

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository  extends JpaRepository<Product,Integer>{
}
