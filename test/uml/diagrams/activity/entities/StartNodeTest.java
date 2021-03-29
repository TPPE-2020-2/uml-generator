package uml.diagrams.activity.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import uml.diagrams.activity.exceptions.ActivityDiagramRuleException;

class StartNodeTest {
	private final String NAME = "startNode";
	private final String NAME_2 = "startNode2";
	
	private StartNode initialNode;
	
	@Test
	void testGetStartNodeName() {
		initialNode = new StartNode(NAME);

		assertEquals(NAME, initialNode.getName());
	}
	
	@Test
	void testSetStartNodeName() {
		initialNode = new StartNode(NAME);
		
		initialNode.setName(NAME_2);
		
		assertEquals(NAME_2, initialNode.getName());
	}
	
	@Test
	void testErrorWhenEmptyName() {
		assertThrows(ActivityDiagramRuleException.class, () -> new StartNode(""));
	}
}
