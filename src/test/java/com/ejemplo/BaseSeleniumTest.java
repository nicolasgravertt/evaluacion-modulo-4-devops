package com.ejemplo;

import org.junit.jupiter.api.BeforeAll;

public abstract class BaseSeleniumTest {

    private static boolean serverStarted = false;

    @BeforeAll
    static void startServer() throws Exception {
        if (!serverStarted) {
            Thread thread = new Thread(() -> Application.main(new String[]{}));
            thread.setDaemon(true);
            thread.start();

            // Esperar que levante el servidor (ajusta si es necesario)
            Thread.sleep(4000);

            serverStarted = true;
        }
    }
}