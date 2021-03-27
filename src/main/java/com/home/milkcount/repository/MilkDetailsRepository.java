package com.home.milkcount.repository;

import com.home.milkcount.model.Milk_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilkDetailsRepository extends JpaRepository<Milk_Details,String> {
}
