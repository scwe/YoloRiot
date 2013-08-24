package structureAIs;

import structures.Structure;


public class SimpleCannonAI implements StructureAI {

	public void next(Structure s) {
		s.fire();
	}
}
