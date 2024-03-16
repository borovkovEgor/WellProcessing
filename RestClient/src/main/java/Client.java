import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        final String wellNumber = "34-н";

        //registerSensor(wellNumber);

        float wellLevel = 2.3F;
        float mineralization = 0.75F;
        float temperature = 6.4F;
        float pH = 6.8F;
        float Na = 4.2F;
        float Ca = 3.1F;
        float Mg = 3.3F;
        float SO4 = 4.6F;
        float HCO3 = 28.3F;

         sendMeasurement(wellLevel, mineralization, temperature, pH, Na, Ca, Mg, SO4, HCO3, wellNumber);
    }

    private static void registerSensor(String wellNumber) {
        final String url = "http://localhost:8080/wells/registration";

        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("number", wellNumber);

        makePostRequestWithJSONData(url, jsonData, "well");
    }

    private static void sendMeasurement(float wellLevel, float mineralization, float temperature, float pH, float Na,
                                        float Ca, float Mg, float SO4, float HCO3, String wellNumber
    ) {
        final String url = "http://localhost:8080/measurements/add";

        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("wellLevel", wellLevel);
        jsonData.put("mineralization", mineralization);
        jsonData.put("temperature", temperature);
        jsonData.put("pH", pH);
        jsonData.put("na", Na);
        jsonData.put("ca", Ca);
        jsonData.put("mg", Mg);
        jsonData.put("so4", SO4);
        jsonData.put("hco3", HCO3);
        jsonData.put("well", Map.of("number", wellNumber));

        makePostRequestWithJSONData(url, jsonData, "");
    }

    private static void makePostRequestWithJSONData(String url, Map<String, Object> jsonData, String typeRequest) {
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(jsonData, headers);

        String messageWell = "Скважина добавлена на сервер!";
        String messageMeasurement = "Измерения успешно отправлены на сервер!";

        try {
            restTemplate.postForObject(url, request, String.class);

            if (typeRequest.isEmpty()) {
                System.out.println(messageMeasurement);
            } else {
                System.out.println(messageWell);
            }

        } catch (HttpClientErrorException e) {
            System.out.println("ОШИБКА!");
            System.out.println(e.getMessage());
        }
    }
}