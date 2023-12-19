package com.aplikaspajak.simpad.Services;

import com.aplikaspajak.simpad.Models.Padmodel;
import com.aplikaspajak.simpad.Models.Tmwajib_pajakmodel;
import com.aplikaspajak.simpad.Repository.Tmwajibpajakrepo;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Tmwajibpajakservice {

  @Autowired
  private Tmwajibpajakrepo padrepo;

  private JdbcTemplate jdbctemplate;

  public void removeOne(Long id) {
    padrepo.deleteById(id);
  }

  public List<Map<String, Object>> getAllPad() {
    String query =
      "SELECT SUM(jumlah) AS jumlah, esptdp.nama FROM esptpd GROUP BY esptdp.nama ORDER BY esptdp.id";
    List<Map<String, Object>> resdata = jdbctemplate.queryForList(query);
    return resdata;
  }

  public Iterable<Tmwajib_pajakmodel> findAll() {
    return padrepo.findAll();
  }
  // Additional methods if needed
  //   public void save(Tmwajib_pajakmodel pad) {
  //     return padrepo.save();
  //   }

  //   public Padmodel findOne(Long id) {
  //     return padrepo.findById(id).orElse(null);
  //   }

  //   public Iterable<Padmodel> findAll() {
  //     return padrepo.findAll();
  //   }
}
