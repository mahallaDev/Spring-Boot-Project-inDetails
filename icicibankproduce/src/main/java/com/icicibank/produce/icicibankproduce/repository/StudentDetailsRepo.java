package com.icicibank.produce.icicibankproduce.repository;

import com.icicibank.produce.icicibankproduce.entity.StudentInfoPojo;
import com.icicibank.produce.icicibankproduce.pojo.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailsRepo extends JpaRepository<StudentInfo,String> {
//    StudentInfoPojo findById();
}
