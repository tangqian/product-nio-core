package com.netwaymedia.nio.core;

import java.io.File;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

import com.netwaymedia.nio.core.netty.NioServer;
import com.netwaymedia.nio.core.user.listener.UserListener;

public class NioMain {
	
	public static final String ROOT;
	
	private static final String LOGBACK_PATH;
	
	static{
		String baseClassesPath = NioMain.class.getResource("/").getPath();
		if(baseClassesPath.endsWith("classes/")){
			baseClassesPath = baseClassesPath.substring(0, baseClassesPath.length() - 8);
		}
		if(new File(baseClassesPath + "ext_conf/").isDirectory()){//正式环境根路径
			ROOT = baseClassesPath;
		}else{//eclipse开发环境中的路径
			ROOT = baseClassesPath + "deploy/";
		}
		LOGBACK_PATH = ROOT + "ext_conf/logback.xml";
		System.out.println(ROOT);
		System.out.println(LOGBACK_PATH);
	}

	public static void main(String[] args) {
		initLogconfig();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-jdbc.xml");
		NioServer server = new NioServer();
		server.bind();
		UserListener listener = ctx.getBean(UserListener.class);
		listener.test();
		try {
			Thread.sleep(600000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void initLogconfig(){
        try {
            LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
            loggerContext.reset();
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.setContext(loggerContext);
            joranConfigurator.doConfigure(LOGBACK_PATH);
        }
        catch (JoranException e) {
        	System.out.println(e);
        	System.out.println("Load logback configuration file error.");
        }
	}
}
