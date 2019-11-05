package ph.edu.up.antech.controller.rest;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import ph.edu.up.antech.domain.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Ignore
public class ProductControllerTest {

	@Test
	public void verifyCreationOfProduct_shouldBeSuccessful() {
		String uri = "http://localhost:8080/api/v1/products";
		RestTemplate restTemplate = new RestTemplate();

		Product product = new Product();
		product.setBase("CAN");

		ProductInformation productInformation = new ProductInformation();
		productInformation.setBiological(false);

		ProductWeight productWeight = new ProductWeight();
		productWeight.setNetWeightPerSKU(new BigDecimal("1.5"));

		LicenseInformation licenseInformation = new LicenseInformation();
		licenseInformation.setCode("FOOD");

		Confirmation confirmation = new Confirmation();
		confirmation.setConfirmationDate(LocalDate.now());

		AlternativeUOM alternativeUOM = new AlternativeUOM();
		alternativeUOM.setPiecesPerCarton(5);

		Dimension dimension = new Dimension();
		dimension.setHeight(BigDecimal.ONE);

		Issuance issuance = new Issuance();
		issuance.setBox(5);

		Completion completion = new Completion();
		completion.setCompletionDate(LocalDate.now());

		product.setProductInformation(productInformation);
		product.setProductWeight(productWeight);
		product.setLicenseInformation(licenseInformation);
		product.setConfirmation(confirmation);
		product.setAlternativeUOM(alternativeUOM);
		product.setDimension(dimension);
		product.setIssuance(issuance);
		product.setCompletion(completion);

		Product returnedProduct = restTemplate.postForObject(uri, product, Product.class);
	}

}
