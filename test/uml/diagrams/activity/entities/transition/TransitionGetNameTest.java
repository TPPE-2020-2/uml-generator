package uml.diagrams.activity.entities.transition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import uml.diagrams.activity.entities.Transition;
import uml.diagrams.activity.exceptions.ActivityDiagramRuleException;

class TransitionGetNameTest {

	private Transition transition;
	
	@BeforeEach
	public void setup() {
		transition = new Transition();
	}
	
	public static Collection transitionNames() {
		return Arrays.asList(new Object[][] {
	        { "defaultName" },
	        { "transition" },
	        { "triangulacao" } 
		});
	}
	
	@ParameterizedTest
	@MethodSource("transitionNames")
	public void testGetNameOfTransition(String name) throws ActivityDiagramRuleException {
		transition.setName(name);
		
		assertEquals(name, transition.getName());
	}
	
	public static Collection emptyValues() {
		return Arrays.asList(new Object[][] {
	        { "" },
	        { null }
		});
	}
	
	@ParameterizedTest
	@MethodSource("emptyValues")
	public void testValidateEmptyOrNullName(String name) {
		final String message = "O nome não pode ser vazio ou nulo";
		
		ActivityDiagramRuleException exception = assertThrows(
				ActivityDiagramRuleException.class, 
				() -> transition.setName(name));
		
		assertEquals(message, exception.getMessage());
	}

}