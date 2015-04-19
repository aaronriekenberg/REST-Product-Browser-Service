package org.aaron.product.browser.services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.aaron.product.browser.entities.ProductDetails;
import org.aaron.product.browser.repositories.ProductDetailsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JUnit test for ProductDetailsService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-spring.xml" })
public class ProductDetailsServiceTest {

	@Autowired
	private ProductDetailsRepository productDetailsRepository;

	@Autowired
	private ProductDetailsService productDetailsService;

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
	 * Test getting productDetails1
	 */
	@Test
	public void testGetID1() {
		final ProductDetails result = productDetailsService.getByID("5555");

		assertThat(result, is(productDetails1));
	}

	/**
	 * Test getting productDetails2
	 */
	@Test
	public void testGetID2() {
		final ProductDetails result = productDetailsService.getByID("5543");

		assertThat(result, is(productDetails2));
	}

	/**
	 * Test getting unknown product identifier
	 */
	@Test(expected = NotFoundException.class)
	public void testGetUnknownID() {
		productDetailsService.getByID("BAD");
	}

	/**
	 * Test getting null product identifier
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetNullID() {
		productDetailsService.getByID(null);
	}

	/**
	 * Test searching for category baby
	 */
	@Test
	public void testSearchForBaby() {
		final List<ProductDetails> result = productDetailsService
				.searchByCategory("baby");

		assertThat(result, is(Collections.singletonList(productDetails1)));
	}

	/**
	 * Test searching for category toys
	 */
	@Test
	public void testSearchForToys() {
		final List<ProductDetails> result = productDetailsService
				.searchByCategory("toys");

		assertThat(result.size(), is(2));
		assertThat(result.contains(productDetails2), is(true));
		assertThat(result.contains(productDetails3), is(true));
	}

	/**
	 * Test searching for category unknown
	 */
	@Test
	public void testSearchForUnknown() {
		final List<ProductDetails> result = productDetailsService
				.searchByCategory("unknown");

		assertThat(result.size(), is(0));
	}

	/**
	 * Test searching for category null
	 */
	@Test
	public void testSearchForNull() {
		final List<ProductDetails> result = productDetailsService
				.searchByCategory(null);

		assertThat(result.size(), is(0));
	}

}
