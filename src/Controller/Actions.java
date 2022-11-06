package Controller;

import Model.Cancion;
import Model.ICancion;
import Model.Ipod;

import java.util.ArrayList;
import java.util.Scanner;

public class Actions {

    public static void addSongtofavorites(Ipod ipod,Scanner in) throws Exception {

        if (!(ipod.getCanciones().isEmpty())) {
            if (!(ipod.getFavs().size() == 10)) {
                try {

                    System.out.println("¿Que cancion desea agregar a sus favoritas?");
                    int i = 1;
                    for (ICancion cancion : ipod.getCanciones()) {
                        System.out.println(i + ") Titulo: " + cancion.getTitle() + " Artista: " + cancion.getArtist());
                        i++;
                    }
                    System.out.println("Ingrese numero de la lista: ");
                    int index = in.nextInt();
                    in.nextLine();
                    ICancion cancion = ipod.getCanciones().get(index - 1);
                    boolean duplicada = false;
                    for (ICancion cancion1 : ipod.getFavs()) {
                        if (cancion1 == cancion){
                            duplicada = true;
                        }
                    }
                    if (!(duplicada)) {
                        ipod.addToFavorite(cancion);
                    }else {
                        System.out.println("Cancion ya en top 10");
                    }

                } catch (Exception exception) {
                    System.out.println("Error al agregar cancion");
                }
            }else {
                System.out.println("Maximo de 10 canciones alcanzado en lista de favoritas");
            }
        }else {
            System.out.println("Alerta: No hay canciones agregue una");
        }

    }

    public static void volumeup(Ipod ipod){
        try {
            if (!(ipod.getVolume() == 10f)){
                ipod.setVolume(ipod.getVolume()+0.5f);
                System.out.println("Volumen actual: "+ipod.getVolume());
            }else {
                System.out.println("Volumen maximo alcanzado");
            }

        }catch (Exception e){

        }
    }

    public static void volumedown(Ipod ipod){
        try {
            if (!(ipod.getVolume() == 0f)){
                ipod.setVolume(ipod.getVolume()-0.5f);
                System.out.println("Volumen actual: "+ipod.getVolume());
            }else {
                System.out.println("Volumen minimo alcanzado");
            }

        }catch (Exception e){

        }
    }

    public static void addSong(Ipod ipod, Scanner in) throws Exception {

        if(!(ipod.getCanciones().size() == 50)) {
            System.out.println("Titulo de la cancion: ");
            String titulo = in.nextLine();
            System.out.println("Artista de la cancion: ");
            String artista = in.nextLine();
            System.out.println("Album de la cancion: ");
            String album = in.nextLine();
            System.out.println("Duracion de la cancion: ");
            String duracion = in.nextLine();

            int id = generateIDsong(ipod.getCanciones());
            ipod.addSongToList(titulo, artista, album, duracion, id);

            for (ICancion cancion : ipod.getCanciones()) {
                System.out.println("Canciones: " + cancion.getID() + " " + cancion.getTitle());
            }

        }else {
            System.out.println("Ya no hay espacio para mas canciones, maximo 50");
        }

    }

    public static void deleteSong(Ipod ipod, Scanner in) throws Exception {
        if (!(ipod.getCanciones().isEmpty())) {
            int i = 1;
        for (ICancion cancion: ipod.getCanciones()){
            System.out.println(i+") Titulo: "+cancion.getTitle() + " Artista: "+ cancion.getArtist());
            i++;
        }
        System.out.println("¿Que cancion desea eliminar?");
        int index = in.nextInt()-1;
            in.nextLine();
        ipod.deleteSongFromList(index);

        }else {
            System.out.println("Alerta: No hay canciones agregue una");
        }

    }

    public static int generateIDsong(ArrayList<ICancion> canciones){
        int id = 1;
        for (ICancion cancion: canciones){
            id = id +1;
        }
        return id;
    }


    public static void nextsong(Ipod ipod) throws Exception {
        if (!(ipod.getCanciones().isEmpty())) {
            try {
                if (!(ipod.getActualIndex() == ipod.getCanciones().size() - 1)) {
                    ipod.setActualIndex(ipod.Next(ipod.getActualIndex()));
                } else {
                    ipod.setActualIndex(0);
                }

            } catch (Exception e) {
                System.out.println("ALERTA: Error en pasar de cancion");
            }
            System.out.println("Cancion actual parcial: " + ipod.getCanciones().get(ipod.getActualIndex()).getTitle());
        }else {
            System.out.println("Alerta: No hay canciones agregue una");
        }
    }

