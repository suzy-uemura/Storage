package br.dh.meli.storage02.repository;

import br.dh.meli.storage02.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
