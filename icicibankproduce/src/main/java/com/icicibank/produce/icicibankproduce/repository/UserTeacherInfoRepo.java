package com.icicibank.produce.icicibankproduce.repository;

import com.icicibank.produce.icicibankproduce.entity.Userteacherinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserTeacherInfoRepo extends JpaRepository<Userteacherinfo,String> {

    List<Userteacherinfo> findByEmailidAndPassword(String email, String password);
}
