package com.aplikaspajak.simpad.Repository;

import com.aplikaspajak.simpad.Models.Estpdmodel;
import com.aplikaspajak.simpad.Models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface Userrepo extends CrudRepository<UserModel, Long> {}
