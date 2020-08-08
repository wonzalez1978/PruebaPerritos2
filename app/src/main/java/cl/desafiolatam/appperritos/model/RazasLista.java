package cl.desafiolatam.appperritos.model;

import java.util.List;

public class RazasLista {
    private List<String> message;
    private String status;

    public RazasLista(List<String> message, String status) {
        this.message = message;
        this.status = status;
    }

    public List<String> getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "RazasLista{" +
                "message=" + message +
                ", status='" + status + '\'' +
                '}';
    }
}
