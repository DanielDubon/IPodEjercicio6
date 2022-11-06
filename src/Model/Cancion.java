package Model;

public class Cancion implements ICancion{

    private String title;
    private String artist;
    private String album;
    private String duration;
    private int id;

    public Cancion(String title, String artist, String album, String duration, int id){
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.id = id;
    }
    @Override
    public void setTitle(String _title) {
        this.title = _title;
    }

    @Override
    public String getTitle() {
       return title;
    }

    @Override
    public void setArtist(String _artist) {
        this.artist = _artist;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public void setAlbum(String _album) {
        this.album = _album;
    }

    @Override
    public String getAlbum() {
        return album;
    }

    @Override
    public void setDuration(String _duration) {
        this.duration = _duration;
    }

    @Override
    public String getDuration() {
        return duration;
    }

    @Override
    public void setID(int _id) {
        this.id = _id;
    }

    @Override
    public int getID() {
        return id;
    }
}
