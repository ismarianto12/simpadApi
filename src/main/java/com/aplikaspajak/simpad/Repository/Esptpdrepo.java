package com.aplikaspajak.simpad.Repository;

import com.aplikaspajak.simpad.Models.Estpdmodel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Esptpdrepo extends CrudRepository<Estpdmodel, Long> {
  @Query(value = "select * from esptpd where id=?", nativeQuery = true)
  List<Estpdmodel> findByidData(Long parmeterid);

  @Query(value = "select * from esptpd where id=?", nativeQuery = true)
  List<Estpdmodel> findByidWpBayar(Long parmeterid);
}
