import java.util.ArrayList;
import java.util.HashMap;

public class Location 
{
    private String name;
    private String description;
    private ArrayList<Item> itemsAtLocation;
    private HashMap<String,Location> myMap;
    public Location(String name, String description)
    {
        this.name=name;
        this.description= description;
        this.itemsAtLocation=new ArrayList<Item>();
        this.myMap= new HashMap<String,Location>();
        
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public void setName(String n)
    {
        name=n;
    }
    public void setDescription(String d)
    {
        description=d;
    }
    public void addItem(Item a)
    {
       itemsAtLocation.add(a);
                
         
    }
      
    public boolean hasItem(String itemName)
    {
        for (int i=0; i<itemsAtLocation.size();i++)
        {
            if (itemName.equalsIgnoreCase(itemsAtLocation.get(i).getName()))
            {
                return true;
            }

        }
        return false;
    }
    public Item getItem(String itemName)
    {
        for (int i=0; i<itemsAtLocation.size();i++)
        {
            if (itemName.equalsIgnoreCase(itemsAtLocation.get(i).getName()))
            {
                return itemsAtLocation.get(i);
            }

        }
        return null;

    }
    public Item getItem(int index)
    {
        if(index >=0)
        {
            if(index <= itemsAtLocation.size()-1)
            {
                return itemsAtLocation.get(index);
            }
        }
        return null;

    }
    public int numItems()
    {
       int count=0;
       for(int i=0; i<itemsAtLocation.size();i++) 
       {
           if(itemsAtLocation.get(i) != null)
           {
               count++;
           }
           else{
               return count;
           }
       }
       return count;
    }
    public Item removeItem(String itemName)
    {
        Item removedItem=null;
        for (int i=0; i<itemsAtLocation.size();i++)
        {
            if (itemName.equalsIgnoreCase(itemsAtLocation.get(i).getName()))
            {
                removedItem=itemsAtLocation.get(i);
                itemsAtLocation.remove(i);
                return removedItem;
            }

        }
        return null;
    }
    public void connect(String direction, Location locatioName)
    {
        myMap.put(direction,locatioName);

    }
    public boolean canMove(String direction)
    {
        return myMap.containsKey(direction);
    }
    public Location getLocation(String direction)
    {
       return  myMap.get(direction);
    }
    
}