    public static void previoussong(Ipod ipod) throws Exception {
        if (!(ipod.getCanciones().isEmpty())) {
        try {
            if (!(ipod.getActualIndex() == 0)){
                ipod.setActualIndex(ipod.Prev(ipod.getActualIndex()));
            }else{
                ipod.setActualIndex(ipod.getCanciones().size()-1);
            }

        }catch (Exception e){
            System.out.println("ALERTA: Error en pasar de cancion");
        }
        System.out.println("Cancion actual parcial: "+ipod.getCanciones().get(ipod.getActualIndex()).getTitle());
        }else {
            System.out.println("Alerta: No hay canciones agregue una");
        }

    }

    public static void playfavsong(Ipod ipod,Scanner in) throws Exception{
        if (!(ipod.getFavs().isEmpty())) {
            int i = 1;
            for (ICancion fav : ipod.getFavs()) {
                System.out.println(i + ") Titulo: " + fav.getTitle());
                i++;
            }
            System.out.println("¿Que cancion desea reproducir");
            int index = in.nextInt();
            in.nextLine();
            ICancion cancionfav = ipod.getFavs().get(index - 1);


            for (ICancion cancion : ipod.getCanciones()) {
                if (cancion.getTitle().equalsIgnoreCase(cancionfav.getTitle()) && cancion.getArtist().equalsIgnoreCase(cancionfav.getArtist())) {
                    ipod.setActualIndex(cancion.getID() - 1);

                }
            }
            System.out.println("Cancion actual parcial: " + ipod.getCanciones().get(ipod.getActualIndex()).getTitle());
        }else {
            System.out.println("Alerta: No hay canciones favoritas");
        }
    }

    public static void deletefav(Ipod ipod, Scanner in) throws Exception {
        if (!(ipod.getFavs().isEmpty())) {
            int i = 1;
            for (ICancion cancion: ipod.getFavs()){
                System.out.println(i+") Titulo: "+cancion.getTitle() + " Artista: "+ cancion.getArtist());
                i++;
            }
            System.out.println("¿Que cancion desea eliminar?");
            int index = in.nextInt()-1;
            in.nextLine();
            ipod.deleteSongFromTop10(index);

        }else {
            System.out.println("Alerta: No hay canciones agregue una");
        }

    }


   public static void pausebutton(Ipod ipod){
        if (ipod.isPlaying()){
            ipod.setPlaying(false);
        }else{
            ipod.setPlaying(true);
        }

   }

   public static void ipodUI(Ipod ipod) {

       System.out.println(" ");
       System.out.println("++++++++++++IPOD+++++++++++++");
       System.out.println(" ");
       if (!(ipod.isOn())) {
           System.out.println("-IPOD APAGADO-");
       }
       if (ipod.isIsblocked()){
           System.out.println("-IPOD BLOQUEADO-");
       }
       System.out.println(" ");
       System.out.println("***TUS CANCIONES***");
       if (!(ipod.getCanciones().isEmpty())){
           int i = 1;
       for (ICancion cancion : ipod.getCanciones()) {
           System.out.println(i + ") " + cancion.getTitle() + " " + cancion.getArtist());
           i++;
       }
   }
       System.out.println("*******************");
       System.out.println(" ");
       System.out.println("***TU TOP 10***");
       if (!(ipod.getCanciones().isEmpty())) {
           int j = 1;
           for (ICancion cancion : ipod.getFavs()) {
               System.out.println(j + ") " + cancion.getTitle() + " " + cancion.getArtist());
               j++;
           }
       }
       System.out.println("*******************");
       System.out.println(" ");
       System.out.println("***CANCION ACTUAL***");
       if (!(ipod.getCanciones().isEmpty())) {
           System.out.println("" + ipod.getCanciones().get(ipod.getActualIndex()).getTitle());
           if (ipod.isPlaying()){
               System.out.println("-Reproduciendo");
               System.out.println("-Volumen: "+ipod.getVolume());
           }else { System.out.println("-Pausada");}

       }

       System.out.println(" ");
       System.out.println("+++++++++++++++++++++++++++++");
       System.out.println(" ");

   }






}
