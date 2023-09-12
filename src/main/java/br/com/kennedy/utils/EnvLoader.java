package br.com.kennedy.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {
    public static void loadEnv() {
        String rootDirectory = System.getProperty("user.dir");
        String envFilePath = rootDirectory + "/.env";
        Dotenv dotenv = Dotenv.configure().directory(envFilePath).load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
    }
}