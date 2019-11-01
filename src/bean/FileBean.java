package bean;

import java.io.InputStream;

public class FileBean {
	
	public String fileName;
	public String filePath;
	public String encFileName;
	public String publicKey;
	public InputStream file;
	public InputStream fileTpa;
	public String hashCode;
	public int fk;
	
	
	public InputStream getFileTpa() {
		return fileTpa;
	}
	public void setFileTpa(InputStream fileTpa) {
		this.fileTpa = fileTpa;
	}
	public int getFk() {
		return fk;
	}
	public void setFk(int fk) {
		this.fk = fk;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public InputStream getFile() {
		return file;
	}
	public void setFile(InputStream file) {
		this.file = file;
	}
	public String getHashCode() {
		return hashCode;
	}
	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}
	public String getEncFileName() {
		return encFileName;
	}
	public void setEncFileName(String encFileName) {
		this.encFileName = encFileName;
	}
	
	
	
	

}
