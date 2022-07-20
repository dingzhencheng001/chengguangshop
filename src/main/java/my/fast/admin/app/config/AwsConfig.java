package my.fast.admin.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * @Author lihaijian
 * @Date 2021-08-02 14:07
 */
@Configuration
@EnableConfigurationProperties(AwsProperties.class)
public class AwsConfig {
    @Autowired
    AwsProperties awsProperties;

    @Bean
    AmazonS3 s3Client() {
        //设置连接时的参数
        ClientConfiguration config = new ClientConfiguration();
        //设置连接方式为HTTP，可选参数为HTTP和HTTPS
        config.setProtocol(Protocol.HTTP);
        //设置网络访问超时时间
        config.setConnectionTimeout(5000);
        config.setUseExpectContinue(true);
        //获取访问凭证
        AWSCredentials credentials = null;
        credentials = new BasicAWSCredentials(awsProperties.getAccessKeyId(),awsProperties.getSecretAccessKey());

        //设置Endpoint
        AwsClientBuilder.EndpointConfiguration end_point = null;
        end_point = new AwsClientBuilder.EndpointConfiguration(awsProperties.getEndpoint(), "");

        return AmazonS3ClientBuilder.standard()
               .withCredentials(new AWSStaticCredentialsProvider(credentials))
               .withClientConfiguration(config)
               .withEndpointConfiguration(end_point)
               .withPathStyleAccessEnabled(true).build();
    }

}

