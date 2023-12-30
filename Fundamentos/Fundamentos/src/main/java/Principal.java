public class Principal {
    public static void main(String[] args){
        //Declarando una variable de tipo string
        String name = "Gabriel";
        //declarando una variable de tipo entero o numero
        int age = 32;
        //imprimiendo en pantalla por linea
        System.out.println("I'm " + name + " i have " + age + " age");
        int x = 5;
        int y = 6;
        System.out.println(x+y);
        //declarando multiples variables
        int a = 5, b = 3, c = 9;
        System.out.println(a + b + c);
        //Ampliacion de variable
        int myNum = 15;
        double myDouble = myNum;
        System.out.println(myNum);
        System.out.println(myDouble);
        //Estrechamiento de variable
        double myDouble2 = 9.72;
        int myNum2 = (int) myDouble2;
        System.out.println(myDouble2);
        System.out.println(myNum2);
        //Tamaño de una cadena de caracteres
        String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("The length of the txt string is: " + txt.length());
        //Cambiar entre mayusculas y minusculas
        String txt2 = "Hello World";
        System.out.println(txt2.toUpperCase());   // Outputs "HELLO WORLD"
        System.out.println(txt2.toLowerCase());   // Outputs "hello world"
        //Conocer la posicion de un string en un texto
        String txt3 = "Please locate where 'locate' occurs!";
        System.out.println(txt3.indexOf("locate")); // Outputs 7
        //concatenaciones en java
        String firstName = "John";
        String lastName = "Doe";
        System.out.println(firstName + " " + lastName);
        //metodo 2
        String firstName1 = "John ";
        String lastName1 = "Doe";
        System.out.println(firstName1.concat(lastName1));

    }
}
