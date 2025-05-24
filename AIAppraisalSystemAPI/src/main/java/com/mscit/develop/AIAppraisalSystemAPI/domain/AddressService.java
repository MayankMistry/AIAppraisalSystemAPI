package com.mscit.develop.AIAppraisalSystemAPI.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mscit.develop.AIAppraisalSystemAPI.model.Address;

@Repository
public interface AddressService extends JpaRepository<Address, Long> {

}
