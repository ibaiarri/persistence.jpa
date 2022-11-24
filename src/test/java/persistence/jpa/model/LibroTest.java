package persistence.jpa.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.txurdi.pathfinder.model.Personaje;
import com.txurdi.pathfinder.model.Usuario;

public class LibroTest {

	static ValidatorFactory factory;
	static Validator validator;
	static Usuario ediMock = null;
	static Personaje libroMock = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		factory = null;
		validator = null;
	}

	@Before
	public void setUp() throws Exception {
		ediMock = new Usuario(1, "kojima");
	//	libroMock = new Personaje("Kojima Proyect", ediMock);

	}

	@After
	public void tearDown() throws Exception {
		ediMock = null;
		libroMock = null;
	}

	@Test
	public void testLibroOK() {

		Set<ConstraintViolation<Personaje>> violaciones = validator.validate(libroMock);
		assertTrue("eL LIBRO ESTA GOOD ", violaciones.isEmpty());

	}

	@Test
	public void test2() {
		libroMock.setNombre(null);
		// libroMock.setNombre("a");
		// libroMock.setNombre("ab");

		Set<ConstraintViolation<Personaje>> violaciones = validator.validate(libroMock);
		assertFalse("El libro esta mal mi pana ", violaciones.isEmpty());
		System.out.println("Solo para debug");

	}

}
