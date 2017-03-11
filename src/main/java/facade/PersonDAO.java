package facade;

import entity.Person;

public interface PersonDAO {
	Person getByID(long id);
	void insert(Person person);
	void update(Person person);
	void delete(long id);
}
