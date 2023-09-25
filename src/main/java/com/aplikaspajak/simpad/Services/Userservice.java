package com.aplikaspajak.simpad.Services;

import com.aplikaspajak.simpad.Models.Estpdmodel;
import com.aplikaspajak.simpad.Models.UserModel;
import com.aplikaspajak.simpad.Repository.Userrepo;
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
public class Userservice {

  @Autowired
  protected Userrepo userepository;

  public Iterable<UserModel> findAll() {
    return userepository.findAll();
  }

  public UserModel save(UserModel esptpd) {
    return userepository.save(esptpd);
  }

  public UserModel update(UserModel esptpd, Long id) {
    return userepository.findById(id).get();
  }

  public UserModel findOne(Long id) {
    return userepository.findById(id).get();
  }

  public void delete(Long id) {
    userepository.deleteById(id);
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
      }
    }
    return uploadsuccess;
  }
}
