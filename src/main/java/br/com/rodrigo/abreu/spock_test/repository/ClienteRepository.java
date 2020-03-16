package br.com.rodrigo.abreu.spock_test.repository;

import br.com.rodrigo.abreu.spock_test.entity.Cliente;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepositoryImplementation<Cliente, Long> {

}
