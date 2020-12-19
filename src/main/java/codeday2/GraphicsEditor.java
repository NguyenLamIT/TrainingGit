package graphiceditor.after;

public class GraphicsEditor {
  private IFile file;


  public void openFile(String fileName) throws Exception{
    String extension = fileName.substring(fileName.length() - 3);
    switch (extension) {
      case "bmp":
        file = new Bmp();
        break;
      case "gif":
        file = new Gif();
        break;
      case "png":
        file = new Png();
        break;
      case "jpg":
        file = new Jpg();
        break;
      default:
        throw(new Exception("Unknown file type"));
    }

    file.openFile(fileName);
  } 
}
