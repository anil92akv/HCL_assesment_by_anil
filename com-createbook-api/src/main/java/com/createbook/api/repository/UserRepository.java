package com.createbook.api.repository;

import com.createbook.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;

@Repository public interface UserRepository extends JpaRepository<User,Integer> {
                @Query("select u from User u where u.username=:Username")
                public int findCustomer(@Param("Username") String username)

        }
