package cn.ruiyeclub.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Ray。
 * @date 2020/8/8 18:25
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("cn.ruiyeclub.user.mapper")
@EnableDiscoveryClient
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
