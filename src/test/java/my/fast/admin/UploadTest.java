package my.fast.admin;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;

public class UploadTest {

    //AmazonS3 s3;
    //String AWS_ACCESS_KEY = "4H742JA6U3TR5OICBEJM"; // 【你的 access_key】
    //String AWS_SECRET_KEY = "pZMMiIxC0gK0LdIL9H1D5Ha+1B5o79xJSkLy947AebE"; // 【你的 aws_secret_key】

    String bucketName = "ppp"; // 【你 bucket 的名字】 # 首先需要保证 s3 上已经存在该存储桶

    public static final String AWS_ACCESS_KEY = "4H742JA6U3TR5OICBEJM";
    public static final String AWS_SECRET_KEY = "pZMMiIxC0gK0LdIL9H1D5Ha+1B5o79xJSkLy947AebE";
    private static final AmazonS3Client s3;

    static {
        s3 = new AmazonS3Client(new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY));
        s3.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_3)); // 此处根据自己的 s3 地区位置改变
    }

    public String uploadToS3(File tempFile, String remoteFileName) throws IOException {
        try {
            String bucketPath = bucketName ;
            s3.putObject(new PutObjectRequest(bucketPath, remoteFileName, tempFile)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
            GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(bucketName, remoteFileName);
            URL url = s3.generatePresignedUrl(urlRequest);
            return url.toString();
        } catch (AmazonServiceException ase) {
            ase.printStackTrace();
        } catch (AmazonClientException ace) {
            ace.printStackTrace();
        }
        return null;
    }

    @Test
    public void test() throws IOException {
        File uploadFile = new File("E:\\fl\\1.jpg");
        String uploadKey = "test";
        uploadToS3(uploadFile,uploadKey);
    }
}
