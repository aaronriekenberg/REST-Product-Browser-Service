package org.aaron.product.browser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

import org.aaron.product.browser.entities.ProductDetails;
import org.aaron.product.browser.repositories.ProductDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PopulateProducts is used to populate sample data into the database at
 * startup.
 */
public class PopulateProducts {

	private static final Logger log = LoggerFactory
			.getLogger(PopulateProducts.class);

	/**
	 * Delete all items from the ProductDetailsRepository, then add sample data
	 * items to ProductDetailsRepository.
	 * 
	 * @param productDetailsRepository
	 *            the ProductDetailsRepository
	 * @throws ParseException
	 *             if there is an error parsing sample date data
	 */
	public PopulateProducts(ProductDetailsRepository productDetailsRepository)
			throws ParseException {
		Objects.requireNonNull(productDetailsRepository,
				"productDetailsRepository is null");

		productDetailsRepository.deleteAll();

		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		ProductDetails productDetails;

		productDetails = new ProductDetails();
		productDetails.setId("5555");
		productDetails.setSku("AEX143");
		productDetails.setName("Stroller");
		productDetails.setCategory("baby");
		productDetails.setLastUpdated(dateFormat.parse("2014-05-23"));
		productDetails.setPrice(199.99);
		log.info("save productDetails {}", productDetails);
		productDetailsRepository.save(productDetails);

		productDetails = new ProductDetails();
		productDetails.setId("5543");
		productDetails.setSku("IOL123");
		productDetails.setName("Optimus Prime");
		productDetails.setCategory("toys");
		productDetails.setLastUpdated(dateFormat.parse("2014-02-01"));
		productDetails.setPrice(13.37);
		log.info("save productDetails {}", productDetails);
		productDetailsRepository.save(productDetails);

		productDetails = new ProductDetails();
		productDetails.setId("7563");
		productDetails.setSku("XYZ904");
		productDetails.setName("Sega Genesis");
		productDetails.setCategory("toys");
		productDetails.setLastUpdated(dateFormat.parse("1989-04-01"));
		productDetails.setPrice(149.99);
		log.info("save productDetails {}", productDetails);
		productDetailsRepository.save(productDetails);
	}
}
