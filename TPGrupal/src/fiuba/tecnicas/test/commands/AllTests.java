package fiuba.tecnicas.test.commands;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
		AbrirCajaCommandTest.class, 
		AgregarProductosCommandTest.class,
		CalcularTotalCompraCommandTest.class, 
		IniciarCompraCommandTest.class,
		VerTotalCajaCommandTest.class,
//		MedioDePagoCommandTest.class, VerTotalCajaCommandTest.class,
//		VerTotalCajaPorMediosDePagoTest.class,
//		VerTotalDescuentosCommandTest.class 
		})
public class AllTests {

}
