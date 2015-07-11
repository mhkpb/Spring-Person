package jpa_bayan;

import java.beans.PropertyEditorSupport;

public class P_PropertyEditor extends PropertyEditorSupport {
 
	private PersonDAO personDao;

	
	public P_PropertyEditor(PersonDAO personDao) {
		this.personDao=personDao;
	}
	
	public void setAsText(String text) {
		Person person ;
		person = personDao.getPerson(Integer.parseInt(text));
		setValue(person);
		}
		 
	
}
