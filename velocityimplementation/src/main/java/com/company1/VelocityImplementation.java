package com.company1;


import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

public class VelocityImplementation {
    public static void main(String[] args) {
        try{
            VelocityEngine ve=new VelocityEngine();         //gets an engine
            ve.init();          //initalizes the engine
            /*Properties p = new Properties();
            p.setProperty("resource.loader", "class");
            p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");*/
            Template t= ve.getTemplate("/src/main/resources/Helloworld.html");        //gets the template
            VelocityContext velocityContext=new VelocityContext();      //creates a context and adds data
            velocityContext.put("name","world");

            Writer write = new FileWriter(new File("./src/main/resources/hello-world.html"));
            Velocity.mergeTemplate("./src/main/resources/Helloworld.html", "UTF-8", velocityContext, write);
            write.flush();
            write.close();
            /*StringWriter sw=new StringWriter();             //renders the template into StringWriter
            t.merge(velocityContext,sw);
            System.out.println(sw.toString());*/
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
