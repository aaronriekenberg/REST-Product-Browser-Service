package org.aaron.product.browser.services;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.aaron.product.browser.entities.ProductDetails;
import org.aaron.product.browser.repositories.ProductDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProductDetailsService is a restful service that allows read access to
 * ProductDetails.
 */
public class ProductDetailsService {

	private static final Logger log = LoggerFactory
			.getLogger(ProductDetailsService.class);

	private final ProductDetailsRepository productDetailsRepository;

	/**
	 * Constructor
	 * 
	 * @param productDetailsRepository
	 *            product details repository
	 */
	public ProductDetailsService(
			ProductDetailsRepository productDetailsRepository) {
		this.productDetailsRepository = Objects.requireNonNull(
				productDetailsRepository, "productDetailsRepository is null");
	}

	/**
	 * Perform a get request to find product details by unique identifier
	 * 
	 * @param id
	 *            unique identifier
	 * @return product details
	 * @throws NotFoundException
	 *             if no product details can be found for the identifier
	 */
	@GET
	@Path("/productDetails/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductDetails getByID(@PathParam("id") String id) {
		log.info("in getByID id = '{}'", id);

		final ProductDetails details = productDetailsRepository.findOne(id);
		if (details == null) {
			throw new NotFoundException(
					"Unable to find ProductDetails for id '" + id + "'");
		}
		return details;
	}

	/**
	 * Perform a get request to search for product details.
	 * 
	 * @param category
	 *            product category to search for
	 * @return A list of product details. The list is empty of no matching
	 *         products are found.
	 */
	@GET
	@Path("/productDetailsSearch")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDetails> searchByCategory(
			@QueryParam("category") String category) {
		log.info("in searchByCategory category = '{}'", category);

		return productDetailsRepository.findByCategory(category);
	}

}
