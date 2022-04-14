package IdealListaV2.IdealListaV2.message;



public class ResponseFile {
    private String title;
    private String link;
    public ResponseFile(String title, String link) {
      this.title = title;
      this.link = link;
    }

    public String getTitle(){
      return title;
    }

    public String getLink(){
      return link;
    }
   
  }