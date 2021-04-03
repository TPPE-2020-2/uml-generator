package uml.diagrams.sequence.fragments;

import uml.diagrams.sequence.exceptions.EmptyOptionalFragmentException;
import uml.diagrams.sequence.exceptions.SequenceDiagramRuleException;
import uml.diagrams.sequence.sequencediagrams.SequenceDiagram;
import uml.diagrams.sequence.sequencediagrams.fragments.Fragment;

public class Optional {
    
    static final String FRAGMENT_ERROR = "É necessário informar um fragmento válido que esteja dentro do diagrama de sequência associado";
    static final String REPRESENTED_BY_ERROR = "É necessário informar o diagrama de sequência associado";
    
    private Fragment fragment;
	private SequenceDiagram representedBy;
	
	public Optional(Fragment fragment, SequenceDiagram representedBy)
	        throws SequenceDiagramRuleException, EmptyOptionalFragmentException {
		setRepresentedBy(representedBy);
		setFragment(fragment);
	}
	
	public void setFragment(Fragment fragment) throws SequenceDiagramRuleException {
	    if (fragment == null || representedBy.getElement(fragment) == null) {
	        throw new SequenceDiagramRuleException(FRAGMENT_ERROR);
	    }
	    
	    this.fragment = fragment;
	}
	
	public Fragment getFragment() {
        return fragment;
    }
	
	public void setRepresentedBy(SequenceDiagram representedBy)
	        throws EmptyOptionalFragmentException {
	    if (representedBy == null) {
	        throw new EmptyOptionalFragmentException(REPRESENTED_BY_ERROR);
	    }
	    
		this.representedBy = representedBy;
	}
	
	public SequenceDiagram getRepresentedBy() {
		return representedBy;
	}
	
	@Override
	public String toString() {
		return "<Optional " +
			"name=\"" + fragment.getName() + "\" " + 
			"representedBy=\"" + representedBy.getName() + "\"/>";
	}
}
