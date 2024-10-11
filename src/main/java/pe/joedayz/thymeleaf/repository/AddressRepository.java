package pe.joedayz.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.joedayz.thymeleaf.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

}
