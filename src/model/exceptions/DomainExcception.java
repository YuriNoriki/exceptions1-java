package model.exceptions;

public class DomainExcception extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DomainExcception(String msg) {
		super(msg);
	}

}
