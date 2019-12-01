package com.jcg.examples.repo;

import org.springframework.data.repository.CrudRepository;

import com.jcg.examples.entity.Address;

public interface AddressRepo extends CrudRepository<Address, Long>
{
}
