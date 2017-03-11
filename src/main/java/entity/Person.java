package entity;

import java.sql.Timestamp;
import java.util.Objects;

public class Person {
	private long personID;
	private String firstName;
	private String lastName;
	private Timestamp birthDate;

	public Person(){}

	public long getPersonID()
	{
		return personID;
	}

	public void setPersonID(long personID)
	{
		this.personID = personID;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Timestamp getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate)
	{
		this.birthDate = birthDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Person person = (Person) o;
		return personID == person.personID &&
				Objects.equals(firstName, person.firstName) &&
				Objects.equals(lastName, person.lastName) &&
				Objects.equals(birthDate, person.birthDate);
	}

	@Override public int hashCode()
	{
		return Objects.hash(personID, firstName, lastName, birthDate);
	}
}
