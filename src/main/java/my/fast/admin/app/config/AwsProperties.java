package my.fast.admin.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author cg
 * @Date 2021-08-02 14:04
 */
@ConfigurationProperties(prefix = "s3.storage")
public class AwsProperties {

    private String accessKeyId;
    private String secretAccessKey;
    private String endpoint;
    private String bucketName;
    private String region;
    private String sdkVersion;
    private String storageFilePath;
    private String cdn;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getStorageFilePath() {
        return storageFilePath;
    }

    public void setStorageFilePath(String storageFilePath) {
        this.storageFilePath = storageFilePath;
    }

    public String getCdn() {
        return cdn;
    }

    public void setCdn(String cdn) {
        this.cdn = cdn;
    }

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
