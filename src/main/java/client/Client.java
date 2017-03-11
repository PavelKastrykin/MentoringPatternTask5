package client;

import entity.Person;
import facade.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class Client {

	@Autowired
	private PersonDAO personDAO;

	public Person getPersonByID (long id) {
		return personDAO.getByID(id);
	}

	public void insertNewPerson(Person person) {
		personDAO.insert(person);
	}

	public void updatePerson(Person person) {
		personDAO.update(person);
	}

	public void deletePerson(long id) {
		personDAO.delete(id);
	}


	public PersonDAO getPersonDAO()
	{
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO)
	{
		this.personDAO = personDAO;
	}
}
