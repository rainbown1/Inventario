public class Auto {
    private String propietario;
    private String marca;
    private int matricula;
    private String estado;

    public Auto(String propietario, String marca, int matricula, String estado) {
        this.propietario = propietario;
        this.marca = marca;
        this.matricula = matricula;
        this.estado = estado;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getMarca() {
        return marca;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Propietario: " + propietario +
               ", Marca: " + marca +
               ", Matrícula: " + matricula +
               ", Estado: " + estado;
    }
}
