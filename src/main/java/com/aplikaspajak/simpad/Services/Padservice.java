package com.aplikaspajak.simpad.Services;

import com.aplikaspajak.simpad.Models.Padmodel;
import com.aplikaspajak.simpad.Repository.Padrepo;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Padservice {

  @Autowired
  private Padrepo padrepo;

  @Autowired
  private JdbcTemplate jdbctemplate;

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

  public List<Map<String, Object>> GetPad(Long id) {
    List<Map<String, Object>> query = jdbctemplate.queryForList(
      "select * from esptpd where id=",
      id
    );
    return query;
  }

  public List<Map<String, Object>> getAllPad() {
    String string =
      "select sum(jumlah) as jumlah,esptdp.nama from esptpd order by id";
    List<Map<String, Object>> resdata = jdbctemplate.queryForList(string);
    return resdata;
  }
}
