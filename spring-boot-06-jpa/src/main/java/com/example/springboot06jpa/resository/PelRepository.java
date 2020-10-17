package com.example.springboot06jpa.resository;

import com.example.springboot06jpa.bean.Pel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PelRepository extends JpaRepository<Pel,Integer>{

}
