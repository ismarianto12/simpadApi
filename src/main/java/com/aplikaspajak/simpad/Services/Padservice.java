package com.aplikaspajak.simpad.Services;

import com.aplikaspajak.simpad.Models.Padmodel;
import com.aplikaspajak.simpad.Repository.Padrepo;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Padservice {

  @Autowired
  private Padrepo padrepo;

  public Padmodel save(Padmodel pad) {
    return padrepo.save(pad);
  }

  public Padmodel findOne(Long id) {
    return padrepo.findById(id).get();
  }

  public Iterable<Padmodel> findAll() {
    return padrepo.findAll();
  }

  public void removeOne(Long id) {
    padrepo.deleteById(id);
  }
}
