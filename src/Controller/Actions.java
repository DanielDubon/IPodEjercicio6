package Controller;

import Model.Cancion;
import Model.Ipod;

public class Actions {

    public static void addSongtofavorites(Ipod ipod, int index, Cancion cancion) throws Exception {
        try {
            ipod.addToFavorite(cancion);
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






}
