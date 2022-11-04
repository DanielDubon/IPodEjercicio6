package Controller;

import Model.ICancion;

public class Actions implements IIpod_simulator{
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
        return 0;
    }

    @Override
    public float setVolume(float volume) {
        return 0;
    }

    @Override
    public int Prev(int actual_index) {
        return 0;
    }

    @Override
    public int Next(int actual_index) {
        return 0;
    }

    @Override
    public int getActualIndex() {
        return 0;
    }

    @Override
    public void setActualIndex(int actual_index) throws Exception {

    }

    @Override
    public void addToFavorite(ICancion _song) throws Exception {

    }

    @Override
    public ICancion selectSpecificSong(int index) throws Exception {
        return null;
    }

    @Override
    public ICancion selectSpecificFavoriteSong(int index) throws Exception {
        return null;
    }

    @Override
    public ICancion[] getAllSongs() {
        return new ICancion[0];
    }

    @Override
    public String getStatus(boolean _isON, boolean _isLocked, boolean _isPlaying, ICancion _actualSong) {
        return null;
    }

    @Override
    public boolean isValidIndex(int index) {
        return false;
    }

    @Override
    public void addSongToList(String _titulo, String _artista, String _album, String _duracion, int _id) throws Exception {

    }

    @Override
    public void deleteSongFromList(int index) throws Exception {

    }

    @Override
    public void deleteSongFromTop10(int index) throws Exception {

    }
}
