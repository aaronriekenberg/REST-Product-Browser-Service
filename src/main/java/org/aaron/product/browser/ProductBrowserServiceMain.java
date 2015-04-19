package org.aaron.product.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ProductBrowserServiceMain contains the main class for the product browser
 * service application.
 */
public class ProductBrowserServiceMain {

	private static final Logger log = LoggerFactory
			.getLogger(ProductBrowserServiceMain.class);

	/**
	 * Main method for the product browser service application
	 */
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/spring.xml")) {
			while (true) {
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					log.warn("main interrupted", e);
				}
			}
		}
	}
}
