package com.lighthouse.mybatisplusgenerator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;

/**
 * @author gj
 * @description mybatis-plus逆向生存 提供controller、entity、service、impl、mapper、xml 6个文件生产
 *              官方文档地址 https://baomidou.com/pages/981406/#%E6%95%B0%E6%8D%AE%E5%BA%93%E9%85%8D%E7%BD%AE-datasourceconfig
 *              可根据官方文档信息 结合自己项目情况进行代码调整
 *              可以用的话star一下，感谢！
 * @date 2022/5/26 14:27
 */
public class Controller {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://数据库地址:3306/数据库名?useUnicode=true&useSSL=false&characterEncoding=utf8",
                        "用户名", "密码")
                .globalConfig(builder -> {
                    builder.author("gj") // 设置作者
                            .fileOverride() //文件覆盖
                            .outputDir("D:\\AutoGenerator"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.lighthouse") // 设置父包名
                            .mapper("dao")
                            .xml("dao.xml");
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .controllerBuilder()    //Controller 策略配置
                            .enableRestStyle()      //开启生成@RestController 控制器
                            .entityBuilder()        //Entity 策略配置
                            .idType(IdType.ASSIGN_ID) //自动加上雪花id生成
                            .enableLombok()         //开启lombok注解
                            .serviceBuilder()     //service策略配置
                            .formatServiceFileName("%sService") //格式化service名称
                            .mapperBuilder()        //mapper策略配置
                            .enableBaseResultMap()  //启用 BaseResultMap 生成
                            .enableBaseColumnList();  //启用 BaseColumnList
                })
                .execute();
    }

}
