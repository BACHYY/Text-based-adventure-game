import java.util.ArrayList;
public class ContainerItem extends Item
{
    private ArrayList<Item> items;

    public ContainerItem(String name,String type, String description)
    {
        super(name, type, description);
        items= new ArrayList<Item>();
    }

    public void addItem(Item item)
    {
        items.add(item);
    }
    public boolean hasItem(String itemName)
    {
        for (int i=0; i<items.size();i++)
        {
            if (itemName.equalsIgnoreCase(items.get(i).getName()))
            {
                return true;
            }

        }
        return false;
    }
    public Item removeItem(String itemName)
    {
        Item removedItem=null;
        for (int i=0; i<items.size();i++)
        {
            if (itemName.equalsIgnoreCase(items.get(i).getName()))
            {
                removedItem=items.get(i);
                items.remove(i);
                return removedItem;
            }

        }
       return null;
    }
    @Override
    public String toString()
    {   
        String getInformation=super.getName() + "[" + super.getType() +"]" + ":" + super.getDescription() + ":" + "\n";
        for (int i=0;i<items.size();i++)
        {
           getInformation+= " + " + items.get(i).getName() + "\n";
        }
        return getInformation;


    }
}
