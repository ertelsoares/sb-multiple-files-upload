package br.edu.utfpr.upload;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/files")
public class FileUploadController {
	private final IFileUploadService fileUploadService;
	
	public FileUploadController(IFileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }
	 @PostMapping("/upload-files")
	public ResponseEntity<FileResponseMessage> uploadFile(@RequestParam("file") MultipartFile[] files){
		String message = null;
		try {
			List<String> fileNames = new ArrayList<>();
			Arrays.stream(files).forEach(file ->{
				fileUploadService.save(file);
				fileNames.add(file.getOriginalFilename());
			});
			
			message = "File(s) upload sucessfully " + fileNames;
			
			return ResponseEntity.status(OK).body(new FileResponseMessage(message));
			
		} catch (Exception e) {
			 return ResponseEntity.status(EXPECTATION_FAILED).body(new FileResponseMessage(e.getMessage()));
		}
	}

}
