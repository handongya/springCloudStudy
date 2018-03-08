package com.handy.dao;

import com.handy.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by handy18970 on 2018/3/8.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
