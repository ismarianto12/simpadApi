package com.aplikaspajak.simpad.Repository;

import com.aplikaspajak.simpad.Models.Tmwajib_pajakmodel;
import java.lang.Long;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tmwajibpajakrepo
  extends CrudRepository<Tmwajib_pajakmodel, Long> {}
