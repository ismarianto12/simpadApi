package com.aplikaspajak.simpad.Services;

import com.aplikaspajak.simpad.Models.Estpdmodel;
import com.aplikaspajak.simpad.Repository.Esptpdrepo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class Esptpdservice {

  @Autowired
  protected Esptpdrepo esptpdrepository;

  public Iterable<Estpdmodel> findAll() {
    return esptpdrepository.findAll();
  }

  public Estpdmodel save(Estpdmodel esptpd) {
    return esptpdrepository.save(esptpd);
  }

  public Estpdmodel update(Estpdmodel esptpd, Long id) {
    return esptpdrepository.findById(id).get();
  }

  public Estpdmodel findOne(Long id) {
    return esptpdrepository.findById(id).get();
  }

  public void delete(Long id) {
    esptpdrepository.deleteById(id);
  }

  public boolean uploadSptpd(String exampletoken, MultipartFile file) {
    boolean uploadsuccess = false;
    String fileName = "File_Sptpd";
    if (!file.isEmpty()) {
      try {
        String type = file.getOriginalFilename().split("\\.")[1];
        BufferedOutputStream stream = new BufferedOutputStream(
          new FileOutputStream(new File("./uploads/" + fileName + "." + type))
        );
        FileCopyUtils.copy(file.getInputStream(), stream);
        stream.close();
        uploadsuccess = true;
      } catch (Exception e) {
        System.err.println(e);
        uploadsuccess = false;
        System.out.println(e.getMessage());
      }
    }
    return uploadsuccess;
  }
}
