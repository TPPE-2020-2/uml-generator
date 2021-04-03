package uml.diagrams.sequence.fragments;

import java.util.ArrayList;
import java.util.List;

import uml.diagrams.sequence.BaseGroup;
import uml.diagrams.sequence.exceptions.SequenceDiagramRuleException;
import uml.diagrams.sequence.sequencediagrams.fragments.Fragment;

public class Fragments extends BaseGroup {
	
	public final static String NULL_OPTIONAL_VALUE = "O Optional não pode ser nulo";
	
	private List<Optional> optionals;
	
	public Fragments() {
		this.optionals = new ArrayList<Optional>();
	}
	
	public void addOptional(Optional optional) throws SequenceDiagramRuleException {
		if (optional == null)
			throw new SequenceDiagramRuleException(NULL_OPTIONAL_VALUE);
		this.optionals.add(optional);
	}
	
	public List<Optional> getOptionals() {
		return optionals;
	}
	
	public Optional getOptional(Fragment fragment) {
	    for (Optional optional : optionals) {
	        if (optional.getFragment().equals(fragment)) {
	            return optional;
	        }
	    }
	    return null;
    }
	
	@Override
	public String toString() {
		String optionalsList = "";
		
		for (Optional temp: optionals)
			optionalsList += temp.toString();
		
		return "<Fragments>" + optionalsList + "</Fragments>";
	}
}