package modelo;

public enum Apellido {

    RODRIGUEZ("Rodríguez",1),
    MARTINEZ("Martínez",2),
    GARCIA("García",3),
    GOMEZ("Gómez",4),
    LOPEZ("López",5),
    GONZALEZ("González",6),
    HERNANDEZ("Hernández",7),
    SANCHEZ("Sánchez",8),
    PEREZ("Pérez",9),
    RAMIREZ("Ramírez",10),
    DIAZ("Díaz",11),
    TORRES("Torres",12),
    MUNOZ("Muñoz",13),
    ROJAS("Rojas",14),
    MORENO("Moreno",15),
    VARGAS("Vargas",16),
    ORTIZ("Ortiz",17),
    JIMENEZ("Jiménez",18),
    CASTRO("Castro",19),
    GUTIERREZ("GUtiérrez",20),
    ALVAREZ("Álvarez",21),
    VALENCIA("Valencia",22),
    RUIZ("Ruiz",23),
    SUAREZ("SUárez",24),
    HERRERA("Herrera",25),
    BORJA("Borja",26),
    CAICEDO("Caicedo",27),
    LEON("León",28),
    BERNAL("Bernal",29),
    LOAIZA("loaiza",30),
    CANO("Cano",31),
    CASTILLO("Castillo",32),
    FRANCO("Farnco",33),
    MIRANDA("Miranda",34),
    MOSQUERA("Mosquera",35),
    MURILLO("Murillo",36),
    ANDRADE("Andrade",37),
    VILLA("Villa",38),
    MONTERO("Montero",39),
    PALACIOS("Palacios",40),
    FLOREZ("Flórez",41),
    BLANCO("Balnco",42),
    RAMOS("Ramos",43),
    RINCON("Rincón",44),
    MADRID("Madrid",45),
    CASTANO("Castaño",46),
    PARDO("Pardo",47),
    GALARGA("Galarga",48),
    CAMELA("Camela",49),
    NITO("Nito",50),
    RUBIO("Rubio",51),
    RIOS("Ríos",52),
    MARIN("Martín",53),
    GIRALDO("Giraldo",54),
    GUERRA("Guerra",55),
    RESTREPO("Restrepo",56),
    ZULUAGA("Zuluaga",57),
    DUQUE("Duque",58),
    URIBE("Uribe",59),
    PETRO("Petro",60),
    HOYOS("Hoyos",61),
    FERNANDEZ("Fernández",62),
    GARRO("Garro",63),
    CABAL("Cabal",64),
    PINEDA("Pineda",65),
    MELANO("Melano",66),
    DUARTE("Duarte",67),
    PEDROZA("Pedroza",68),
    PARRA("Parra",69),
    RENDON("Rendón",70);

    private String nombre;
    private int id;
    Apellido(String nombre, int id){
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre(int id){
        for(Apellido nombre: values()){
            if (nombre.id == id){
                return nombre.nombre;
            }
        }
        return "Guzmán";
    }
}

