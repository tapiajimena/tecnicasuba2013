package fiuba.tecnicas.test.ofertasrepository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fiuba.tecnicas.modelo.concreto.Oferta10porcientoFarmacia;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.OfertaFactory;

public class OfertasRepositoryTest {

	@Test
	public void testUNo() {
		
		Oferta o = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoFarmacia");
		assertEquals(new Oferta10porcientoFarmacia().getClass(), o.getClass());
	}

}
