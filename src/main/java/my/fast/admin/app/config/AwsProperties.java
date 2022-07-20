package my.fast.admin.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author lihaijian
 * @Date 2021-08-02 14:04
 */
@ConfigurationProperties(prefix = "s3.storage")
public class AwsProperties {

    private String accessKeyId;
    private String secretAccessKey;
    private String endpoint;
    private String bucketName;

    public String getAccessKeyId() {
        return accessKeyId;
    }
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }
    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    public String getEndpoint() {
        return endpoint;
    }
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    public String getBucketName() {
        return bucketName;
    }
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
