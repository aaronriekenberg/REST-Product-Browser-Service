package org.aaron.product.browser.repositories;

import java.util.List;

import org.aaron.product.browser.entities.ProductDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * A repository of ProductDetails objects indexed by unique identifiers
 */
public interface ProductDetailsRepository extends
		MongoRepository<ProductDetails, String> {

	/**
	 * Find a list of ProductDetails by product category
	 * 
	 * @param category
	 *            product category
	 * @return list of matching ProductDetails objects
	 */
	public List<ProductDetails> findByCategory(String category);

}
