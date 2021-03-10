package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import agentesTIA.Agente;
import agentesTIA.Jefazo;
import inputOutput.IOData;

public class TestUploadAgentsFile {

	ArrayList<Agente> actual;
	ArrayList<Agente> expected;

	@Test
	public void testUploadAgentsFile() {

		actual = IOData.uploadAgentsFile("recursos/Agentes.dat");

		expected = new ArrayList<Agente>();

		expected.add(new Jefazo("Juan", 22, "sdfg", 22, 10));

		assertEquals(expected.get(0).getName(), actual.get(0).getName());
		//assertArrayEquals(expected.toArray(), actual.toArray());

	}

}
