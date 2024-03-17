package br.edu.utfpr.upload;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



@Service
public class FileUploadService implements IFileUploadService {

	private final Path rootDir = Paths.get("uploads");

	@Override
	public void init() {
		try {
			File tempDir = new File(rootDir.toUri());

			boolean dirExists = tempDir.exists();

			if (!dirExists) {
				Files.createDirectories(rootDir);
			}

		} catch (IOException e) {
			throw new RuntimeException("Error creating directory ");
		}
	}

	@Override
	public void save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootDir.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("Error upload files ");
		}

	}

	
}
