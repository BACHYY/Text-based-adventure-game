public class Item 
{
    private String name;
    private String type;
    private String description;

    public Item(String name , String type, String description)
    {
        this.name=name;
        this.type=type;
        this.description=description;

    }
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public String getDescription()
    {
        return description;
    }
    public void setName(String n)
    {
        name= n;
        
    }
    public void setType(String t)
    {
        type= t;
    }
    public void setDescription(String d)
    {
       description=d;
    }
    public String toString()
    {
        String getInformation= name + "[" + type +"]" + ":" + description;
        return getInformation;

    }
    
    

}
