package p.fetch;

public class Item {
    private int ImageResource,Id;
    private String Name;
    private String Description;


    public Item (int imageResource, String name, String description, int id){

        ImageResource=imageResource;
        Name=name;
        Description=description;
        Id=id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getImageResource() {
        return ImageResource;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setImageResource(int imageResource) {
        ImageResource = imageResource;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
//check