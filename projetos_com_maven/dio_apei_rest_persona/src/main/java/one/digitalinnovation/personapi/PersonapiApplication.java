package one.digitalinnovation.personapi;

import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Phone;
import one.digitalinnovation.personapi.enums.PhoneType;
import one.digitalinnovation.personapi.service.PersonService;
import one.digitalinnovation.personapi.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ComponentScan
@SpringBootApplication
public class PersonapiApplication implements CommandLineRunner {

	//@Autowired
	//PersonService personService;

	//@Autowired
	//PhoneService phoneService;

	public static void main(String[] args) {
		SpringApplication.run(PersonapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		setData( );
	}

	public void setData() throws ParseException, java.text.ParseException {


		//List<Phone> phones = new ArrayList<>();

		//Phone p1 = new Phone(PhoneType.MOBILE, "999999999");
		//System.out.println(p1);
		//p1 = phoneService.save(p1);
		//System.out.println(p1);
		//phones.add(p1);
		//System.out.println("phones-->" + phones);

		//LocalDate dt = LocalDate.of(2021, 01, 21);

		/*Person pe = new Person(
				"Rodrigo",
				"Peralgo",
				"dfsdfsdfsdfsdf",
				dt, phones);
				*/
		//System.out.println(pe);

		//System.out.println(personService.save(pe));

		//System.out.println( personService.find(1L).get());
	}

}
