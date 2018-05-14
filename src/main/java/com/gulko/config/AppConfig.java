package com.gulko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
@ComponentScan("com.gulko")
public class AppConfig extends WsConfigurerAdapter {
    @Bean(name = "name")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema nameSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("NamePort");
        wsdl11Definition.setLocationUri("/soapws");
        wsdl11Definition.setTargetNamespace("http://gulko.com/soap");
        wsdl11Definition.setSchema(nameSchema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema nameSchema() {
        return new SimpleXsdSchema(new ClassPathResource("name.xsd"));
    }
}
