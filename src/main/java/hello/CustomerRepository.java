package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hcombs on 1/22/15.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName( String lastName );
}
