package fiuba.tecnicas.test.ofertasrepository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fiuba.tecnicas.modelo.concreto.OfertaGenerica;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.OfertaFactory;

public class OfertasRepositoryTest {

	@Test
	public void testUNo() {
		
		Oferta o = OfertaFactory.getInstance().ConstruiOferta("OfertaGenerica");
		assertEquals(new OfertaGenerica().getClass(), o.getClass());
	}
	
	
	
	

}
