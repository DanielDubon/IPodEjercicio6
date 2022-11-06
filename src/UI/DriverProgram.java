package UI;

import java.util.Scanner;

import Controller.*;
import Model.ICancion;
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


        while (simulation) {
            ipodUI(ipod);

            System.out.println("Que desea realizar?");
            System.out.println("0)Agregar cancion");
            System.out.println("1)Subir volumen");
            System.out.println("2)Bajar volumen");
            System.out.println("3)Cancion siguiente");
            System.out.println("4)Cancion anterior");
            System.out.println("5)Guardar cancion en favoritas");
            System.out.println("6)Reproducir cancion de favoritas");
            System.out.println("7)Boton de encendido/apagado");
            System.out.println("8)Boton de bloqueo/desbloqueo");
            System.out.println("9)Mostrar Status de Ipod");
            System.out.println("10)Eliminar cancion");
            System.out.println("11)Eliminar favorita");
            System.out.println("12)Pausar/Reproducir");



                String seleccion = in.nextLine();
                int opcion=12;
                try {
                    opcion = Integer.parseInt(seleccion);
                }catch (Exception e){
                    System.out.println("Valor invalido");
                }

                if (ipod.isOn() && !(ipod.isIsblocked())) {
                    switch (opcion) {
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
                            nextsong(ipod);
                            break;


                        case 4:
                            previoussong(ipod);
                            break;
                        case 5:


                            addSongtofavorites(ipod, in);

                            break;

                        case 6:
                            playfavsong(ipod, in);
                            break;

                        case 11:
                            deletefav(ipod,in);
                            break;
                        case 12:
                            pausebutton(ipod);


                    }
                }

                switch (opcion) {
                    case 7:
                        ipod.SwitchONOFF(ipod.isOn());
                        break;
                    case 8:
                        if (ipod.isOn()) {
                            ipod.LockUnlockDevice(ipod.isIsblocked());
                        }
                        break;
                    case 9:
                        if (ipod.isOn()) {
                            System.out.println(ipod.getStatus(ipod.isOn(), ipod.isIsblocked(), ipod.isPlaying(), ipod.getCanciones().get(ipod.getActualIndex())));

                        } else {
                            System.out.println("Apagado");
                        }
                        break;
                    case 10:
                        if (ipod.isOn() && !(ipod.isIsblocked())) {
                            deleteSong(ipod, in);
                        }
                        break;

                }

        }


    }
}
