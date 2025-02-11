package org.kuraterut.entities;

import org.kuraterut.entities.veterinaryclinic.VeterinaryClinic;
import org.kuraterut.entities.alives.Animal;
import org.kuraterut.entities.alives.humans.Employee;
import org.kuraterut.entities.alives.animals.herbo.Herbo;
import org.kuraterut.entities.inventory.IInventory;

import java.io.PrintStream;
import java.util.ArrayList;

public class Zoo {
    private static int id = 0;
    private String name;
    private VeterinaryClinic clinic;
    private PrintStream out;

    ArrayList<ZooItem> zooItems;

    public Zoo(String name, VeterinaryClinic clinic, PrintStream out) {
        this.name = name;
        this.clinic = clinic;
        this.zooItems = new ArrayList<>();
        this.out = out;
    }

    public String getName() {
        return name;
    }

    public VeterinaryClinic getClinic() {
        return clinic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClinic(VeterinaryClinic clinic) {
        this.clinic = clinic;
    }

    public ArrayList<ZooItem> getZooItems() {
        return zooItems;
    }

    public boolean addZooItem(ZooItem zooItem) {
        if(zooItem instanceof Animal && !clinic.checkAnimal((Animal) zooItem)) return false;
        if(zooItem instanceof IInventory){
            ((IInventory) zooItem).setNumber(id);
            id++;
        }
        this.zooItems.add(zooItem);
        return true;
    }

    public void printTotalFood(){
        int count = 0;
        for(ZooItem zooItem : zooItems){
            if(zooItem instanceof Animal){
                count += ((Animal) zooItem).getFood();
            }
        }
        out.println("Total Food: " + count);
    }

    public void printAnimals(){
        out.println("Animals list:");
        for(ZooItem zooItem: zooItems){
            if(zooItem instanceof Animal){
                Animal animal = (Animal) zooItem;
                animal.print(out);
            }
        }
    }


    public void printInventory(){
        out.println("Inventory list:");
        for(ZooItem zooItem: zooItems){
            if(zooItem instanceof IInventory){
                IInventory inventory = (IInventory) zooItem;
                inventory.print(out);
            }
        }
    }

    public void printEmployees(){
        out.println("Employees list:");
        for(ZooItem zooItem: zooItems){
            if(zooItem instanceof Employee){
                Employee employee = (Employee) zooItem;
                employee.print(out);
            }
        }
    }

    public void printContactAnimals(){
        out.println("Contact animals list:");
        for(ZooItem zooItem: zooItems){
            if(zooItem instanceof Herbo){
                Herbo herbo = (Herbo) zooItem;
                if(herbo.canCommunicate()) herbo.print(out);
            }
        }
    }

    public void printAllInfo(){
        printAnimals();
        printContactAnimals();
        printTotalFood();
        printInventory();
        printEmployees();
    }
}
