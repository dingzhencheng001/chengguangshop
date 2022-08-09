//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package my.fast.admin.cg.common.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JsonYamlUtil {
    public static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";
    private static final ObjectMapper jsonMapper = new ObjectMapper();
    private static final ObjectMapper yamlMapper;
    private static final ObjectMapper jdk8JsonMapper;

    public JsonYamlUtil() {
    }

    public static ObjectMapper getJsonMapper() {
        return jsonMapper;
    }

    public static ObjectMapper getYamlMapper() {
        return yamlMapper;
    }

    public static ObjectMapper getJdk8JsonMapper() {
        return jdk8JsonMapper;
    }

    static {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonMapper.setDateFormat(df);
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        yamlMapper = new ObjectMapper(new YAMLFactory());
        DateFormat yamlDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        yamlMapper.setDateFormat(yamlDf);
        yamlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jdk8JsonMapper = new ObjectMapper();
        DateFormat jdk8Df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jdk8JsonMapper.setDateFormat(jdk8Df);
        jdk8JsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        jdk8JsonMapper.registerModule(javaTimeModule);
    }
}
