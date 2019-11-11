package com.fangzhou.asongmanager.Service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public String saveFile(MultipartFile file, String extension);
    public int getFileType(MultipartFile file);
    public String uploadFile(byte[] bytes, long fileSize, String extension);
    public byte[] downloadFile(String fileUrl);
}
