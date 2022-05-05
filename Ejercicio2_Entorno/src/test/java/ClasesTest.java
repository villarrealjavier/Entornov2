package test.java;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ClasesTest {
/**
 * Este Test se encarga de comprobar que el Mapa, no esta vacio, en este caso, le pasamos un numero entero,
 * que se almacena como Key en él, y mediante un assertTrue, comprobamos que efectivamente no se encuentra vacio.
 * @param num1 Es el parametro el cual le introuducimos, en nuestro caso, un valor entero
 *	Devuelve true, por lo cual no falla
 */
	@ValueSource (ints = {5,7})
	@ParameterizedTest
	void testNoVacia(Integer num1) {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(num1, 1);
		assertTrue(!mapaVacio.isEmpty());
	}
/**
 * En este caso comprobamos que nuestro Mapa se encuentra vacio, para ello creamos un mapa al cual no le introducimos
 * nada por parametro, ni le añadimos nada y mediante un assertTrue, efectivamente comprobamos que este se encuentra
 * totalmente vacio.
 */
	@org.junit.jupiter.api.Test
	void testIsEmpty() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		
		assertTrue(mapaVacio.isEmpty());
	}
/**
 * En este Test intentamos sacar intentamos sacar varios numeros los cuales no se encuentran dentro de este Mapa
 * y efectivamente mediante un AssertEquals  comprobamos que los valores que hemos tratado de obtener
 * algunos no se corresponden con los que hay dentro de este Mapa, y hemos probado también los casos, tanto como
 * obteniendo 0, como obtenido null, ya que si tratamos de obtener un valor que no se encuentra en él, devuelve null.
 * 
 */
	@org.junit.jupiter.api.Test
	void testNoObtiene() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(7, 7);
		
		assertEquals(mapaVacio.get(9), null);
		assertEquals(mapaVacio.get(0), null);
		assertEquals(mapaVacio.get(null), null);

	}
	
	/**
	 * Este caso es totalmente lo contrario, le metemos una serie de valores dentro del mapa, y sacamos estos valores
	 * asegurando que sacan los valores correctos y probando para cada uno de nuestros casos unos valores limites
	 * o unos valores un tanto especiales para asegurar que saca el resultado correcto.
	 */
	@org.junit.jupiter.api.Test
	void testGet() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(7, 7);
		mapaVacio.put(-7, 7);
		mapaVacio.put(0, 7);
		

		
		assertEquals(mapaVacio.get(7), 7);
		assertEquals(mapaVacio.get(-7), 7);
		assertEquals(mapaVacio.get(0), 7);

	}

	/**
	 * En este Test, se trata de comprobar que efectivamente en el mapa introduce los valores que le hemos incluido de
	 * forma correcta, dandole a cada uno de ellos, como en el test anterior, unos valores limites o especiales a tener
	 * en cuenta.
	 */
	@org.junit.jupiter.api.Test
	void testPut() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(3, 3);
		mapaVacio.put(-3, -3);
		mapaVacio.put(4, -3);
		mapaVacio.put(-4, 3);
		mapaVacio.put(0, 0);
		mapaVacio.put(null, null);




		assertEquals(mapaVacio.get(3), 3);
		assertEquals(mapaVacio.get(-3), -3);
		assertEquals(mapaVacio.get(-4), 3);
		assertEquals(mapaVacio.get(0), 0);
		assertEquals(mapaVacio.get(4), -3);
		assertEquals(mapaVacio.get(null), null);

		
	}

/**
 * En este Test comprobamos que mediante el metodo PutAll, se añade al mapa todos los elementos de otro mapa
 * que nosotros hemos creado anteriormente, y comprobamos que la longitud de este sea igual a la que le corresponde, es decir,
 * que tenga el total de elementos que debe tener sumando todos los elementos que poseen ambas listas.
 */
	@Test
	void testPutAll() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(3, 3);
		mapaVacio.put(-3, -3);
		mapaVacio.put(4, -3);
		mapaVacio.put(-4, 3);
		mapaVacio.put(0, 0);
		Map<Integer,Integer> mapaLleno = new HashMap<Integer,Integer>();
		mapaLleno.put(9, 9);
		mapaLleno.put(5, -6);
		mapaVacio.putAll(mapaLleno);
		assertEquals(mapaVacio.size(),7 );
		
	}

	/**
	 * En este Test comprobamos que nuestro mapa, al cual le hemos añadido una serie de valores,
	 * tras hacerle el metodo clear, deja el mapa limpio, es decir lo vacia y lo devuleve con una logitud de 0.
	 */
	@org.junit.jupiter.api.Test
	void testClear() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(3, 3);
		mapaVacio.put(-3, -3);
		mapaVacio.put(4, -3);
		mapaVacio.put(-4, 3);
		mapaVacio.put(0, 0);
		mapaVacio.clear();
		
		assertEquals(mapaVacio.size(), 0);
	}
	
	/**
	 * En este Test le pasamos por parametros una serie de palabras a nuestro Mapa, y le añadimos una palabra clave, y
	 * comprobamos que este, contenga la palabra que nosotros le hemos añadido, poniendolo a prueba con una serie de ejemplos.
	 * @param palabra Le pasamos por parametro la palabra que nos servirá de ejemplo para poner a prueba este metodo.
	 */
	@ValueSource(strings = {"Tomate","Queso","L"})
	@ParameterizedTest
	void testContienePalabra(String palabra) {
		Map<String,Integer> mapaVacio = new HashMap<String,Integer>();
		mapaVacio.put(palabra, 1);
		assertTrue(mapaVacio.containsKey(palabra));
		
	}
	/**
	 * Este Test se encarga de totalmente lo contrario, es decir, le volvemos a pasar la palabra por parametro, y se asegura
	 * de que en esta vez, ninguna de las palabras introducidas, las contiene nuestro Mapa.
	 * @param palabra Palabra que le pasaremos para poner a prueba este método.
	 */
	@ValueSource(strings = {"Tomate","Queso","L"})
	@ParameterizedTest
	void testNoContienePalabra(String palabra) {
		Map<String,Integer> mapaVacio = new HashMap<String,Integer>();
		mapaVacio.put("Ole", 1);
		assertTrue(!mapaVacio.containsKey(palabra));
		
	}

}
