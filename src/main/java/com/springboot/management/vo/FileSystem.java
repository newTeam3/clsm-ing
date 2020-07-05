package com.springboot.management.vo;
/*
 *@Author 李恒彪
 * @date 2020/06/10
 *
 */

public class FileSystem {
    private String fileId;

    private String filePath;

    private long fileSize;

    private String fileName;

    private String fileType;

    public String getFileId() {
        return fileId;
    }

    public String getFilePath() {
        return filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
