package com.imc.rpc;


import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.io.IOException;
import java.io.InputStream;

@SuiteDisplayName("Attachments")
public class AttachmentsTest {

    @Test
    void testAttachFileAsPdf() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("file.pdf")) {
            Allure.addAttachment("File-Файл-1.pdf", "application/pdf", is, "pdf");
        }

    }

    @Test
    void testAttachFileAsOctetStream() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("file.pdf")) {
            Allure.addAttachment("File-Файл-2.pdf", "application/octet-stream", is, "pdf");
        }

    }
}
