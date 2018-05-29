package com.github.adamzink.springbootmysqldemo.repository;

import com.github.adamzink.springbootmysqldemo.model.db.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
