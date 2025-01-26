package modelo;

public enum Nombre {

    ESTEBAN("Esteban", 1),
    SERGIO("Sergio", 2),
    ANDRES("Andrés",3),
    ANTONIO("Antonio",4),
    MARCOS("Marcos",5),
    RUBEN("Rubén",6),
    DAVID("David",7),
    JESUS("Jesús",8),
    FERNANDO("Fernando",9),
    DANIEL("Daniel",10),
    DANIELA("Daniela",11),
    CAMILA("Camila",12),
    MARIA("María",13),
    JULIA("Julia",14),
    CARMEN("Carmen",15),
    SANTIAGO("Santiago",16),
    PABLO("Pablo",17),
    PAULINA("Paulina",18),
    ROSA("Rosa",19),
    ALEJANDRA("Alejandra",20),
    VICTOR("Víctor",21),
    MANUELA("Manuela",22),
    MANUEL("Manuel",23),
    MATEO("Mateo",24),
    LUIS("Luis",25),
    VALENTINA("Valentina",26),
    VALERIA("Valeria",27),
    ANDERSON("Ánderson",28),
    EUGENIO("Eugenio",29),
    RODRIGO("Rodrigo",30),
    MARIANA("Mariana",31),
    CATALINA("Catalina",32),
    JOSE("José",33),
    CARLOS("Carlos",34),
    HERNANDO("Hernando",35),
    MARTIN("Martín",36),
    ANGELA("Ángela",37),
    EDNA("Edna",38),
    BRYAN("Bryan",39),
    XIMENA("Ximena",40),
    SARA("Sara",41),
    ESTELA("Estela",42),
    ELENA("Elena",43),
    ELVER("Elver",44),
    DIEGO("Diego",45),
    MARTA("Elver",46),
    GLORIA("Gloria",47),
    DIANA("Diana",48),
    LUISA("Luisa",49),
    SANDRA("Sandra",50),
    ALEXANDER("Alexander",51),
    EMILIANO("Emiliano",52),
    JUAN("Juan",53),
    JOAQUIN("Joaquín",54),
    VERONICA("Verónica",55),
    ROBERTO("Roberto",56),
    RICARDO("Ricardo",57),
    SEBASTIAN("Sebastián",58),
    ANA("Ana",59),
    LAURA("Laura",60),
    ROXANA("Roxana",61),
    JACOBO("Jacobo",62),
    RAUL("Raúl",63),
    GUSTAVO("Gustavo",64),
    LUCIANA("Luciana",65),
    GERARDO("Gerardo",66),
    GUILLERMO("Guillermo",67),
    FRANCISCO("Francisco",68),
    BENITO("Benito",69),
    SUSANA("Susana",70);

    private String nombre;
    private int id;
    Nombre(String nombre, int id){
        this.id = id;
        this.nombre = nombre;
    }

    public static String getNombre(int id){
        for(Nombre nombre: values()){
            if (nombre.id == id){
                return nombre.nombre;
            }
        }
        return "Jaime";
    }
}