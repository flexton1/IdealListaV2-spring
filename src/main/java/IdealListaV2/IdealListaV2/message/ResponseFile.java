package IdealListaV2.IdealListaV2.message;



public class ResponseFile {
    private String title;
    private String link;
    private String playlist;
    public ResponseFile(String title, String link, String playlist) {
      this.title = title;
      this.link = link;
      this.playlist = playlist;
    }

    public String getTitle(){
      return title;
    }

    public String getLink(){
      return link;
    }

    public String getPlaylist() {return playlist;};
   
  }