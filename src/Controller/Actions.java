package Controller;

import Model.Cancion;
import Model.ICancion;
import Model.Ipod;

import java.util.ArrayList;
import java.util.Scanner;

public class Actions {

    public static void addSongtofavorites(Ipod ipod,ICancion cancion) throws Exception {
        try {
            if (!(ipod.getFavs().size() == 10)) {
                ipod.addToFavorite(cancion);
            }else {
                System.out.println("Lista llena: maximo 10 canciones");
            }
        }catch (Exception exception){
            System.out.println("Error al agregar cancion");
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
        in.nextLine();
        System.out.println("Titulo de la cancion: ");
        String titulo = in.nextLine();
        System.out.println("Artista de la cancion: ");
        String artista = in.nextLine();
        System.out.println("Album de la cancion: ");
        String album = in.nextLine();
        System.out.println("Duracion de la cancion: ");
        String duracion = in.nextLine();

        int id = generateIDsong(ipod.getCanciones());
        ipod.addSongToList(titulo, artista,album,duracion,id);

        for (ICancion cancion: ipod.getCanciones()){
            System.out.println("Canciones: "+cancion.getID()+" "+cancion.getTitle());
        }

    }

    public static void deleteSong(Ipod ipod, Scanner in) throws Exception {
            int i = 1;
        for (ICancion cancion: ipod.getCanciones()){
            System.out.println(i+") Titulo: "+cancion.getTitle() + "Artista: "+ cancion.getArtist());
            i++;
        }
        System.out.println("¿Que cancion desea eliminar?");
        int index = in.nextInt()-1;
        ipod.deleteSongFromList(index);


    }

    public static int generateIDsong(ArrayList<ICancion> canciones){
        int id = 1;
        for (ICancion cancion: canciones){
            id = id +1;
        }
        return id;
    }


    public static void nextsong(Ipod ipod) throws Exception {

        try {
            if (!(ipod.getActualIndex() == ipod.getCanciones().size()-1)) {
                ipod.setActualIndex(ipod.Next(ipod.getActualIndex()));
            }else{
                ipod.setActualIndex(0);
            }

        }catch (Exception e){
            System.out.println("ALERTA: Error en pasar de cancion");
        }
        System.out.println("Cancion actual parcial: "+ipod.getCanciones().get(ipod.getActualIndex()).getTitle());

    }

    public static void previoussong(Ipod ipod) throws Exception {

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

    }

    public static void playfavsong(Ipod ipod,Scanner in) throws Exception{
        if (!(ipod.getFavs().isEmpty())) {
            int i = 1;
            for (ICancion fav : ipod.getFavs()) {
                System.out.println(i + ") Titulo: " + fav.getTitle());

            }
            System.out.println("¿Que cancion desea reproducir");
            int index = in.nextInt();
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







}
