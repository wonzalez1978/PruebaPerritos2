package cl.desafiolatam.appperritos.model;

import java.util.List;

public class RazaImagen {
    private List<String> message;
    private String status;

    public RazaImagen(List<String> message, String status) {
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
        return "RazaImagen{" +
                "message=" + message +
                ", status='" + status + '\'' +
                '}';
    }
}
