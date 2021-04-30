package web.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UtilCrypto {
    public static String publicKey() throws IOException {
        return read("/home/nika/vertx-jwt/src/main/resources/keys/public_key.pem");
    }

    public static String privateKey() throws IOException {
        return read("/home/nika/vertx-jwt/src/main/resources/keys/private_key.pem");
    }

    private static String read(String file) throws IOException {

        Path path = Paths.get(file);
        final List<String> elements = Files.readAllLines(path, StandardCharsets.UTF_8);
        return String.join("\n", elements);
    }
}
