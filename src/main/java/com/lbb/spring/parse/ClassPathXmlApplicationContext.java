package com.lbb.spring.parse;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements BeanFactory {

    private Map<String,Object> beans = new HashMap<>();

    public ClassPathXmlApplicationContext() throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
        Element root = doc.getRootElement();
        List list = root.getChildren("bean");
        for(int i=0;i<list.size();i++){
            Element element = (Element) list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");
            Object o = Class.forName(clazz).newInstance();  //利用反射创建实体类对象 ioc
            beans.put(id, o);

            //模拟di 自动注入
            for(Element propertryElement : (List<Element>) element.getChildren("property")){
                String name = propertryElement.getAttributeValue("name");
                String ref = propertryElement.getAttributeValue("ref");
                Object object = beans.get(ref); //为ref对象
                String methodName = "set" +name.substring(0,1).toUpperCase() +name.substring(1);
                Method method = o.getClass().getMethod(methodName, object.getClass().getInterfaces()[0]);
                method.invoke(o, object);
            }
        }
    }

    public Object getBean(String name) {
        return beans.get(name);
    }
}
