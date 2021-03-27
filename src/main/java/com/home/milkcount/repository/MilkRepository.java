package com.home.milkcount.repository;

import com.home.milkcount.model.Milks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilkRepository extends JpaRepository<Milks,String> {
}
