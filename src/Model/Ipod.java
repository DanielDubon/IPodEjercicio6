package Model;

import java.util.ArrayList;



public class Ipod implements IIpod_simulator {



    private ArrayList<ICancion> canciones = new ArrayList<>();
    private ArrayList<ICancion> favs = new ArrayList<>();

    private int actualindex=0;
    private float volume = 0;
    private boolean isblocked;
    private boolean isOn;


    @Override
    public boolean SwitchONOFF(boolean actual_state) {
    return false;
    }

    @Override
    public boolean LockUnlockDevice(boolean actual_locked_state) {
        return false;
    }

    @Override
    public float getVolume() {
        return volume;
    }

    @Override
    public void setVolume(float volume) {
        this.volume = volume;
    }

    @Override
    public int Prev(int actual_index) {
        return actual_index-1;
    }

    @Override
    public int Next(int actual_index) {
        return actual_index+1;
    }

    @Override
    public int getActualIndex() {
        return actualindex;
    }

    @Override
    public void setActualIndex(int actual_index) throws Exception {

        this.actualindex = actual_index;

    }

    @Override
    public void addToFavorite(ICancion _song) throws Exception {
        favs.add(_song);
    }

    @Override
    public ICancion selectSpecificSong(int index) throws Exception {

    return canciones.get(index);

    }

    @Override
    public ICancion selectSpecificFavoriteSong(int index) throws Exception {

        return favs.get(index);
    }

    @Override
    public ICancion[] getAllSongs() {
        ICancion[] ic = new ICancion[50];
        for (int i = 0; i<= canciones.size(); i++){
            ic[i] = canciones.get(i);

        }

        return ic;
    }

    @Override
    public String getStatus(boolean _isON, boolean _isLocked, boolean _isPlaying, ICancion _actualSong) {

        return null;
    }

    @Override
    public boolean isValidIndex(int index) {

        for (ICancion cancion: canciones){
            if (index == cancion.getID()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addSongToList(String _titulo, String _artista, String _album, String _duracion, int _id) throws Exception {

               if (!(canciones.size()== 50)) {
                   Cancion cancion = new Cancion(_titulo, _artista, _album, _duracion, _id);
                   canciones.add(cancion);
               }else{
                   System.out.println("ALERTA: ¡Limite de 50 canciones alcanzado! no se agrego la cancion.");
               }
    }

    @Override
    public void deleteSongFromList(int index) throws Exception {

        canciones.remove(index);
    }

    @Override
    public void deleteSongFromTop10(int index) throws Exception {
        favs.remove(index);
    }
}
