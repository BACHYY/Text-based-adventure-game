import java.util.ArrayList;
import java.util.Scanner;
public class Driver 
{
    static Location currLocation;
    static ContainerItem myInventory= new ContainerItem("Backpack", "Inventory", "Can hold different set of items");
    static void createWorld()
    {
      Location kitchen= new Location("Kitchen", "a room in which meals are cooked or prepared");
      Location hallway= new Location("Hallway", "a passage in a house with rooms down either side");
      Location bedroom= new Location("Bedroom", " time to sleep!");
      Location lawn= new Location("Lawn", "We are outside of the house.");
      
      kitchen.connect("north", hallway);
      hallway.connect("south", kitchen);
      hallway.connect("east", bedroom);
      bedroom.connect("west", hallway);
      hallway.connect("west", lawn);
      lawn.connect("east",hallway);
      
      Item knife = new Item("Knife", "blade", "used for cutting or as a weapon");
      Item turkey = new Item("Turkey", "Food", "smells good!");
      Item lamp = new Item("Lamp", "Electronic", "sitting near the bed");
      Item shoes = new Item("Shoe", "Clothing", "Large size shoes for big foot.");
      Item ball = new Item("Ball", "Sports", "lets play!");
      Item money = new Item("Money", "paper", "a current medium of exchange in the form of banknotes");
      Item pen = new Item("Pen", "Plastic", "an instrument used for writing.");
      
      kitchen.addItem(knife);
      kitchen.addItem(turkey);
      hallway.addItem(shoes);
      bedroom.addItem(lamp);
      lawn.addItem(ball);
      currLocation = kitchen;
      ContainerItem vault = new ContainerItem("VAULT", "Container", "used for keeping valuable things safe.");
      ContainerItem desk = new ContainerItem("Desk", "Container", "a table usually with drawers in it.");
      vault.addItem(money);
      desk.addItem(pen);
      hallway.addItem(desk);
      bedroom.addItem(vault);
    }
    public static void main(String []args)
    {
      createWorld();
      Scanner scan= new Scanner(System.in);
      boolean check=true;
      System.out.println("Welcome to this text-based adventure Game!");
      while(check)
      {
        System.out.println("Enter Command:");
        String command=scan.nextLine();
        String [] wordsSeperated = command.split(" ");
        String typeOfCommand;
        String parameter = "";
        boolean num_commands = false;
        // false means 1 command
        //true means 2 commands
        for(int a = 0; a < command.length(); a++){
            
            if(command.charAt(a) == ' ' ){
                num_commands = true;
            }
        }
        typeOfCommand = wordsSeperated[0];
        
        if(num_commands == true){
            parameter = wordsSeperated[1];
        }
        switch(typeOfCommand)
        {
          case "quit":
          {
            System.out.println("Thanks for playing!");
            check= false;
            break;
          }
          case "look":
          {
            System.out.println(currLocation.getName() + "-" + currLocation.getDescription() + ":");
            for(int i=0; i<currLocation.numItems();i++)
            {
              System.out.println( "+" + currLocation.getItem(i).getName());
            }
            break;
          }
          case "examine":
          {
            if(parameter=="")
            {
              System.out.println("please type item's name");

            }
            else
            {
              if(currLocation.hasItem(parameter))
              {
                System.out.println(currLocation.getItem(parameter));
              }
              else{
                System.out.println("Cannot find that item");

              }
            }
            break;
          }
          case "go":
          {
            String direction1="north";
            String direction2="south";
            String direction3="east";
            String direction4="west";
           if(parameter=="")
            {
              System.out.println("please type direction name");
            }
            else if(parameter.equals(direction1))
           {
              if(currLocation.canMove(parameter))
              {
              currLocation= currLocation.getLocation(parameter);// points at new location.
              }
              else{
                System.out.println("there is no location connected in that direction");
              }
            }
            else if (parameter.equals(direction2))
            {
              if(currLocation.canMove(parameter))
              {
               currLocation= currLocation.getLocation(parameter);// points at new location.
              }
              else{
                System.out.println("there is no location connected in that direction");
              }
            }
            else if (parameter.equals(direction3))
            {
              if(currLocation.canMove(parameter))
              {
               currLocation= currLocation.getLocation(parameter);// points at new location.
              }
              else{
                System.out.println("there is no location connected in that direction");
              }
            }
            else if (parameter.equals(direction4))
            {
              if(currLocation.canMove(parameter))
              {
               currLocation= currLocation.getLocation(parameter);// points at new location.
              }
              else{
                System.out.println("there is no location connected in that direction");
              }
           }
           else{
            System.out.println("type valid direction name");

           }
           break;


          }
          case "inventory":
          {
            System.out.println(myInventory);
            break;
          }
          case "take":
          {
            if(wordsSeperated.length <= 2)
            { 
             if(currLocation.hasItem(parameter))
              {
                Item removedItem=currLocation.removeItem(parameter);
                myInventory.addItem(removedItem);
              }
              else{
                System.out.println("Cannot find that item here");
              }
              break;
            }
            else if (wordsSeperated.length <=  4){

              //take pen from desk
              //take desk from pen
              String containerName = wordsSeperated[3]; //containerName

              if (currLocation.hasItem(containerName)) {
                //container found
                Item currContainer =  currLocation.getItem(containerName); //container 
                if(currContainer instanceof ContainerItem)
                {
                  ContainerItem currContainer1 = (ContainerItem) currLocation.getItem(containerName); //container 
                  if (currContainer1.hasItem(parameter)) {
                    //item found
                    Item removedItem = currContainer1.removeItem(parameter);
                    myInventory.addItem(removedItem);
                  }
                  else {
                    //not found
                    System.out.println("Item not found in the container");
                  }

                }
                else{
                  System.out.println("item is not a Container");
                }

                

              }
              else {
                //Invalid container name
                System.out.println("Invalid Container Name");
              }

              
            }
            else {
              System.out.println("Invalid Command!");
            }
            break;
          }
          case "put":
          {

            //put pen in desk
            //put desk in pen

            //container name
            String containerName = wordsSeperated[3];

            //if item in inventory
            if (myInventory.hasItem(parameter)){
              

              //container is in the location
              if (currLocation.hasItem(containerName)){
                Item currContainer =  currLocation.getItem(containerName); //container 
                if(currContainer instanceof ContainerItem)
                {
                  ContainerItem currContainer1 = (ContainerItem) currLocation.getItem(containerName);
                  Item myItem = myInventory.removeItem(parameter);
                  currContainer1.addItem(myItem);
                }
                else{
                  System.out.println("item is not a Container");
                }
              }
              else {
                //container is invalid
                System.out.println("ContainerItem is not valid");
              }

            }
            else {
              //item not in inventory
              System.out.println("Item not in inventory");
            }
            break;

          }
          case "drop":
          {
            if(myInventory.hasItem(parameter))
            {
              Item removedItem=myInventory.removeItem(parameter);
              currLocation.addItem(removedItem);
            }
            else{
              System.out.println("Cannot find that item in the inventory");
            }
            break;
          }
          case "help":
          {
            System.out.println(" help : give the detailed list of all commands available");
            System.out.println(" look : tells you the current position on the map. ");
            System.out.println(" examine : examine the item at the location");
            System.out.println(" quit : takes you out of the game.");
            System.out.println(" go : moves your character to the given direction only if that is a  valid command.");
            System.out.println(" inventory : shows the list of items you have in your inventory.");
            System.out.println(" take : your character will pick the item from location and will put in his inventory");
            System.out.println(" drop : your chracter will drop the item from his bag to his current location");
            break;
          }

          default:
          {
            System.out.println("I don't know how to do that");
          }
        }
        
        


      }

     


    }
     

    
}
    