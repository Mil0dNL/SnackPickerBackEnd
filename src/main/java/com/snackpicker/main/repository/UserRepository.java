package com.snackpicker.main.repository;

import com.snackpicker.main.model.SnackUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SnackUser, Long> {
}
