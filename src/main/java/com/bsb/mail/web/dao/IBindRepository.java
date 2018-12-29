package com.bsb.mail.web.dao;

import com.bsb.mail.model.Binding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: zeng
 * @Date: 2018-12-29
 */
@Repository
public interface IBindRepository extends JpaRepository<Binding, Long> {

    @Query("SELECT COUNT(ID) FROM Binding binding WHERE binding.username = :username AND binding.emailAddress = :emailAddress")
    Integer checkIfUserAlreadyBindThisEmail(@Param("username") String username, @Param("emailAddress") String emailAddress);

    @Query("SELECT COUNT(ID) FROM Binding binding WHERE binding.username = :username")
    Integer checkIfBind(@Param("username") String username);
}
