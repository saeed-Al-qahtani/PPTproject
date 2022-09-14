package com.example.ppt.Repository;

import com.example.ppt.model.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support,Integer> {
    Support findSupportById(Integer id);

}
