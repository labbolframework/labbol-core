/**
 * 
 */
package com.labbol.core.model;

/**
 * 文件模型。
 * 
 * @author PengFei
 */
public abstract class BaseFileModel<M extends BaseFileModel<M>> extends BaseModel<M> {

	private static final long serialVersionUID = -1763937993496012613L;

	/**
	 * @param fileName 文件名称
	 */
	public abstract void setFileName(String fileName);

	/**
	 * @return 文件名称
	 */
	public abstract String getFileName();

	/**
	 * @param fileType 文件类型
	 */
	public abstract void setFileType(String fileType);

	/**
	 * @return 文件类型
	 */
	public abstract String getFileType();

	/**
	 * @param filePath 文件路径
	 */
	public abstract void setFilePath(String filePath);

	/**
	 * @return 文件路径
	 */
	public abstract String getFilePath();

	/**
	 * @param fileSize 文件大小 单位B(字节)
	 */
	public abstract void setFileSize(Long fileSize);

	/**
	 * @return 文件大小 单位B(字节)
	 */
	public abstract Long getFileSize();

}
