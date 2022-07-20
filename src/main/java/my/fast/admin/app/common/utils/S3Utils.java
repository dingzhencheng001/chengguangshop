package my.fast.admin.app.common.utils;


import java.util.HashMap;
import java.util.Map;

public class S3Utils {

    public static String getFileType(String fileName){
        String fileType = "";
        int index = fileName.lastIndexOf(".");
        if( index!= -1){
            fileType = fileName.substring(index, fileName.length());
            if(fileType.length() > 0){
                fileType = fileType.substring(1);
            }
        }
        return fileType;
    }

    private final static Map<String, String> HTTPCONTENTTYPE = new HashMap<String, String>();

    static{
        HTTPCONTENTTYPE.put("txt", "text/plain");
        HTTPCONTENTTYPE.put("doc", "application/msword");
        HTTPCONTENTTYPE.put("docx", "application/msword");
        HTTPCONTENTTYPE.put("xls", "application/vnd.ms-excel");
        HTTPCONTENTTYPE.put("xlsx", "application/vnd.ms-excel");
        HTTPCONTENTTYPE.put("ppt", "application/vnd.ms-powerpoint");
        HTTPCONTENTTYPE.put("pptx", "application/vnd.ms-powerpoint");
        HTTPCONTENTTYPE.put("pdf", "application/pdf");
        HTTPCONTENTTYPE.put("png", "image/png");
        HTTPCONTENTTYPE.put("gif", "image/gif");
        HTTPCONTENTTYPE.put("ico", "image/x-ico");
        HTTPCONTENTTYPE.put("jpeg", "image/jpeg");
        HTTPCONTENTTYPE.put("jpe", "image/jpeg");
        HTTPCONTENTTYPE.put("jpg", "image/jpeg");
    }

    public static String getContentType(String fileType){
        String contentType = HTTPCONTENTTYPE.get(fileType);
        if(contentType == null){
            return "application/octet-stream";
        }
        return contentType;
    }



    public static void main(String[] args) {
        String fileName = "dsfsdfd.l.l.l.";
        System.out.println(getFileType(fileName));
    }
}

