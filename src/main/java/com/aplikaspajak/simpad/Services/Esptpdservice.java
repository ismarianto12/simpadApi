package com.aplikaspajak.simpad.Services;

import com.aplikaspajak.simpad.Models.Estpdmodel;
import com.aplikaspajak.simpad.Repository.Esptpdrepo;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Esptpdservice {

  @Autowired
  protected Esptpdrepo esptpdrepository;

  public Iterable<Estpdmodel> getAll() {
    return esptpdrepository.findAll();
  }

  public Estpdmodel save(Estpdmodel esptpd) {
    return esptpdrepository.save(esptpd);
  }

  public Estpdmodel update(Estpdmodel esptpd, Long id) {
    return esptpdrepository.findById(id).get();
  }

  public void delete(Long id) {
    esptpdrepository.deleteById(id);
  }
}
