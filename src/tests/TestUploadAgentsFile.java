package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import agentesTIA.Agente;
import agentesTIA.Jefazo;
import inputOutput.IOData;

public class TestUploadAgentsFile {

	@Test
	public void testUploadAgentsFile() {
		
		ArrayList<Agente> actual = IOData.uploadAgentsFile("recursos/Agentes.dat");
		
		ArrayList<Agente> expected = new ArrayList<Agente>();
		
		expected.add(new Jefazo("Juan", 22, "sdfg", 22, 10));
		
		assertArrayEquals(expected.toArray(), actual.toArray());
	
	}

}
