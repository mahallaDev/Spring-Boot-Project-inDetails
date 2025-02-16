package com.icicibank.produce.icicibankproduce.repository;

import com.icicibank.produce.icicibankproduce.entity.StudentInfoPojo;
import com.icicibank.produce.icicibankproduce.pojo.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentDetailsRepo extends JpaRepository<StudentInfo,String> {
    List<StudentInfo> findByStandardAndResult(String standard, String result);
//    StudentInfoPojo findById();
}
