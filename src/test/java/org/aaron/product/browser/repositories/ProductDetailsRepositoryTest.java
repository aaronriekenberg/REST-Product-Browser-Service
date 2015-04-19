package org.aaron.product.browser.repositories;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import org.aaron.product.browser.entities.ProductDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JUnit test for ProductDetailsRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-spring.xml" })
public class ProductDetailsRepositoryTest {

	@Autowired
	private ProductDetailsRepository productDetailsRepository;

	private ProductDetails productDetails1;

	private ProductDetails productDetails2;

	private ProductDetails productDetails3;

	/**
	 * Test set up
	 */
	@Before
	public void before() throws ParseException {
		productDetailsRepository.deleteAll();

		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		productDetails1 = new ProductDetails();
		productDetails1.setId("5555");
		productDetails1.setSku("AEX143");
		productDetails1.setName("Stroller");
		productDetails1.setCategory("baby");
		productDetails1.setLastUpdated(dateFormat.parse("2014-05-23"));
		productDetails1.setPrice(199.99);
		productDetailsRepository.save(productDetails1);

		productDetails2 = new ProductDetails();
		productDetails2.setId("5543");
		productDetails2.setSku("IOL123");
		productDetails2.setName("Optimus Prime");
		productDetails2.setCategory("toys");
		productDetails2.setLastUpdated(dateFormat.parse("2014-02-01"));
		productDetails2.setPrice(13.37);
		productDetailsRepository.save(productDetails2);

		productDetails3 = new ProductDetails();
		productDetails3.setId("7563");
		productDetails3.setSku("XYZ904");
		productDetails3.setName("Sega Genesis");
		productDetails3.setCategory("toys");
		productDetails3.setLastUpdated(dateFormat.parse("1989-04-01"));
		productDetails3.setPrice(149.99);
		productDetailsRepository.save(productDetails3);
	}

	/**
	 * Test the findOne method
	 */
	@Test
	public void testFindOne() {
		assertThat(productDetailsRepository.findOne("5555"),
				is(productDetails1));
		assertThat(productDetailsRepository.findOne("5543"),
				is(productDetails2));
		assertThat(productDetailsRepository.findOne("7563"),
				is(productDetails3));
		assertThat(productDetailsRepository.findOne("BAD"), nullValue());
	}

	/**
	 * Test passing a null parameter to findOne
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFindNull() {
		productDetailsRepository.findOne(null);
	}

	/**
	 * Test finding product details by category baby
	 */
	@Test
	public void testFindCategoryBaby() {
		final List<ProductDetails> result = productDetailsRepository
				.findByCategory("baby");

		assertThat(result, is(Collections.singletonList(productDetails1)));
	}

	/**
	 * Test finding product details by category toys
	 */
	@Test
	public void testFindCategoryToys() {
		final List<ProductDetails> result = productDetailsRepository
				.findByCategory("toys");

		assertThat(result.size(), is(2));
		assertThat(result.contains(productDetails2), is(true));
		assertThat(result.contains(productDetails3), is(true));
	}

	/**
	 * Test finding product details by category unknown
	 */
	@Test
	public void testFindCategoryUnknown() {
		final List<ProductDetails> result = productDetailsRepository
				.findByCategory("unknown");

		assertThat(result.size(), is(0));
	}

	/**
	 * Test finding product details by category null
	 */
	@Test
	public void testFindCategoryNull() {
		final List<ProductDetails> result = productDetailsRepository
				.findByCategory(null);

		assertThat(result.size(), is(0));
	}
}
