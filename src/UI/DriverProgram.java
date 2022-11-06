package UI;

import java.util.Scanner;

import Controller.*;
import Model.Ipod;

import static Controller.Actions.*;

public class DriverProgram {
    private static boolean simulation = true;

    public static void main(String[] args) throws Exception {

        simulation();

    }


    public static void  simulation() throws Exception {
        Ipod ipod = new Ipod();
        System.out.println("-BIENVENIDO A LA SIMULACION DEL IPOD-");
        Scanner in = new Scanner(System.in);


        while (simulation){
            System.out.println("¿Que desea realizar?");
            System.out.println("0)Agregar cancion");
            System.out.println("1)Subir volumen");
            System.out.println("2)Bajar volumen");
            System.out.println("3)Cancion siguiente");
            System.out.println("4)Cancion anterior");
            System.out.println("5)Guardar cancion en favoritas");
            System.out.println("6)Reproducir cancion de favoritas");
            System.out.println("7)Boton de encendido/apagado");
            System.out.println("8)Boton de bloqueo/desbloqueo");
            int opcion = in.nextInt();


            switch (opcion){
                case 0:
                    addSong(ipod, in);
                    break;
                case 1:
                    volumeup(ipod);
                    break;

                case 2:
                    volumedown(ipod);
                    break;

                case 3:

            }
        }

    }



}
