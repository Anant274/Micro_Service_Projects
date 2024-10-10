package com.nt.Repo;

import com.nt.Dto.UserDto;
import com.nt.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
