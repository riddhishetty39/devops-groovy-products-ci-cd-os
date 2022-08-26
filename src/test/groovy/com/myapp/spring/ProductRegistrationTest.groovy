package com.myapp.spring

import static groovy.json.JsonOutput.toJson
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc

import com.fasterxml.jackson.databind.ObjectMapper

import spock.lang.Specification
import spock.mock.DetachedMockFactory

@SpringBootTest

@AutoConfigureMockMvc()
class ProductRegistrationTest extends Specification {

	@Autowired
	MockMvc mvc

	@SpringBean
    ProductService productService=Mock()

    @Autowired
    ObjectMapper objectMapper

    def "should pass product save details to domain component and return 'ok' status"() {
        given:
        Product request = new Product(
              productId : 4,
                productName          : 'SamsungGalaxyNote',
                description     : 'SamsungGalaxyNote12',
				price: 78546.5,
				starRating: 4.2
        )

        and:
        productService.saveProduct(request)
		
		when:
		def response = mvc.perform(
				post('/products').contentType(APPLICATION_JSON).content(toJson(request))
		).andReturn().response  // notice the extra call to: andReturn()

		then:
		response.status == HttpStatus.OK.value()

		

//        when:
//        def results = mvc.perform(post('/products').contentType(APPLICATION_JSON).content(toJson(request)))
//
//        then:
//        results.andExpect(status().isOk())
//		
//
//        and:
//        results.andExpect(jsonPath('$.productId').value('4'))
//        results.andExpect(jsonPath('$.productName').value('SamsungGalaxyNote'))
//        results.andExpect(jsonPath('$.description').value('SamsungGalaxyNote12'))
//        results.andExpect(jsonPath('$.price').value('78546.5'))
//		results.andExpect(jsonPath('$.starRating').value('4.2'))
    }

    

//    @TestConfiguration
//    static class StubConfig {
//        DetachedMockFactory detachedMockFactory = new DetachedMockFactory()
//
//        @Bean
//        ProductService productService() {
//            return detachedMockFactory.Stub(ProductService)
//        }
//    }
}
