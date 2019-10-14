package p.fetch;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="favoritelist")
public class FavoriteList {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "image")
    private int image;

    @ColumnInfo(name = "iname")
    private String name;


    @ColumnInfo(name = "idescription")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

}