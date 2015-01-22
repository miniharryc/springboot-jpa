package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by hcombs on 1/22/15.
 */

@Configuration
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        CustomerRepository repository = context.getBean(CustomerRepository.class);

        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        //fetch all customers
        print( "findAll()", repository.findAll() );

        //fetch an individual customer by ID
        print( "findOne(1L)", Arrays.asList( repository.findOne(1L) ));

        //fetch customers by last name
        print( "findByLastName('Bauer')", repository.findByLastName("Bauer"));

        context.close();
    }

    private static void print( String source, Iterable<Customer> customers ) {
        System.out.println("Customer(s) found with " + source );
        System.out.println("------------------------------");
        for( Customer customer : customers ) {
            System.out.println( customer );
        }
        System.out.println();
    }
}
