package my.fast.admin.app.entity;


public class FileInfo {
    /**
     * 文件id
     */
    private String id;
    /**
     * 存储路径
     */
    private String path;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件格式
     */
    private String fileFormat;

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FileInfo{" + "id='" + id + '\'' + ", path='" + path + '\'' + ", size=" + size + ", name='" + name + '\''
            + ", fileFormat='" + fileFormat + '\'' + '}';
    }
}
