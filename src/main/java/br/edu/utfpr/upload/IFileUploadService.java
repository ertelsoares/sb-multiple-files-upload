package br.edu.utfpr.upload;


import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadService {
  public void init();
  
  public void save(MultipartFile file);
  
  
}
