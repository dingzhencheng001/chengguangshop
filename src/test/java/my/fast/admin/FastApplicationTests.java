package my.fast.admin;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maxmind.geoip2.DatabaseReader;

import my.fast.admin.app.common.utils.IPUtils;
import my.fast.admin.app.entity.IPEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastApplicationTests {

    @Test
    public void contextLoads() {
        String str = "2.jpg";

        String[] split = str.split("\\.");

        String s = split[0];

        System.out.println(s);
    }

   /* @Test
    public void test01() throws Exception {
        // String path = req.getSession().getServletContext().getRealPath("/WEB-INF/classes/GeoLite2-City.mmdb");
        String path = "E:\\city\\GeoLite2-City.mmdb";
        // 创建 GeoLite2 数据库·
        File database = new File(path);
        // 读取数据库内容
        DatabaseReader reader = new DatabaseReader.Builder(database).build();
        // 访问IP
        String ip = "222.222.226.212";
        String site = "国家：" + GetAddress.getCountry(reader, ip) + "\n省份：" + GetAddress.getProvince(reader, ip) + "\n城市："
            + GetAddress.getCity(reader, ip) + "\n经度：" + GetAddress.getLongitude(reader, ip) + "\n维度："
            + GetAddress.getLatitude(reader, ip);
        System.out.println(site);

    }*/
   @Test
   public void fun() {
       IPEntity ipMsg = IPUtils.getIPMsg("203.144.74.187");
       System.out.println(ipMsg);
   }

}
