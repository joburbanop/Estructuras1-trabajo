package proyecto;


import java.io.*;

import java.util.*;

public class Proyecto {
    /*------------------------------------------------------
     * Atributos
    *------------------------------------------------------- */
    //array necesario para almacenar los alumnos creados
    private static ArrayList <Alumno> alumnos=new ArrayList<Alumno>();
    private static String archivoEstudiantes;

    /*------------------------------------------------------
     * Metodos 
    *------------------------------------------------------- */
    public static void main(String[] args) throws IOException {
        Scanner lector = new Scanner(System.in);
        try {
            cargarInformacion("./data/reportePor.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("error de aca FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("error de aca IOException");
            e.printStackTrace();
        }
        //se crea una variable para controlar el ciclo 
        boolean activo=true;

        

        //creacion del ciclo con el fin de repetir el menu
        do {
            System.out.println("--------------------------------------------");
            System.out.println("¿que operaciones quieres hacer?");
            System.out.println("1.- Insertar alumno");
            System.out.println("2.- Eliminar alumno ");
            System.out.println("3.- Modificar alumno");
            System.out.println("4.- Consultar alumno");
            System.out.println("5.- generar  reporte por semestre ");
            System.out.println("6.- Terminar programa");
            System.out.println("-------------------------------------------");

            int opcion=lector.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("ingresa el nombre del alumno");
                    String nombre=lector.next();
                
                    System.out.println("ingresa el apellido del alumno");
                    String apellido=lector.next();

                    System.out.println("ingresa la cedula del alumno");
                    int cedula=lector.nextInt();

                    System.out.println("ingresa el correo del alumno");
                    String correo=lector.next();

                    System.out.println("ingresa el telefono del alumno");
                    int telefono=lector.nextInt();

                    System.out.println("ingresa el semestre del alumno");
                    String semestre=lector.next();     

                    agregarAlumno(nombre, apellido, cedula, correo, telefono, semestre);
                    break;
                case 2:
                    System.out.println("ingresa cedula del estudiante ha eliminar");
                    int cedulaAEliminar=lector.nextInt();
                    eliminarAlumno(cedulaAEliminar);
                    break;

                case 3:
                    System.out.println("Ingresa la cedula del estudiante a modificar");
                    int estudianteAEliminar=lector.nextInt();
                    modificarAlumno(estudianteAEliminar);
                    break;

                case 4:
                    consultarAlumno();
                    break;

                case 5:
                    System.out.println("ingresa el semestre de los estudiantes con los cuales se desea generar un reporte");
                    String semestreReporte=lector.next();
                    try {
                        generarReporte(semestreReporte);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    activo=false;
                default:
                    System.out.println("Ingrese un valor valido");
                    break;
            }
             
        } while (activo);
    }

    public static void agregarAlumno(String nombre, String apellido, int cedula, String correo, int telefono, String semestre){
        

                //creacion del objeto alumno 
                Alumno nuevoAlumno= new Alumno(nombre, apellido, cedula, correo, telefono, semestre);

                //almacenando alumnos en un ArrayList
                alumnos.add(nuevoAlumno);
    }

    public static void eliminarAlumno(int cedula){
        
        for (Alumno alumno : alumnos) {
            if (alumno.getCedula()==cedula) {
                alumnos.remove(alumno);
                System.out.println("alumno eliminado exitosamente");
            }
            
        }

    }
   
    public static void modificarAlumno(int cedula){
        boolean opcion=true;
        for (Alumno alumno : alumnos) {
            if (alumno.getCedula()==cedula) {
                Scanner lector=new Scanner(System.in);
               
                System.out.println("se cambiara la informacion del alumno "+alumno.getNombre());
                System.out.println("------------------------------------");
                
                do {
                    System.out.println("1.-cambiar nombre");
                    System.out.println("2.-cambiar telefono");
                    System.out.println("3.-cambiar correo");
                    System.out.println("4.-cambiar semestre");
                    System.out.println("5.- salir ");
                    int seleccion=lector.nextInt();

                    switch (seleccion) {
                        case 1:
                            System.out.println("ingresa el nuevo nombre del alumno");
                            String nombre=lector.next();
                            alumno.setNombre(nombre);
                            break;
                        case 2:
                            System.out.println("ingresa el nuevo telefono del alumno");
                            int telefono=lector.nextInt();
                            alumno.setTelefono(telefono);
                            break;
                        case 3:
                            System.out.println("ingresa el nuevo correo del alumno");
                            String correo=lector.next();
                            alumno.setCorreo(correo);
                            break;
                        case 4:
                            System.out.println("ingresa el nuevo semestre del alumno");
                            String semestre=lector.next();
                            alumno.setSemestre(semestre);
                            break;

                        case 5:
                            opcion=false;
                            break;
                        default:
                            System.out.println("seleccione una opcion correcta");
                            break;
                    }
                } while (opcion);
                break;
            } 
        }
        
        System.out.println("Alumno no encontrado");
            
    }

    public static void consultarAlumno(){
        for (Alumno alumno : alumnos) {
            System.out.println("nombre : "+alumno.getNombre());
            System.out.println("apellido : "+alumno.getApellido());
            System.out.println("cedula : "+alumno.getCedula());
            System.out.println("correo : "+alumno.getCorreo());
            System.out.println("telefono : "+alumno.getTelefono());
            System.out.println("semestre : "+alumno.getSemestre());
            System.out.println("-----------------------------------");
            System.out.println();
        }
    }

    public static void generarReporte(String semestre) throws IOException{
        File archivo= new File("./data/reportePor.txt");
        PrintWriter lapiz = new PrintWriter(new FileWriter(archivo, true));
        if (archivo.exists()) {
                if (archivo.length()<=0) {
                lapiz.println("============REPORTE POR SEMESTRE=============");
            }
            
            for (Alumno alumno : alumnos) {
                //System.out.println(semestre);
                //System.out.println("desde "+ alumno.getSemestre());
                //System.out.println(alumno.getSemestre().equals(semestre));
               
                if (alumno.getSemestre().equals(semestre) && !verificarContenidoArchivo(alumno.getCedula())){

                    lapiz.println("nombre: "+ alumno.getNombre());
                    lapiz.println("apellido: "+ alumno.getApellido());
                    lapiz.println("cedula: "+ alumno.getCedula());
                    lapiz.println("correo: "+ alumno.getCorreo());
                    lapiz.println("telefono: "+ alumno.getTelefono()); 
                    lapiz.println("semetre: "+alumno.getSemestre());      
                    lapiz.println("-------------------------");
                    lapiz.println("");       

                }
            }
        }
        
        lapiz.close();
        System.out.println("reporte generado exitosamente");
    }

    public static void cargarInformacion(String archivo) throws FileNotFoundException, IOException {
        archivoEstudiantes = archivo;
        File archivoAcargar = new File(archivoEstudiantes);
        if (archivoAcargar.length() != 0) {
            try (BufferedReader lector = new BufferedReader(new FileReader(archivoAcargar))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    if (linea.startsWith("nombre:")) {
                        String nombre = linea.substring(linea.indexOf(":") + 1);
                        String apellido = lector.readLine().substring(10);
                        int cedula = Integer.parseInt(lector.readLine().substring(8));
                        String correo = lector.readLine().substring(8);
                        int telefono = Integer.parseInt(lector.readLine().substring(10));
                        String semestre = lector.readLine().substring(9);
                        
                        Alumno nuevoAlumno = new Alumno(nombre, apellido, cedula, correo, telefono, semestre);
                        //System.out.println("cedula alumno: "+nuevoAlumno.getCedula());
                        alumnos.add(nuevoAlumno);
                    }
                }
            }
        } else {
            alumnos = new ArrayList<>();
        }
    }
    
    public static boolean verificarContenidoArchivo( int cedulaBuscar) throws FileNotFoundException, IOException{
        boolean cedulaEncontrada = false; // Variable para verificar si se encontró la cédula
        File archivoAcargar = new File("./data/reportePor.txt");
        
            try (BufferedReader lector = new BufferedReader(new FileReader(archivoAcargar))) {
                String linea;
                
                int cedula = 0;

                while ((linea = lector.readLine()) != null) {
                    if (linea.startsWith("cedula:")) {
                        cedula = Integer.parseInt(linea.substring(linea.indexOf(":") + 2));
                        // Verifica si la cédula coincide con la que estás buscando
                        if (cedula == cedulaBuscar) {
                            cedulaEncontrada = true;
                            break;
                        }
                    } 
                    }
                }

        return cedulaEncontrada;
    }  
}
