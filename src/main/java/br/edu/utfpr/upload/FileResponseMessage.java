package br.edu.utfpr.upload;



import org.springframework.stereotype.Component;

@Component
public class FileResponseMessage {
    
    private String message;

    public FileResponseMessage() {
    }

    public FileResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}