package proyecto;

public class Alumno {
    /*--------------------------------------------------------
     * Atributos
    *-----------------------------------------------------*/
    private String nombre;
    private String apellido;
    private int cédula;
    private String correo;
    private int telefono;
    private String semestre;
    
    /*-----------------------------------------------------------
    * Metodos
    *---------------------------------------------------------*/
    
   
    public  Alumno(String nombre,String apellido,int cedula,String correo,int telefono,String semestre){
        this.nombre=nombre;
        this.apellido=apellido;
        this.cédula=cedula;
        this.correo=correo;
        this.telefono=telefono;
        this.semestre=semestre; 
    }
    public Alumno(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cédula;
    }

    public void setCedula(int cédula) {
        this.cédula = cédula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
}
