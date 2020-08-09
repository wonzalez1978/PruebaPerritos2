package cl.desafiolatam.appperritos.model;

import java.util.List;
import java.util.Map;

public class RazasLista {
    private String status;
    private Map<String, List<String>>message;




    public Map<String, List<String>> getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }


}
